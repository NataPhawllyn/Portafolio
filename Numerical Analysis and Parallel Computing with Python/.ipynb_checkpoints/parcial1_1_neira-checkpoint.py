import numpy as  np 
from  numba  import  njit
import matplotlib.pyplot as plt
import  numexpr  as ne
from matplotlib.animation import FuncAnimation

#@profile
def KdV_solver(L, T_final,condInicial,h,s):
    """
    Resuelve la ecuación de Korteweg–de Vries (KdV) con diferencias finitas
    
    ENTRADAS:
        L[float] : Longitud del dominio espacial
        T_final[float] : Tiempo total de simulación
        N[int] : Número de puntos en la malla espacial
        J[int] : Número de puntos en la malla temporal
        condIcinial[string] : funcion  para  phi  en  t=0
        h[float] : delta  x
        s[float] : delta t
    SALIDA:
        phi[array]  : MAtriz de Solución en la malla (tiempo x espacio)
        x[array]  :  Puntos espaciales
        t[array]  :  Puntos temporales
    """
    
    
    # arreglos discretos de los intervalos de tiempo y espacio 
    x = np.arange(0, L + h, h)
    t = np.arange(0, T_final+s, s)
    J=len(t)
    N=len(x)
    
    
    phi_base = np.zeros(J, dtype=np.float32)
    phi = np.tile(phi_base[:, np.newaxis], (1, N))
    #phi = np.zeros((J, N), dtype=np.float32)                   # matriz de ceros  del tamaño  deseado 
    
    pi=np.pi
    phi[0, :] = ne.evaluate(condInicial)     # condición inicial phi^0

    
    
    c1=3*s/(4*h**3)    #cosntantes  auxiliares 
    c2=s/h
    
     #Calcular phi^1 
    phiMas1=np.roll(phi[0,:],-1,axis=0)         # rota el arreglo para tomar el número sig
    phiMenos1=np.roll(phi[0,:],1,axis=0)        # rota el arreglo para tomar el número ant 
    phiMas2=np.roll(phi[0,:],-2,axis=0)         
    phiMenos2=np.roll(phi[0,:],2,axis=0)
    phicero=phi[0, :]
                  
    phi[1,:]= ne.evaluate("phicero + (c1/2)*(phiMenos2-phiMas2-2*phiMenos1+2*phiMas1) + (c2/2)*phicero*(phiMenos1-phiMas1)")
  

    # nodos  centrales 
    for j in range(0, J-1):
    
        phiMas1=np.roll(phi[j,:],-1,axis=0)         
        phiMenos1=np.roll(phi[j,:],1,axis=0)        
        phiMas2=np.roll(phi[j,:],-2,axis=0)         
        phiMenos2=np.roll(phi[j,:],2,axis=0)
        phi_j=phi[j, :]
        phi_jmenos=phi[j-1, :]
        

        phi[j+1,:]= ne.evaluate("phi_jmenos + c1*(phiMenos2-phiMas2-2*phiMenos1+2*phiMas1) + c2*phi_j*(phiMenos1-phiMas1)")
        
    return phi, x, t

#--------------------------------------------------------------------------------------------------------------------------------
#@profile
def error_rela(phi,phi_fina):
    """
    Esta  función calcula el error  relativo   error = {norm_2 |aprox - exacta|/ norm_2|exacta|} por filas 
    encontrado para un h y s especifico 
    ENTRADA:
        phi[array] :  matriz   de la  solucion aproximada  de KdV
        phi_fina[array]:  solución  con la regilla mas  fina que se logro calcular  
        x[array]  :  Puntos espaciales
        t[array]  :  Puntos temporales
        
    SALIDA:
        error[array] :  colección de los errores relativos en cada paso espacial  
        
    """
    diferencia = phi_fina - phi          # encontramos el  vector diferencia 

    norma_aproximada = ne.evaluate('sqrt(sum(diferencia**2, axis=1))')    # hallo la  norma de la diferencia  y de la  fina 
    norma_exacta = ne.evaluate('sqrt(sum(phi_fina**2, axis=1))')

    error_relativo_L2 = ne.evaluate('norma_aproximada / norma_exacta')   # calculo el cociente para saber el error relativo
    
    return error_relativo_L2


