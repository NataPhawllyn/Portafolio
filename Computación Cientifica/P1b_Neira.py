# -*- coding: utf-8 -*-
"""
Created on Tue Mar 19 01:06:00 2024

@author: NATALY NEIRA Cod= 614212782
"""

import  numpy as np
import  math
import matplotlib.pyplot as plt

#Valor de las  constantes
a=0.8
 
#creamos las listas  con la informacion del radio y el ángulo del mismo tamaño
theta=np.linspace(0, 8*np.pi,101)
radio1=a**theta  # se calcula  la  función dada en el enunciado


#Graficamos en coordenadas polares 

plt.figure()   # se crea el espacio de la  figura 

a1=plt.subplot(111,polar=True)  # se crea la  grilla en polares 
a1.plot(theta,radio1,'red',label=r"$r=a^{\theta}$") #Se  grafica la  función  a^theta
a1.grid(True)     # se ve la cuadricula de fondo 
a1.legend(loc='best')  # ubica las  convecione

plt.suptitle('The logarithmic Spiral a=0.8')  # hago el Titulo 
plt.show() # imprimo la grafica 