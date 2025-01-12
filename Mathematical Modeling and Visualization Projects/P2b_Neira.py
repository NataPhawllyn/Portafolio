# -*- coding: utf-8 -*-
"""
Created on Tue Mar 19 02:39:04 2024

@author: NATALY NEIRA cod:614212782
"""

import  numpy as np
import math
import matplotlib.pyplot as plt

 
#Valor de las constantes
A=1.024E-23
B=1.582E-26
kB=1.381E-23
Ak=A/kB
Bk=A/kB
r_0=0.39#0.33728 #0.37648 #

#creamos las listas de distancia, potencial y Fuerza para graficar 
r=np.linspace(0.30,0.41,100)
Uk_r=(Bk/(r**12))-(Ak/(r**6))
k_r0=((156*Bk)/(r_0**14))-((42*Ak)/(r_0**8))
V_r=(0.5*k_r0*((r-r_0)**2))+1E-20


# graficamos en cartesianas

#-------------------------plot-plot----------------------

fig=plt.figure()

a1=plt.subplot(111)

a1.plot(r,Uk_r,'-r',label="U(r)")
a1.set_xlabel("Distancia (nm)")
a1.set_ylabel("Potencial( J )")

a2=a1.twinx()

a2.plot(r,V_r,'-b',label="V(r)")
a2.set_ylabel("Oscilador armonico ( J $nm^2$)")

fig.legend()  #  convensiones 
fig.suptitle("Punto de equilibrio $r_0=0.39$ ; $\epsilon=1E-20$")
fig.tight_layout() # superpone las  graficas 

plt.show()