#--------------------------------------------------------------------------------------------------------------------------------
#@profile
def analisis_error(L, T_final,condInicial,phi_fina,t_fina,x_fina):
    """
    calcula  la  sol de KdV  para  distintos h,  y el error   vs  la  solcion exacta dada  y grafica  e vs h
    
    ENTRADAS:
        L[float] : Longitud del dominio espacial
        T_final[float] : Tiempo total de simulación
        N[int] : Número de puntos en la malla espacial
        J[int] : Número de puntos en la malla temporal
        condIcinial[string] : funcion  para  phi  en  t=0
        h[float] : delta  x
        s[float] : delta t
        
    """
    h0=1e-1          
    Harray =np.array([ 5e-2, 1e-2 ], dtype=int)  #distintos h para  calcular 
    
    #Harray =np.array([2*h0,4*h0,16*h0], dtype=int)  #distintos h para  calcular 
    Sarray =ne.evaluate("(0.5)*(Harray**3)")            # me aseguro que  s<h^3        # distintos  s  para calcular 
    s0=(0.5)*(h0**3)
    
    errorh=[]
    errors=[]

        
    # dejando  s  fijo  
    for h in Harray:
        phi, x, t = KdV_solver(L, T_final,condInicial,h,s0)
        
        indices_comunes = np.nonzero(np.isin(x_fina, x))[0]          # encuentro los  valores de x que coinciden en ambas soluciones 
        phi_proyectada = phi_fina[:, indices_comunes]                # proyecto la  solucion fian sobre el espacio de la aprox 
        
        error = error_rela(phi,phi_proyec)                           # ya que ambas  son del mismo tamaño  calculo el error 
        errorh.append(error)                                         # almacenamos  los errores por  fila  para dicho  h
        
        
    # dejando  h  fijo     
    for  s in Sarray:
        phi, x, t = KdV_solver(L, T_final,condInicial,h0,s)
        
        indices_comunes = np.nonzero(np.isin(t_fina, t))[0]          # encuentro los  valores de t que coinciden en ambas soluciones 
        phi_proyectada =  phi_fina[indices_comunes, :]               # proyecto la  solucion fina sobre el espacio de la aprox 
        
        error = error_rela(phi,phi_proyec)                           # ya que ambas  son del mismo tamaño  calculo el error 
        errors.append(error)                                         # almacenamos  los errores por  fila  para dicho  s
     
    
    #grafica_errorvspaso(errors,Sarray,errorh, Harray)
    grafica_histo(errorh)
    #grafica_histo(errors)
    

    
    
#------------------------------------------------------------------------------------------------------------------------------

#                    FUNCIONES DE VISUALIZACIÓN:  SIMULACIÓN Y GRAFICAS 
    
#-------------------------------------------------------------------------------------------------------------------------------


def grafica_errorvspaso(errors,Sarray,errorh, Harray):
    """
    función para  graficar el error  relativo  con  norma  infinito  en funcion del ancho del paso  s y h 
    """
    # calculo  el maximo error  para cada  h y s 
    errorh = np.max(errorh, axis=1)
    errors = np.max(errors, axis=1)
    
    
    fig, ax1 = plt.subplots(figsize=(10, 6))

    # Primera serie: Harray y errorh en el eje inferior (h)
    ax1.loglog(Harray, errorh, label="h", color='b')
    ax1.set_xlabel("h (eje inferior)", fontsize=12)
    ax1.set_ylabel("Error", fontsize=12)
    ax1.legend(loc="upper left")

    # Crear un segundo eje que comparte el eje y, pero con un eje x separado (arriba)
    ax2 = ax1.twiny()  
    ax2.loglog(Sarray, errors, label="s", color='r')
    ax2.set_xlabel("s (eje superior)", fontsize=12)
    ax2.legend(loc="upper right")

    # Ajustar la posición del segundo eje x (arriba)
    ax2.xaxis.set_label_position('top')
    ax2.xaxis.tick_top()

    # Título común
    plt.title("Análisis de convergencia con doble eje x", fontsize=14)

    plt.show()

#-------------------------------------------------------------------------------------------------------------------------------
def grafica_histo(array):
    plt.figure(figsize=(10, 6))

    for i, sub_array in enumerate(arrays):
        plt.hist(sub_array, bins=30, alpha=0.5, label=f'Sub-array {i+1}', density=True)

    plt.xlabel('Valor')
    plt.ylabel('Frecuencia')
    plt.title('Histogramas de cada sub-array')
    plt.legend()

    # Mostrar el gráfico
    plt.show()
    
