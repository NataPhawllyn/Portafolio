import sys
from sympy import mod_inverse
import numpy as  np



def genLCG(m, a, c, x0):
    """
    Creamos la lista de  numeros aleatrios  con los parametros encontrados 
    
    ENTRADAS:
        m[int]  : el  modulo 
        a[int]  : el termino multiplicador 
        c[int]  : el  sumando 
        x0[int] : la semilla 
    
    SALIDAS:
     genLCG[array] : lista  generada
    """
    
    genLCG = [x0]     #  iniciamos  con la semilla 
    
    for i in range(1, 20):
        x_mas1 = (a * genLCG[-1] + c) % m
        genLCG.append(x_mas1)
    
    return  genLCG
    
    
    
def sistema_Modular(x0, x1, x2, m):
    try:

        x1_inv = mod_inverse(x1, m)

      
        term1 = (1 - x1_inv * x0) % m
        term1_inv = mod_inverse(term1, m) 
        
        term2 = (x1 - x1_inv * x2 * x0) % m
       
        c = (term1_inv * term2) % m       
        a = (x1_inv * (x2 - c)) % m
        
        
        return a,c

    except ValueError as e:
        # In case modular inverse doesn't exist
        print(f"Error: {e}")
        return None, None

if __name__ == "__main__":
    LCGarray=np.array([137, 553, 990, 881, 646, 618, 323, 832, 897, 230, 181, 432, 44, 925, 525, 695, 367, 711, 974, 274])
    
    
    # inicializar  parametros 
    x0 = LCGarray[0]
    x1 = LCGarray[1]
    x2 = LCGarray[2]
    m = int(sys.argv[1])

  
    a, c = sistema_Modular(x0, x1, x2, m)    

    if a is not None and c is not None:
        diferencia= LCGarray-genLCG(m, a, c, x0)
        if np.all(diferencia == 0):
            print("m={},x0={},a={},c={}".format(m,x0,a,c))
        else:
            print("los parametros encontrados  NO son  correctos m={},x0={},a={},c={}".format(m,x0,a,c))
    else:
        print("el sistema  no tenia  solución.")
