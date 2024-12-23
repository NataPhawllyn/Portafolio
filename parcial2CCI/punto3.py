import numpy as np 
from scipy.special import gamma
from scipy.stats import uniform
from scipy.stats import multivariate_normal
import sys

def leer_cadena_de_archivo():
    filename = f"cadena_N_100.0.txt"
    return np.loadtxt(filename)

def guardar_cadena_en_archivo(cadena, N):
    filename = f"cadena_parametros_N_{N}.txt"       # punto 3
    np.savetxt(filename, cadena)


def funcionPi(v,d,m,x):
    z=(x-m)/d
    divGamma=gamma((v+1)/2)/(gamma(v/2)*(np.sqrt(v*np.pi)*d))
    base=1+(1/v)*z**2
    expo=-(v+1)/2
    
    funcionPi=divGamma*base**expo
    
    return funcionPi

def funcionVeri(v,d,m,data):
    pi_val=funcionPi(v,d,m,data)
    prod=np.prod(pi_val)
    return prod

def funcionPOst(u,data):
    v,d,m=u
    uniformes=uniform.pdf(v, loc=0.1, scale=10 - 0.1)*uniform.pdf(d, loc=0.1, scale=10 - 0.1)*uniform.pdf(m, loc=-5, scale=5 +5)
    P_vdm=funcionVeri(v,d,m,data)*uniformes
    
    return P_vdm
    
def transT(u0,u1,data):

    cov = [[1, 0, 0], [0, 1, 0], [0, 0, 1]] # varianzas  independientes 
    
    num=funcionPOst(u1,data)*multivariate_normal.pdf(u0, mean=u1, cov=cov)
    den=funcionPOst(u0,data)*multivariate_normal.pdf(u1, mean=u0, cov=cov)
    
    Trans=num/den
    
    return Trans

def MCMC(N,data):
    v0=3       # establecemos los  valores de los parametros 
    m0=1
    d0=1
    
    u0=[v0,d0,m0]
    cadena=[u0]
    cov = [[1, 0, 0], [0, 1, 0], [0, 0, 1]] # varianzas  independientes 
    
    n=0   # propuestas aceptadas 
  
    while n<N :
        u1= np.random.multivariate_normal(u0, cov)  # propuesta de siguiente paso 
        T=transT(u0,u1,data)                # probabilidad de transicón 
            
        u_test=np.random.uniform(0, 1)      # numero de prueba
            
        if u_test <=T:
            u0=u1
            cadena.append(u1)
            n+=1
        
    
    return (cadena)

if __name__ == "__main__":
    data=leer_cadena_de_archivo()  # datos  generados por  otra  cadena  de MCMC t-student N=1000
    N=float(sys.argv[1])           

    
    cadena=MCMC(N,data)
    guardar_cadena_en_archivo(cadena, N)
    
    
    