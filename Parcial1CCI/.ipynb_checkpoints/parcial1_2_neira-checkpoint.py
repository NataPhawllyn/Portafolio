from mpi4py import MPI
import random
import numpy as  np
from  numba  import  njit


@njit
def sort_div(arr,intervalo=5):
    """
    Este codigo se usa  para  ordenar de forma implicita  dividiendo por  rangos
    
    ENTRADAS:
        arr[array] :  array a  ordenar 
        intervalo[int] :  este es el ancho del rango de los array  en los que queremos dividir 
        
    SALIDA:
        ordenada[array] : array ordenado 
    NOTA:
          intervales igual a 5 por defecto  porque esta función está creada  especificamente para  la  lógica usada 
           de la  organización en parallelo del  array, dado que sabemos que  el rango del array inicial es (0,100) y que  cada 
           procesador  maneja  un cuarto de  ese arreglo, se puede decucir que  se puede dividir cada uno de ellos en  arreglos 
           con intervalos de  5 en 5  
    """
    ordenada = []                
    
    if len(arr) == 0 or np.all(arr == arr[0]):                # si el array es de un solo num  o vacio esta organizado por defec
        return arr
    else:                                                     # para un array desorganizado, se divide  en sub array, segun un rango
        maxarr=np.max(arr)
        inicio=np.min(arr)
        
        while inicio<maxarr:
            
            final = inicio + intervalo                                           # se determina el intervalo del rango
            sub_arr= sort_div(arr[(arr >= inicio) & (arr < final)],intervalo=1)   # se organiza recursivamente  con  intervalos de 1-1
            ordenada=np.concatenate([ordenada,sub_arr])                          # se  van uniendo los arrays  ordenados 
            inicio=final
            
        return ordenada


def sort_paralelo(arr):
    """
    Esta funcion ordena  un array  usando 4 procesadores para ello 
    
    ENTRADAS:
        arr[array] :  array a  rdenar 
        
    SALIDA:
        
    """
    comm = MPI.COMM_WORLD
    size = comm.Get_size()
    rank = comm.Get_rank()
    
    
                                                         # Dividimos el array  4 en partes  segun el rango de numeros  
    arr1 = array[(array >= 0) & (array <= 25)]
    arr2 = array[(array >= 26) & (array <= 50)]
    arr3 = array[(array >= 51) & (array <= 75)]
    arr4 = array[(array >= 76) & (array <= 100)]
    pedazos = [arr1, arr2, arr3, arr4]
    
    ordenado = sort_div(pedazos[rank])                    #pasamos  una lista a cada procesador  y las ordena  
    
    listas_ords = comm.gather(ordenado, root=0)           # Junta las  soluciones de todos los procesos 
    if rank == 0:
        lista_final=np.concatenate(listas_ords)                # el rank 0 junta las listas semi ordenadas
        return lista_final
    else:
        return None
  
    
    return lista_final
    


if __name__ == "__main__":
    comm = MPI.COMM_WORLD
    rank = comm.Get_rank()
    N=int(1e6)
    np.random.seed(seed=42)
    array=np.random.randint(low=0, high=101, size=N, dtype=int)
    array_sort= sort_paralelo(array)
    #print("array original \n",array)
    

    #if rank == 0:
        # Procesador 0  imprime el arreglo ordenado 
         #print("array organizado \n")#,array_sort)


            
            
            
            

            
            
            
            
###----------------- Codigo si  usar----------


#  FUNC EXCEDE LA  PROFUNDIDAD MAXIMA DE RECURSIVIDAD 
# def sort_rec(arr, min_val=None, max_val=None):
#     """
#     Función recursiva  para  ordenar  arrays  muy  grandes,  usa  la  funcion sort_seq  para arrays  de tamaños  menores a 10^3
#     ENTRADAS:
#         arra[array] :  array a ordenar  de entradas  enteras 
#         min_val[int] : valor minimo  encontrado en el array
#         max_val[int] : valor maximo  encontrado en el array 
#     SALIDA:
#         _[array] : array  ordenado de menor a mayor 
#     """
    
#     if len(arr)<=(1e3):                        # para arreglos  n=10^3  la función es rapida 
#         return sort_seq(arr)
#     else:                                      # para arreglos mas  randes , los divido y uso  recursividad  hasta el tamaño 10^3
#         if min_val is None or max_val is None:
#             min_val = np.min(arr)
#             max_val = np.max(arr)             #  guargo los  valores max y min para  no calcularlos en cada  recursion 
                
#         mid_val = (min_val + max_val) / 2         # el cuento el  valor de la mitad  del rango para separarlos  "ordenadamente"
#         parte1 = sort_rec(arr[arr <= mid_val], min_val, mid_val)
#         parte2 = sort_rec(arr[arr > mid_val], mid_val, max_val)   # uso recursividad para cada  pedazo 
        
#         return np.concatenate([parte1,parte2]) 


#"OPTIMO" PARA ARRAYS  DE TAMAÑO 10^3 time =24 ms  No se puede usar  para arrays  mas  grandes 
# def sort_seq(arr):
#     """
#     Esta  función  organiza   un array dado  de menor a mayor 
#     ENTRADA:
#         arr[array] : array  de enteros sin organizar
#     SALIDA:
#        array_sort[array] : array  organzado de menor a mayor 
#     """
#     array_sort= []
#     arr=arr.tolist()
#     while len(arr) > 0:                     # mientras  exista un array,  encontramos  un min  lo ubicamos en el  nuevo array 
#         min_value = min(arr)                #  y  eliminamos el min del array original
#         array_sort.append(min_value)
#         arr.remove(min_value)
        
#     return np.array(array_sort)