#---------------------------------------------------------------------------------------------------------------------------------

def simulación(x, t, phi):
    J=int(len(t)//10)                                                     # numero de frames 
#     indices_comunes = np.nonzero(np.isin(x_fina, x))[0]          # encuentro los  valores de x que coinciden en ambas soluciones 
#     phi_exacta = phi_fina[:, indices_comunes]
    

    indices = np.linspace(0, len(t) - 1, J, dtype=int)        # Crear J índices espaciados
    fig, ax = plt.subplots()
    
    line, = ax.plot(x, phi[0, :], label="Aproximada")  
    #line2, = ax.plot(x, phi_exacta[0, :], label="Exacta", linestyle='--')
    
    ax.set_xlabel('x')
    ax.set_ylabel('phi')
    ax.legend(loc="upper right")
    
    tiempo = ax.text(0.05, 0.95, '', transform=ax.transAxes, fontsize=12, verticalalignment='top')

    # Función de actualización para la animación
    def animate(i):
        idx = indices[i]  # Seleccionar el índice correspondiente
        line.set_ydata(phi[idx, :])                 # Actualiza los datos de la solución aproximada
        #line2.set_ydata(phi_exacta[idx, :])         # Actualiza los datos de la solución exacta
        tiempo.set_text(f't = {t[idx]:.2f}')        # Actualiza el texto del tiempo
        ax.set_ylim(0, 2)
#         
            
        return line, tiempo

   
    anim = FuncAnimation(fig, animate, frames=J, interval=50, blit=True)
    anim.save('animation.gif', writer='imagemagick')
    plt.show()
    
#--------------------------------------------------------------------------------------------------------------------------------------



#------------------------------------------------------------------------------------------------------------------------------------





if __name__ =="__main__":
    # Parámetros del problema 
    h0=1e-1
    s0=(0.5)*h0**3         # me aseguro que  s<h^3  si h <1  s<h  si h>1   regilla  mas  grande 
    
    h1=2e-1
    s1=(0.5)*h1**3
    
    h2=1e-1
    s2=(0.5)*h2**3      #regilla  mas  pequeña
    
    L = 10.0        
    T_final = 10.0      
      
    condInicial ="0.5 * sin(2 * pi / L * (x)) + 0.5"       # valor de  phi en t=0
    
    
   # phi, x, t = KdV_solver(L, T_final,condInicial,h,s)
    phi_fina, x_fina, t_fina = KdV_solver(L, T_final,condInicial,h0,s0)
    analisis_error(L, T_final,condInicial,phi_fina,t_fina,x_fina)

    #simulación(x,t,phi)
    
    
    
    
    
    
    
    
    
    
    
    
    
  



























    
#---------------------  codigo sin  usar ------------------------------------------

#grafica_estatica(x,phi[6,:],"t=1","x","phi","solucion aproximada de KdV")

#def grafica_estatica(x,y,serie,xlabel,ylabel,title):
#     plt.figure(figsize=(10,6))
#     plt.plot(x, y, label=serie)
#     plt.xlabel(xlabel)
#     plt.ylabel(ylabel)
#     plt.title(title)
#     plt.legend()
#     plt.show()


# def phi_exacta(x,t,sol_exact):
    
#     J=len(t)
#     pi=np.pi
#     t_grande=t[:, np.newaxis]                # se  hace  broadcasting a  t para ser operado por la función 
#     phi_exacta= ne.evaluate(sol_exact)       # calculo la  solución exacta
    
#     return phi_exacta

# Error  relativo con maximos   norma L inf
#     N=len(x)
#     J=len(t)
    
#     # aux=np.zeros((J,N))
#     # aux2=np.zeros((J,N))
    
    
#     aux=ne.evaluate("abs(phi-phi_exact)")    # se  calcula  los  valores del  num y dem 
#     aux2=ne.evaluate("abs(phi_exact)")
    
#     MaxNum=aux.max()
#     MaxDem=aux2.max()

#     Error=MaxNum/MaxDem
#     return Error


#sol_exact="0.5 * sin(2 * pi / L * (x - t_grande)) + 0.5"