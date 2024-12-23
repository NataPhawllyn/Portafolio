import numpy as np
import matplotlib.pyplot as plt

# Función para leer las tripletas de datos (nu, delta, mu) desde un archivo
def leer_cadena_de_archivo(N):
    filename = f"cadena_parametros_N_{N}.txt"
    data = np.loadtxt(filename)  # Leer los datos del archivo
    nu = data[:, 0]    # Primera columna es nu
    delta = data[:, 1]  # Segunda columna es delta
    mu = data[:, 2]     # Tercera columna es mu
    return nu, delta, mu

# Función para graficar los scatter plots de las combinaciones de parámetros
def plot_scatter(nu, delta, mu, N):
    plt.figure(figsize=(15, 5))

    # 1. Graficar nu vs mu
    plt.subplot(1, 3, 1)
    plt.scatter(nu, mu, alpha=0.5, color='blue')
    plt.title(f'nu vs mu (N={N})')
    plt.xlabel('nu')
    plt.ylabel('mu')

    # 2. Graficar nu vs delta
    plt.subplot(1, 3, 2)
    plt.scatter(nu, delta, alpha=0.5, color='green')
    plt.title(f'nu vs delta (N={N})')
    plt.xlabel('nu')
    plt.ylabel('delta')

    # 3. Graficar mu vs delta
    plt.subplot(1, 3, 3)
    plt.scatter(mu, delta, alpha=0.5, color='red')
    plt.title(f'mu vs delta (N={N})')
    plt.xlabel('mu')
    plt.ylabel('delta')

    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    N = 500.0  # Definimos el valor de N
    nu, delta, mu = leer_cadena_de_archivo(N)  # Leer los datos de tripletas (nu, delta, mu)

    # Graficar los scatter plots para examinar las correlaciones
    plot_scatter(nu, delta, mu, N)
