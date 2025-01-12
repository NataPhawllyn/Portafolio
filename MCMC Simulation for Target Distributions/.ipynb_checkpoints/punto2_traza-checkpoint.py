import numpy as np
import matplotlib.pyplot as plt

# Función para leer una cadena desde un archivo de texto
def leer_cadena_de_archivo(alpha):
    filename = f"cadena_alpha_{alpha}.txt"
    return np.loadtxt(filename)


# Graficar las trazas 
def plot_traces(cadenas, alphas):
    plt.figure(figsize=(10, 8))
    for i, cadena in enumerate(cadenas):
        plt.subplot(len(cadenas), 1, i + 1)
        plt.plot(cadena, lw=0.5)
        plt.title(f'Traza con alpha = {alphas[i]}')
        plt.xlabel('Iteraciones')
        plt.ylabel('Valores de la cadena')
    plt.tight_layout()
    plt.show()


if __name__ == "__main__":
    alphas = [0.01, 0.1, 1.0, 10.0]
    cadenas = [leer_cadena_de_archivo(alpha) for alpha in alphas]
    
    plot_traces(cadenas, alphas)
