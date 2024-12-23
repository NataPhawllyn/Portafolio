import numpy as np
import matplotlib.pyplot as plt

# Constants
L = 1.0        # Length of the domain
T = 1.0        # Total time
c = 1.0        # Wave speed
Nx = 6      # Number of spatial steps
Nt = 5      # Number of time steps
dx = L / Nx    # Spatial step size
dt = T / Nt    # Time step size

# Stability condition
C = c * dt / dx  # Courant number, should be <= 1 for stability

# Initialize solution arrays
u = np.zeros((Nt, Nx))  # Solution u at each time step and spatial point

# Initial conditions: u_j^0
X=np.linspace(0,1,Nx)

u[0, :]= 0  # Example initial condition
u[1,:]=dt*np.sin(X)

# Boundary conditions: u_0^n and u_L^n (fixed at 0 in this case)
u[:, 0] = 0
u[:, -1] = 0


print(u)

# Time-stepping loop (from n=2 onwards)
for n in range(1, Nt - 1):
    for j in range(1, Nx - 1):
        u[n+1, j] = 2*u[n, j] - u[n-1, j] + C**2 * (u[n, j+1] - 2*u[n, j] + u[n, j-1])

print(u)