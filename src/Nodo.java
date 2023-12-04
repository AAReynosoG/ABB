public class Nodo {

    int dato;
    Nodo izq;
    Nodo der;

    int grado;
    Nodo padre;

    public Nodo() {
        this.dato = 0;
        this.izq = null;
        this.der = null;
        this.grado = 0;
        this.padre = null;
    }
}
