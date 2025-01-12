import numpy as  np 
from  numba  import  njit
import matplotlib.pyplot as plt


#@njit
def FDM(dx,dt,N,J):
    """
    Esta  función calcula  la solución aproximada de la EDP dada por  diferencias  finitas 
    ENTRADA:
    dx[float] :  delta x
    dt[float] :  delta t
    J[int]    :  pasos  espaciales,  en x
    N[int]    :  pasos  temporales,  en  t 
    
    SALIDA:
    U[array] :  solución aproximada de la EDP 
    """
    U=np.ones((J+1,N+1))
    X=np.linspace(0,1,J+1)
    K=(dt/dx)**2
    print(K<1)

    
    # condiciones iniciales 
    U[:,0]=0
    U[:,1]=dt * np.sin(X)
    
    #condiciones de frontera
    U[0,:]=0
    U[-1,:]=0
    
    #nodos  internos
    for n in range(1,N):
        Umas=np.roll(U, -1, axis=0)
        Umenos=np.roll(U, 1, axis=0)
        U[1:-1,n+1] = 2*U[1:-1,n] - U[1:-1,n-1] + K * ( Umas[1:-1,n]- 2*U[1:-1,n]+ Umenos[1:-1,n])


    return U


def grafica(U,Tfinal):
    plt.imshow(U, extent=[0, Tfinal, 0, 1], aspect='auto', cmap='hot')
    plt.colorbar(label='u(x, t)')
    plt.ylabel('Space')
    plt.xlabel('Time')
    plt.title('solución ecuación de onda')
    plt.show()
    
    
if __name__ =="__main__":
    
    N=100
    J=99
    Tfinal=0.5
    dx=1/J
    dt=Tfinal/N
    U=FDM(dx,dt,N,J)
    grafica(U,Tfinal)
    #print(U)