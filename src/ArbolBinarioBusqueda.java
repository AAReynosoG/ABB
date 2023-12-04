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

    public Nodo Eliminar(int valor){
        Nodo R = buscar(raiz, valor, nivel);
        if(R == null){
            System.out.println("El valor no se encuentra en el ABB.");
            return null;
        } else {
            Nodo T;
            if(R.dato == valor){
                T = R;
            } else if (valor < R.dato) {
                T = R.izq;
            } else {
                T = R.der;
            }
            if(T == R && T.izq == null && T.der == null){
                R = null;
                return T;
            } else if(T == R && (T.izq == null || T.der == null)){
                if(T.izq != null){
                    R = T.izq;
                    T.izq = null;
                } else {
                    R = T.der;
                    T.der = null;
                }
                return T;
            } else if(T.izq == null && T.der == null){
                if(R.izq == T){
                    R.izq = null;
                } else {
                    R.der = null;
                }
                return T;
            } else if(T.izq == null){
                if(R.izq == T){
                    R.izq = T.der;
                } else {
                    R.der = T.der;
                }
                T.der = null;
                return T;
            } else if(T.der == null){
                if(R.izq == T){
                    R.izq = T.izq;
                } else {
                    R.der = T.izq;
                }
                T.izq = null;
                return T;
            } else if(T.izq != null && T.der != null){ // Esta es la validacion por si T tiene dos hijos
                Nodo Q = T.izq;
                Nodo A = T;
                while (Q.der != null) {
                    A = Q;
                    Q = Q.der;
                }
                int temp = Q.dato;
                Q.dato = T.dato;
                T.dato = temp;
                if (A == T) {
                    A.izq = Q.izq;
                } else {
                    A.der = Q.izq;
                }
                Q.izq = null;
                return Q;
            }
        }
        return null;
    }



    public void Modificar(int valor){
        Nodo R = buscar(raiz, valor, nivel);
        if (R == null){
            System.out.println("El valor no se encuentra en el ABB.");
        }else {
            raiz = Eliminar(valor);
            System.out.println("Ingresa el nuevo valor: ");
            int nuevoValor = sc.nextInt();
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
