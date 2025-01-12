# -*- coding: utf-8 -*-
"""
Created on Wed Mar 20 14:37:17 2024

@author: NATALY NEIRA cod:614212782
"""

import  numpy as np
import math
import matplotlib.pyplot as plt
import pandas as pd
import random

# cargarlos datossepradospor comas 
data= np.loadtxt("HIVseries.csv",float,delimiter=",")
x=data[:,0]
y=data[:,1]

#print(df.head()) #miramos que los datos  cargaran bien 

#-----MODELO ----

def V_t(A,B,a,b,t): 
    V_t=(A*np.exp(-a*t))+(B*np.exp(-b*t))
    return V_t
    
# ---eleccion de parametros ---

#---  A Y B --------
print("3c)\n")
print("Para la condición inical  realizaremos un promedio de los  5 primeros terminos ,  sabiendo  que  se tarda un tiempo en  empezar en hacer efecto la accion del tratamiento.")
print ("además como no tengo un criterio para elejir a A  asignaremos un valor aleatorio entre el primer dato y la condición inicial calculada  y aseguramos que A+B=V_0")
 

V_0=np.sum(y[0:6])/5 #condicion inicial,promedio 5 valores 
random.seed(1)   #semilla para guardar el número aleatorio
A= random.randint(y[0], V_0)  # generar  número aleatorio 

B=V_0-A  # para t=0, V(0)=A+B



print("\n los parametros  escogidos  son \n A={},  B={},  V_0={}".format(A,B,V_0))


#----- alpha  y beta ----

print("\n Para la elección de alpha y beta  generaremos números aleatorios  entre 0.1 y 1, se ejecuta el modelo con los datos x de la data  y se hace calcula el error punto a punto y luego se hace el promedio de dicho error")
print(" se eligen el alpha y beta que den un error  menor al 20% ")

error=100 # se inicializala variable 

while  error>0.20:  # condicion del 20%
    
    a1 =np.random.uniform(1E-1,10E-1)  # genera números aleatorios 
    b1 =np.random.uniform(1E-1,10E-1)
    Vp=V_t(A, B, a1, b1, x)  # calculo el modelo con los números aleatorios 
    errorL=abs((Vp-y)/y)   #calculo del error  punto a punto 
    error=np.mean(errorL)  # promedio del error, este esel que debe sermenor  al 20%
        

print("\n los parametros  escogidos  son \n a={:.2f}, b={:.2f} con un error de {:.1f}%".format(a1,b1,error*100))

#--- imprimir resultado enla gráfica

t=np.linspace(0, x[-1],100) # defnimos el mismo dominio que el rango de los datos
Vt=V_t(A,B,a1,b1,t) 

  
fig=plt.figure()

a=plt.subplot(111)
a.plot(x,y,'*b',label="data")
a.set_xlabel("Tiempo")
a.set_ylabel("Concentración")
a.plot(t,Vt,'red',label=" V(t)")

# imprimir parametros  en la grafica
texto1=r'$A={}, B={} $  $\alpha ={:.2f},  \beta={:.2f}$'.format(A,B,a1,b1)
a.text(0.2, 0.5, texto1 )

fig.legend(loc='center right')  #  convensiones 
fig.suptitle("Control celulas infectadas en  paciente con  VIH \n análisis de parametros ")
   
plt.show()







