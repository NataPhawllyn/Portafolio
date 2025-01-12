# -*- coding: utf-8 -*-
"""
Created on Wed Mar 20 13:56:37 2024

@author: NATALY NEIRA cod:614212782
"""

import  numpy as np
import math
import matplotlib.pyplot as plt
import pandas as pd


# cargarlos datossepradospor comas 
data= np.loadtxt("HIVseries.csv",float,delimiter=",")
x=data[:,0]
y=data[:,1]

#print(df.head()) #miramos que los datos  cargaran bien 

#-----MODELO ----

def V_t(A,B,a,b,t): 
    V_t=(A*np.exp(-a*t))+(B*np.exp(-b*t))
    return V_t
    
    

V_0=y[0] #condicion inicial,valor para t=0
A=100000
B=V_0-A  # para t=0, V(0)=A+B

t=np.linspace(0, x[-1],100) # defnimos el mismo dominio que el rango de los datos
print("los parametros  escogidos  son \n A={},B={}".format(A,B))


#graficamos en cartesianas 

fig=plt.figure(figsize=[10,10])


a1=plt.subplot(221)
a1.plot(x,y,'*b')#,label="data")
a1.set_xlabel("Tiempo")
a1.set_ylabel("Concentración")
a1.plot(t,V_t(A,B,3E-2,5E-2,t),'red')#,label=" V(t)")
a1.set_title(r"$\alpha$=3E-2 y $\beta$=5E-2")

a2=plt.subplot(222)
a2.plot(x,y,'*b')#,label="data")
a2.set_xlabel("Tiempo")
a2.set_ylabel("Concentración")
a2.plot(t,V_t(A,B,3,5,t),'red')#,label=" V(t)")
a2.set_title(r"$\alpha$=3 y $\beta$=5")

a3=plt.subplot(223)
a3.plot(x,y,'*b',label="data")
a3.set_xlabel("Tiempo")
a3.set_ylabel("Concentración")
a3.plot(t,V_t(A,B,3E-1,5E-1,t),'red',label=" V(t)")
a3.set_title(r"$\alpha$=3E-1 y $\beta$=5E-1")


fig.legend(loc='center right')  #  convensiones 
fig.suptitle("Control celulas infectadas en  paciente con  VIH \n análisis de parametros ")

#-------- elección deparametros 

print("""
      3b).
        Betta  debe ser mayor  que  alpha  puesto que vemos que  el el tiempo  la concentración de celulas  infectadas disminuye, es decir, bebe ser mas alta la tasa de remoción que la de infección.
        Por otra  parte,  vemos que si alpha y betta son muy pequeñas (<1E-1)  el modelo no evidencia la caida en el dominio  y si por el contrario son mayores a(>10E-1) cae demasiado rápido.
        Vale la pena  recordar que alpha y betta  no dependen  delas condiciones iniciales, pero  A y B  si  de a forma A+B=V0 ( que  se ha  usado desde el punto 3a)
        
      """)






plt.show()

