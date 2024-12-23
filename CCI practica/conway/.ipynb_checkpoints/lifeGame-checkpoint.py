from mpi4py import MPI
import random
import numpy as  np
from  numba  import  njit
import  numexpr  as ne
import matplotlib.pyplot as plt
    
    
def semilla(densidad):
    """
    Esta  función crea el plano semilla del  juego con una densidad poblacional dada
    
    ENTRADA:
        densidad[float] :  numero entre  cero  y 1  que representa  el porcentaje de  densidad poblacional.
    SALIDA:
        grilla[np.array] :  grilla  con la  semilla  puesta  en el  tiempo z=0
    """
    
    grilla=np.zeros((202,202,200))
    
    lista=np.arange(0,200**2)
    tamaño= int(200**2*densidad)
    indices=np.random.choice(lista, tamaño)
    
    centro=grilla[1:-1,1:-1,0]
    centro[indices//200, indices %200]=1 # inicio  la  grilla  con  la densidad dada 
    
    return grilla
    
    
def evaluacion(grilla,i):
    """
    esta  función  evalua  las  condiciones de  las  celulas y sus  vecinos para determinar  su evulucion usando las  reglas.
    
    ENTRADA:
        grilla[np.array] :  tablero del  juego. 
        i[int] :  paso evolutivo en el que esta  actualmente. 
    SALIDA:
        griila[np.array] :  tablero actualizado  en la posición  i+1 
    """
    A=grilla[:,:,i]
    Aplus1=grilla[1:-1,1:-1,i+1]
    centro=(A[1:-1,1:-1]==1)     # celula  central  a evolucionar 
    vecinos = (A[:-2,1:-1]) + (A[2:,1:-1]) + (A[1:-1,:-2]) + (A[1:-1,2:]) + (A[:-2,:-2]) + (A[2:,:-2]) + (A[:-2,2:]) + (A[2:,2:])    #izq,der,arr,abj,diagonales sup, diagonales inf 
    
    Aplus1[np.logical_and(centro, np.logical_or(vecinos == 2, vecinos == 3))] = 1
    Aplus1[np.logical_and(centro, np.logical_not(np.logical_or(vecinos == 2, vecinos == 3)))] = 0
    Aplus1[np.logical_and(~centro, vecinos == 3)] = 1
    
    
    return grilla 
    
def juego(densidad):
    """
     Esta  función evoluciona el juego de la  vida  por 200 pasos  temporales  y calcula la densidad del tablero  final.
     ENTRADAS: 
         densidad [float] :  valor de la  densidad de  vivas  para el tablero inicial ,  VALOR  ENTRE  0-1
     SALIDAS:
         densidad_final[float] : valor de la densidad de supervivencia del tablero  final, valor entre 0-1
    """
    grilla=semilla(densidad)  #inicializar
    
    i=0
    while i<199:
        grilla=evaluacion(grilla,i)  #evolucionar
        i+=1
    
    densidad_final=np.sum(grilla[:,:,-1])/200**2  #calcular densidad
    
    return densidad_final

def  principal():
    """
    Funci+on  que paraleliza   el proceso de evaluar las densidades finales para  distintas densidades iniciales.
     y  grafica   la  dencidad  inicial, vs  final.
    """
    
    comm = MPI.COMM_WORLD
    size = comm.Get_size()
    rank = comm.Get_rank()
    
    densidades=np.linspace(0,1,48)  # encuentro  50  distintas densidades 
    dens=np.zeros((48))
    
    n=4                    #  numeros  de procesadores 
    for  i in range(1,13):   # divido  las densidades de  forma  espaciada e intercalada  entre los procesadores
        if rank == 0:
            dens[(i*n)-n]=juego(densidades[(i*n)-n])  #  se   asigna  el valor de la densidad  final en el  indice  adecuado 
        
        elif rank == 1:
            dens[(i*n)-(n-1)]=juego(densidades[(i*n)-(n-1)])
            
        elif rank == 2:
            dens[(i*n)-(n-2)]=juego(densidades[(i*n)-(n-2)])
            
        elif rank == 3:
            dens[(i*n)-(n-3)]=juego(densidades[(i*n)-(n-3)])
            
        else:
            return None
        
    densidadF = comm.gather(dens, root=0)           # Junta las  soluciones de todos los procesos
    if rank == 0:
        Densidad_final=np.sum(densidadF,axis=0)     #  sumo  los arrays  para  tener uno organizado  y  grafico 
        
        plt.figure(figsize=(10, 6))
        plt.plot(densidades,Densidad_final)
        plt.xlabel('Densidad inicial')
        plt.ylabel('Densidad Final')
        plt.title('Histogramas de Conway')
        plt.legend()
        plt.show()
    else:
        return None
    


if __name__ == "__main__":
    principal()
    
   
