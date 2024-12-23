# -*- coding: utf-8 -*-
"""
Created on Tue Mar 19 00:06:34 2024

@author: NATALY NEIRA Cod= 614212782
"""

import numpy as np
import math 
import matplotlib.pyplot as plt

#Valor de las  constantes  
b=2
a=0
 

#creamos las listas  con la informacion del radio y el ángulo del mismo tamaño
theta=np.linspace(0, 8*np.pi,101)

radio2=a+b*theta  # se calcula  la  función encontrada en  la teoria  para  graficar unas spiral


#Graficamos en coordenadas polares 

plt.figure()   # se crea el espacio de la  figura 
ax=plt.subplot(111,polar=True)  # se crea el  sub grafico  en la posición indicada 
ax.plot(theta,radio2,'blue',label=r"$r=a+b{\theta}$") #Se  grafica la  función a+b*theta
ax.legend(loc='best')  # ubica las  convecione
ax.grid(True)     # se ve la cuadricula de fondo 



plt.suptitle('Archimedean Spiral a=0  and   b=2')  # hago el Titulo 
plt.show() # imprimo la grafica 