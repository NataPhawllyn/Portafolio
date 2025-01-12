import numpy as np
import matplotlib.pyplot as plt
from scipy.special import gamma

def funcionPi(v,d,m,x):
    z=(x-m)/d
    divGamma=gamma((v+1)/2)/(gamma(v/2)*(np.sqrt(v*np.pi)*d))
    base=1+(1/v)*z**2
    expo=-(v+1)/2
    
    funcionPi=divGamma*base**expo
    
    return funcionPi


def leer_cadena_de_archivo(alpha):
    filename = f"cadena_alpha_{alpha}.txt"
    return np.loadtxt(filename)


def plot_histograms(cadenas, alphas, v,d,m):
    plt.figure(figsize=(10, 8))

    # Rango de valores para evaluar la distribución objetivo
    x_vals = np.linspace(-4, 4, 1000)

    for i, cadena in enumerate(cadenas):
        plt.subplot(len(cadenas), 1, i + 1)
        
        # Crear el histograma de la cadena
        plt.hist(cadena, bins=30, density=True, alpha=0.6, color='blue', label=f'Cadena con alpha = {alphas[i]}')

        # Evaluar la distribución objetivo en los mismos puntos
        y_vals = funcionPi(v,d,m,x_vals)

        # Graficar la distribución objetivo
        plt.plot(x_vals, y_vals, 'r-', lw=2, label=r'$\pi(x|\nu, \sigma, \mu)$')

        plt.title(f'Histograma con alpha = {alphas[i]}')
        plt.xlabel('Valores de la cadena')
        plt.ylabel('Densidad')
        plt.legend()

    plt.tight_layout()
    plt.show()


if __name__ == "__main__":
    alphas = [0.01, 0.1, 1.0, 10.0]
    cadenas = [leer_cadena_de_archivo(alpha) for alpha in alphas]

    v=3       # establecemos los  valores de los parametros 
    m=1
    d=1

    plot_histograms(cadenas, alphas, v,d,m)
