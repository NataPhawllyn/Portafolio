from mpi4py import MPI
import numpy as  np
import  numexpr  as ne
import  math 
from functools import reduce
import sys


def volumen(part):
    """
    crea los 3 vectores necesarios  a partir de las  cuatro entradas,
    para calular luego el volumen del paralelepipedo  formado por estos 
    
    ENTRADAS:
        part[array] :  Lista de  valores LCG  longitud 4
        
    SALIDA:
        det[float] :   valor del volumen 
        
    """
    part=np.array(part)
    alpha=part[:2]              #se definen los  vectores 
    betta=part[1:3]
    gamma=part[2:]
        
    a=ne.evaluate("betta-alpha")  # se  crean las  filas de la  matrix 
    b=ne.evaluate("gamma-alpha")
        
    rot=[[0,1],[-1,0]]
        
    det=a@rot@b                   # se calcula el determinante de la matriz
        
    return det
    
def findm(array):
    """
    Divide la lista de los numeros generados LCG  en 4 partes  y  calcula el volumen de los para los paralelepipedeos 
    de los  vectores formados  por  sus entradas, para  luego encontrar el GCD de los  valores dados  y tener  candidatos  de m.
    
    ENTRADAS:
        arr[array] :  Lista de  valores LCG  longitud  mayor a 16
        
    SALIDA:
        GCD[array] :   lista de  candidatos de m
        
    """
    comm = MPI.COMM_WORLD
    size = comm.Get_size()
    rank = comm.Get_rank()
    
    
    part=array[4*rank:4*(rank+1)]
    vol=volumen(part)
    
    
    lista_volumenes = comm.gather(vol, root=0)           # Junta las  soluciones de todos los procesos 
    if rank == 0:
        GCD=[]
        GCD.append(reduce(math.gcd, lista_volumenes[:2]))
        GCD.append(reduce(math.gcd, lista_volumenes[:3]))
        GCD.append(reduce(math.gcd, lista_volumenes))
        
        return GCD
    else:
        return None

    


if __name__ == "__main__":
    comm = MPI.COMM_WORLD
    rank = comm.Get_rank()
    sys.stdout.reconfigure(encoding='utf-8')
    
    LCGarray=np.array([137, 553, 990, 881, 646, 618, 323, 832, 897, 230, 181, 432, 44, 925, 525, 695, 367, 711, 974, 274])
    m=findm(LCGarray)
    
    if rank == 0:
        for i  in m:
            print(i)
    

      


            