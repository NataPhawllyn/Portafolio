# -*- coding: utf-8 -*-
"""
Created on Wed Mar 20 11:29:05 2024

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

#constantes 
V_0=y[0] #condicion inicial,valor para t=0
A=100000
B=V_0-A  # para t=0, V(0)=A+B
a=5E-1 # tasa celulas infectadas
b=9E-1  # tasa celulas removidas beta mayor que alpha 

print("los parametros  escogidos  son \n A={},B={},alpha={},beta={}".format(A,B,a,b))
print("\n 3a)","-"*30)
print("""3a).
      Para aparezcan  juntos tanto el dato como el modelo, es necesario que elija el mismo dominio del modelo, como el rango de los  datos. Además, A+B debe ser igual que el valor inicial de los datos para t=0.
      """)


t=np.linspace(0, x[-1],100) # defnimos el mismo dominio que el rango de los datos 
V_t=(A*np.exp(-a*t))+(B*np.exp(-b*t))

#graficamos en cartesianas 

fig=plt.figure()
a1=plt.subplot()
a1.plot(x,y,'*b',label="data")
a1.set_xlabel("Tiempo")
a1.set_ylabel("Concentración")
a1.plot(t,V_t,'red',label=" V(t)")
a1.legend()

fig.suptitle("Control celulas infectadas en  paciente con  VIH")


plt.show()



