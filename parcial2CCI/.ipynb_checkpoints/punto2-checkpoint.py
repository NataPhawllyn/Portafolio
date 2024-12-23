import numpy as np 
from scipy.special import gamma
import sys


def guardar_cadena_en_archivo(cadena, alpha):
    #filename = f"cadena_alpha_{alpha}.txt"  # punto 2
    filename = f"cadena_N_{alpha}.txt"       # punto 3
    np.savetxt(filename, cadena)

def funcionPi(v,d,m,x):
    z=(x-m)/d
    divGamma=gamma((v+1)/2)/(gamma(v/2)*(np.sqrt(v*np.pi)*d))
    base=1+(1/v)*z**2
    expo=-(v+1)/2
    
    funcionPi=divGamma*base**expo
    
    return funcionPi

def distriQ(y,x,a):
    fraccion=1/(np.sqrt(2*np.pi)*a)
    expo=-(y-x)**2/(2*a**2)
        
    Q=fraccion*np.exp(expo)
        
    return Q

def transT(v,d,m,a,u0,u1):
    num=funcionPi(v,d,m,u1)*distriQ(u0,u1,a)
    den=funcionPi(v,d,m,u0)*distriQ(u1,u0,a)
    
    Trans=num/den
    
    return Trans

def MCMC(N,a):
    v=3       # establecemos los  valores de los parametros 
    m=1
    d=1
        
        
    u0=1   # determinamos el valor inicial de la cadena 
    cadena=[u0]
    
    n=0   # propuestas aceptadas 
    n1=0  # propuestas  totales 
    while n<N :
        u1= np.random.normal(loc=u0, scale=a)  # propuesta de siguiente paso 
        T=transT(v,d,m,a,u0,u1)                # probabilidad de transicón 
            
        u_test=np.random.uniform(0, 1)      # numero de prueba
            
        if u_test <=T:
            u0=u1
            cadena.append(u1)
            n+=1
        n1+=1
    
    frac=(n/n1)*100  #calculo de la  fracción de aceptación  en porcentaje
    return (cadena,frac)
    
if __name__ == "__main__":
    #punto 2
    # a=float(sys.argv[1])
    # N=1000
    
    #punto 3 
    N=float(sys.argv[1])
    a=1
    
    cadena,frac=MCMC(N,a)
    guardar_cadena_en_archivo(cadena, N)
    #print ("la fracción de aceptación para {} es de {:.2f}% ".format(a,frac))
    
    
    
            
        
        