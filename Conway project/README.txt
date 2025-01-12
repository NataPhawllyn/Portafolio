Conway's Game of Life - Parallel Simulation
This project simulates Conway's Game of Life in a 3D grid, leveraging MPI (Message Passing Interface) to parallelize computations across multiple processors. 
The program evaluates how initial population densities evolve over 200 generations and visualizes the results.

Features
-*Population Density Initialization: Generates a random initial population with a specified density (value between 0 and 1).
-*Evolution Simulation: Simulates the evolution of cells based on Conway's Game of Life rules over 200 time steps.
-*Parallel Processing: Divides the workload across multiple processors using MPI, allowing efficient computation of results for different initial densities.
-*Visualization: Plots the relationship between initial and final population densities as a line chart.

Code Structure
1. Core Scripts
-*lifeGame.py (or lifeGame-checkpoint.py)
	-Implements the core logic for initializing the grid, evolving the system, and parallelizing the computations.
	-Uses libraries such as mpi4py, numpy, numba, numexpr, and matplotlib.
Key Functions:
	semilla(densidad): Initializes a 3D grid with a given population density.
	evaluacion(grilla, i): Updates the state of cells according to Conway's rules.
	juego(densidad): Simulates the entire game for a given initial density.
	principal(): Distributes tasks across processors, gathers results, and generates a plot.

2. Parallelization
The program uses MPI to distribute density simulations across 4 processors.
Each processor handles a subset of the computations and gathers results for final aggregation.

3. Visualization
Final results are visualized using matplotlib, displaying how the initial density influences the final density.
The generated plot shows initial density on the x-axis and final density on the y-axis.

HOW TO RUN
The program supports using GNU Parallel .
Example command for execution: mpirun -n 4 python lifeGame.py
Example command for processing different initial densities:
parallel -j 8 --progress python lifeGame.py ::: {0..7} > result.txt

Requirements
Python 3.x
Libraries: mpi4py, numpy, numba, numexpr, matplotlib