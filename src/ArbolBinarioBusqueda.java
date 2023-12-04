import java.util.Scanner;

public class ArbolBinarioBusqueda {

    Scanner sc = new Scanner(System.in);
    Nodo raiz;
    int grado;
    int nivel;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
        this.grado = 0;
        this.nivel = 0;
    }

    public void PreOrder(Nodo root){
        if(root != null){
            System.out.println(root.dato);
            PreOrder(root.izq);
            PreOrder(root.der);
        }
    }

    public void InOrder(Nodo root){
        if(root != null){
            InOrder(root.izq);
            System.out.println(root.dato);
            InOrder(root.der);
        }

    }

    public void PostOrder(Nodo root){
        if(root != null){
            PostOrder(root.izq);
            PostOrder(root.der);
            System.out.println(root.dato);
        }
    }

    public void borrarArbolPostOrder(Nodo nodo) {
        if (nodo != null) {
            borrarArbolPostOrder(nodo.izq);
            borrarArbolPostOrder(nodo.der);
            nodo.izq = null;
            nodo.der = null;
        }
    }
    public void BorrarArbol() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio.");
        }else {
            borrarArbolPostOrder(raiz);
            raiz = null;
            System.out.println("Se ha borrado el arbol.");
        }
    }


    public Nodo insertar(Nodo nodo, int valor){
        if (nodo == null) {
            Nodo T = new Nodo();
            T.dato = valor;
            System.out.println("Se inserto el valor: " + valor);
            return T;
        }
        if (valor <= nodo.dato) {
            nodo.izq = insertar(nodo.izq, valor);
            System.out.println("Del lado izquierdo");
        } else {
            nodo.der = insertar(nodo.der, valor);
            System.out.println("Del lado derecho");
        }
        return nodo;
    }

    public Nodo buscar(Nodo n, int valor, int nivel){
        if(n == null){
            return null;
        }else if(n.dato == valor){
            System.out.println("Elemento encontrado en nivel " + nivel);
            return n;
        }else if(valor < n.dato){
            return buscar(n.izq, valor, nivel + 1);
        }else{
            return buscar(n.der, valor, nivel + 1);
        }
    }

    public void BuscarMostrar(int valor){
        Nodo n = buscar(raiz, valor, 1);
        if(n == null){
            System.out.println("El valor no se encuentra en el ABB.");
        }
    }


    public void mostrarArbol(){
        if(raiz == null){
            System.out.println("No hay nada que mostrar.");
        }else{
            String opcion;

                System.out.println("\n==================================");
                System.out.println("           ¿Que recorrido desea realizar?");
                System.out.println("==================================");
                System.out.println("1. PreOrder.");
                System.out.println("2. PostOrder");
                System.out.println("3. InOrder");
                System.out.println("==================================\n");
                System.out.print("Selecciona una opción: ");
                opcion = sc.nextLine();
                switch (opcion){
                    case "1":
                        PreOrder(raiz);
                        break;
                    case "2":
                        PostOrder(raiz);
                        break;
                    case "3":
                        InOrder(raiz);
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }

        }

    }

    public Nodo eliminar(Nodo nodo, int valor) {
        if (nodo == null) {
            return null; 
        }
    
        if (valor < nodo.dato) {
            nodo.izq = eliminar(nodo.izq, valor);  
        } else if (valor > nodo.dato) {
            nodo.der = eliminar(nodo.der, valor); 
        } else {
            if (nodo.izq == null) {
                return nodo.der;  
            } else if (nodo.der == null) {
                return nodo.izq; 
            }
    
            nodo.dato = valorMinimo(nodo.der);
    
            nodo.der = eliminar(nodo.der, nodo.dato);
        }
        return nodo;
    }
    
    private int valorMinimo(Nodo nodo) {
        int valorMin = nodo.dato;
        while (nodo.izq != null) {
            valorMin = nodo.izq.dato;
            nodo = nodo.izq;
        }
        return valorMin;
    }
    

    public void Modificar(int valor){
        if (buscar(raiz, valor, 1) == null) {
            System.out.println("El valor no se encuentra en el ABB.");
        } else {
            raiz = eliminar(raiz, valor);
            System.out.println("Ingresa el nuevo valor: ");
            int nuevoValor = sc.nextInt();
            sc.nextLine();  
            raiz = insertar(raiz, nuevoValor);
        }
    }
    



}



/*
*     public Nodo insertarBeta(Nodo nodo, int valor){

        if ( nodo == null ){
            Nodo T = new Nodo();
            T.dato = valor;
            nodo = T;
            System.out.println("Se inserto el valor: " + valor + nodo);
            return T;
        }
        else if(valor <= nodo.dato){
            if(nodo.izq != null){
                insertarBeta(nodo.izq, valor);
            }else{
                Nodo T = new Nodo();
                T.dato = valor;
                nodo.izq = T;
                System.out.println("Se inserto el valor: " + valor + nodo.izq);
            }
            return nodo;
        } else if (nodo.der != null) {
            insertarBeta(nodo.der, valor);
        } else {
            Nodo T = new Nodo();
            T.dato = valor;
            nodo.der = T;
            System.out.println("Se inserto el valor: " + valor + nodo.der);
        }
        return nodo;

    }*/
