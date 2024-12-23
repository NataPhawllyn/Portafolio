import  sys 

print(f"hola : {sys.argv[0]}") # lista  que recupera  lo que escribes  como input

#GNU parallel
#bash
# python   archiv.py  texto 

#  -j  tantos  trabajos   o hilos 

#parallel  -j  8 python  nombre.py ::: [0..20]  desordenado 
# -j 8  -k    hace as  cosas ordenadas 

