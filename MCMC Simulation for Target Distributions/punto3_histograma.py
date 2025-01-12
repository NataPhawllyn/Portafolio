import numpy as np
import matplotlib.pyplot as plt

# Función para leer las cadenas desde archivo y separarlas en nu, delta, mu
def leer_cadena_de_archivo(N):
    filename = f"cadena_parametros_N_{N}.txt"
    data = np.loadtxt(filename)  # Leer los datos del archivo
    nu = data[:, 0]    # Primera columna es nu
    delta = data[:, 1]  # Segunda columna es delta
    mu = data[:, 2]     # Tercera columna es mu
    return nu, delta, mu

# Función para graficar los histogramas de cada parámetro
def plot_histograms(nu, delta, mu, N):
    plt.figure(figsize=(10, 8))

    # Graficar el histograma de nu
    plt.subplot(3, 1, 1)
    plt.hist(nu, bins=30, density=True, alpha=0.6, color='blue', label=f'nu (N={N})')
    plt.title(f'Histograma de nu (N={N})')
    plt.xlabel('nu')
    plt.ylabel('Densidad')
    plt.legend()

    # Graficar el histograma de delta
    plt.subplot(3, 1, 2)
    plt.hist(delta, bins=30, density=True, alpha=0.6, color='green', label=f'delta (N={N})')
    plt.title(f'Histograma de delta (N={N})')
    plt.xlabel('delta')
    plt.ylabel('Densidad')
    plt.legend()

    # Graficar el histograma de mu
    plt.subplot(3, 1, 3)
    plt.hist(mu, bins=30, density=True, alpha=0.6, color='red', label=f'mu (N={N})')
    plt.title(f'Histograma de mu (N={N})')
    plt.xlabel('mu')
    plt.ylabel('Densidad')
    plt.legend()

    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    N_s = [100.0, 500.0]  # Diferentes tamaños de N

    # Iterar sobre los diferentes valores de N
    for N in N_s:
        # Leer las cadenas de datos (nu, delta, mu) para cada N
        nu, delta, mu = leer_cadena_de_archivo(N)
        
        # Graficar los histogramas para cada N
        plot_histograms(nu, delta, mu, N)
