# -*- coding: utf-8 -*-
"""
Created on Tue Mar 19 01:36:23 2024

@author: NATALY NEIRA cod: 614212782
"""

import  numpy as np
import math
import matplotlib.pyplot as plt


##----- MODELO ORIGINAL 
#Valor de las constantes
A=1.024E-23
B=1.582E-26

#creamos las listas de distancia, potencial y Fuerza para graficar 
r=np.linspace(5E-3,0.4,51)
U_r=(B/(r**12))-(A/(r**6))
F_r=((12*B)/(r**13))-((6*A)/(r**7))

# graficamos en  cartesianas 


#----------------------plot-plot-------------

fig=plt.figure() # se crea la  figura 
a1=plt.subplot(121) # se  crea  la subgrafica
a1.plot(r,U_r,'*r',label="U (r)") # graficamos los datos de la potencia  
a1.set_ylabel("Potencial(J)") # nombramos el  eje  y1
a1.set_xlabel("Distancia (nm)") # nombramos el eje x

a2=a1.twinx()   # creamos  la  segunda subgrafica 

a2.plot(r,F_r,'blue',label="F(r)")  # graficamos los  datos de la fuerza 
a2.set_ylabel("Fuerza (N)") # nombramos  el  eje Y2


a1.set_title("plot-plot")
fig.tight_layout() # superpone las  graficas 

#-----------------------semilogy---------------

b1=plt.subplot(122) # se  crea  la subgrafica
b1.semilogy(r,U_r,'*r') # graficamos los datos de la potencia  
b1.set_ylabel("Potencial (J)") # nombramos el  eje  y1
b1.set_xlabel("Distancia (nm)") # nombramos el eje x

b2=b1.twinx()   # creamos  la  segunda subgrafica 

b2.semilogy(r,F_r,'blue')  # graficamos los  datos de la fuerza 
b2.set_ylabel("Fuerza (N)") # nombramos  el  eje Y2


b1.set_title("semilog y")
fig.tight_layout() # superpone las  graficas 


fig.suptitle("Modelo original")
fig.legend(loc='lower center')  #  convensiones 



##----MODELO DIVIDIENDO  POR LA  CONSTANTE DE BOLTZMAN

#Valor de las constantes
kB=1.381E-23
Ak=A/kB
Bk=A/kB

#creamos las listas de distancia, potencial y Fuerza para graficar 
Uk_r=(Bk/(r**12))-(Ak/(r**6))
Fk_r=((12*Bk)/(r**13))-((6*Ak)/(r**7))

# graficamos en  cartesianas 

#------------------plot-plot ---------------

fig2=plt.figure() # se crea la  figura 
c1=plt.subplot(121) # se  crea  la subgrafica
c1.plot(r,Uk_r,'*r',label="U (r)") # graficamos los datos de la potencia  
c1.set_ylabel("Potencial (J)") # nombramos el  eje  y1
c1.set_xlabel("Distancia (nm)") # nombramos el eje x

c2=c1.twinx()   # creamos  la  segunda subgrafica 

c2.plot(r,Fk_r,'blue',label="F (r)")  # graficamos los  datos de la fuerza 
c2.set_ylabel("Fuerza (N)") # nombramos  el  eje Y2

c1.set_title("plot-plot")
fig2.tight_layout() # superpone las  graficas 


#---------------------semilogy---------

d1=plt.subplot(122) # se  crea  la subgrafica
d1.semilogy(r,U_r,'*r') # graficamos los datos de la potencia  
d1.set_ylabel("Potencial (J)") # nombramos el  eje  y1
d1.set_xlabel("Distancia (nm)") # nombramos el eje x

d2=d1.twinx()   # creamos  la  segunda subgrafica 

d2.semilogy(r,F_r,'blue')  # graficamos los  datos de la fuerza 
d2.set_ylabel("Fuerza (N)") # nombramos  el  eje Y2

d1.set_title("Semilog y")
fig2.tight_layout() # superpone las  graficas 

fig2.suptitle("Modelo con Blotzman $k$")
fig2.legend(loc='lower center')  #  convensiones 

plt.show()


print("El potencial mínimo que se presenta en la interacción entre dos atomos ")
print( "es menor a E-20 J y se encuentra en distancias entre 0.3 y 0.4 nm ")

