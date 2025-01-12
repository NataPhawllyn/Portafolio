package proyecto2_neiracruz;

public class Lista {

    private Libros[] lista=new Libros[1];
    private Libros[] listaAux;

    public Lista() {
    }

    
    
    public void asignarTamaño(char x,int a) {
        if(x=='A')listaAux = new Libros[a + 2];
        else if(x=='L') lista = new Libros[a + 2];
        
    }
    

    public void agregarEspacio(Libros lib, int i) {
        if (lista.length < listaAux.length)lista[i] = lib;
       else  listaAux[i] = lib;
        
    }

    public void imprimirLista() {
        if (lista.length > listaAux.length) {
            for (int i = 0; i < listaAux.length; i++) {
                if (listaAux[i].getTitulo() != null) 
                    System.out.println((i + 1) + ". " + listaAux[i].toString());
                else 
                    System.out.println((i + 1) + ". Espacio disponible.");
           }
        } else {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i].getTitulo() != null) 
                    System.out.println((i + 1) + ". " + lista[i].toString());
                else  
                    System.out.println((i + 1) + ". Espacio disponible.");
            }
        }
    }

    // a es más grande que b, //
    public void copiarLista() {
        if (lista.length > listaAux.length) {
            for (int i = 0; i < listaAux.length; i++) lista[i] = listaAux[i];
        } else {
            for (int i = 0; i < lista.length; i++) listaAux[i] = lista[i];
        }
    }
}