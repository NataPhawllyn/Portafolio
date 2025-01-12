Statistical Modeling and Parallel Computing with Python

This project demonstrates advanced statistical sampling techniques, including Markov Chain Monte Carlo
(MCMC) and Linear Congruential Generators (LCG), combined with parallel computing methods. 
It also includes visualization and performance analysis of algorithms.

Contents
_*Files: punto1.py, punto1CL.py: Random Number Generation and LCG Parameter Estimation
Implements parallel algorithms to estimate the parameters of LCGs and validate them.

_*Files: punto2.py, punto2_histograma.py, punto2_traza.py: Markov Chain Monte Carlo (MCMC) Simulation
Applies MCMC sampling to simulate target distributions and visualize results.


-*Files: punto3.py, punto3_correlacion.py, punto3_histograma.py: Advanced MCMC for Multivariate Models
Extends MCMC to sample from multivariate distributions with visual correlation and histogram plots.


HOW  TO  RUN 
Python 3.x
Libraries: numpy, scipy, matplotlib, sympy, mpi4py

mpirun -n 4 python punto1.py (ONLY FILE IN PARALLEL)