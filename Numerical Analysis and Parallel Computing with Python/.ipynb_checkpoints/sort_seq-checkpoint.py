import random
import numpy as  np
from  numba  import  njit

#@profile
def sort_array_min(arr):
    """
    Esta  función  organiza   un array dado  de menor a mayor 
    ENTRADA:
        arr[array] : array  de enteros sin organizar
    SALIDA:
       array_sort[array] : array  organzado de menor a mayor 
    """
    array_sort= []
    
    while len(arr) > 0:                     # mientras  exista un array,  encontramos  un min  lo ubicamos en el  nuevo array 
        min_value = min(arr)                #  y  eliminamos el min del array original
        array_sort.append(min_value)
        arr.remove(min_value)
        
    return np.array(array_sort)

if __name__ == "__main__":
    N=int(1e5)
    #N=12
    np.random.seed(seed=42)
    array=np.random.randint(low=0, high=101, size=N, dtype=int)
    array = array.tolist() 
    array_sort=np.array(sort_array_min(array))
    #print("array original \n",array)
   #print("array organizado \n",array_sort)