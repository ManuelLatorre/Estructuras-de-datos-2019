/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Manuel
 */
public class Lista {

    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object elemento, int pos) {
        boolean exito = true;
        if ((pos < 1) || (pos > (this.longitud() + 1))) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = new Nodo(elemento, this.cabecera);
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < (pos - 1)) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elemento, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = false;
        if (pos < 1 || pos > (this.longitud() + 1)) {
            exito = false;
        } else {
            if (pos == 1 && this.longitud() > 1) {
                this.cabecera = this.cabecera.getEnlace();
                exito = true;
            } else {
                if (this.longitud() == 1) {
                    this.cabecera = null;
                    exito = true;
                } else {
                    if (pos > 1) {
                        int i = 1;
                        Nodo aux = this.cabecera;
                        while (i < pos - 1) {
                            aux = aux.getEnlace();
                            i++;
                        }
                        aux.setEnlace(aux.getEnlace().getEnlace());
                        exito = true;
                    }

                }
            }

        }
        return exito;
    }

    public Object recuperar(int pos) {
        int i = 1;
        Object vuelve;
        Nodo aux = this.cabecera;
        if (pos < 1 || pos > longitud()) {
            vuelve = null;
        } else {
            while (i < pos) {
                aux = aux.getEnlace();
                i++;
            }
            vuelve = aux.getElem();
        }

        return vuelve;
    }

    public int localizar(Object elem) {
        int i = 1, pos = -1;
        Nodo aux = this.cabecera;
        while (pos == -1 && i <= longitud()) {
            if (aux.getElem() == elem) {
                pos = i;
            } else {
                aux = aux.getEnlace();
                i++;
            }
        }
        return pos;
    }

    public void vaciar() {
        this.cabecera = null;
    }

    public boolean esVacia() {
        boolean vacia = false;
        if (this.cabecera == null) {
            vacia = true;
        }
        return vacia;
    }

    public Lista clone() {
        Lista clon = new Lista();
        if (this.cabecera != null) {
            Nodo aux = this.cabecera;
            Nodo nuevo = new Nodo(aux.getElem(), null);
            clon.cabecera = nuevo;
            nuevo.setEnlace(aux.getEnlace());
            aux = aux.getEnlace();

            while (aux != null) {
                Nodo nuevoDos = new Nodo(aux.getElem(), aux.getEnlace());
                aux = aux.getEnlace();
            }
        }
        return clon;
    }

    public int longitud() {
        Nodo aux = this.cabecera;
        int i = 0;
        while (aux != null) {
            i++;
            aux = aux.getEnlace();
        }
        return i;
    }

    public Lista obtenerMultiplos(int num) {
        Lista nuevaList = new Lista();
        Nodo aux = this.cabecera;
        Nodo aux2 = new Nodo(null);
        int pos = 1;

        while (aux != null) {
            if ((pos % num) == 0) {
                if (nuevaList.cabecera == null) {
                    nuevaList.cabecera = new Nodo(aux.getElem(), null);
                    aux2 = nuevaList.cabecera;
                } else {
                    Nodo nuevo = new Nodo(aux.getElem(), null);
                    aux2.setEnlace(nuevo);
                    aux2 = aux2.getEnlace();
                }
            }
            pos++;
            aux = aux.getEnlace();
        }
        return nuevaList;
    }

    public void eliminarApariciones(Object x) {
        Nodo aux = this.cabecera;

        while (aux.getElem() == x) {
            this.cabecera = aux.getEnlace();
            aux = aux.getEnlace();
        }

        while (aux != null) {
            while (aux.getEnlace() != null && aux.getEnlace().getElem() == x) {
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            aux = aux.getEnlace();
        }
    }

    public String toString() {
        String string = "[";
        Nodo aux = this.cabecera;

        while (aux != null) {
            string = string + aux.getElem() + ", ";
            aux = aux.getEnlace();
        }
        string = string + "]";
        return string;
    }

    public void agregarProducto(int x) {
        int pos=1,mult=1, log=1;
        Nodo nodo= this.cabecera;
        while(nodo.getEnlace()!=null){
            mult=mult*(int)nodo.getElem();
            if(pos==x){
                nodo.setEnlace(new Nodo(mult, nodo.getEnlace()));
                nodo=nodo.getEnlace();
                mult=1;
                pos=0;
            }
            nodo=nodo.getEnlace();
            pos++;
            log++;
        }
        

            nodo.setEnlace(new Nodo((mult*(int)nodo.getElem()),null));
        

    }
    
    public void agregarElem(Object elem, int x){
        Nodo nodo=this.cabecera;
        int pos=0;
        
        while(nodo.getEnlace()!=null){
            if(nodo.equals(this.cabecera)){
                Nodo nuevo= new Nodo (elem,nodo);
                this.cabecera=nuevo;
                nodo=this.cabecera.getEnlace();
                pos++;
            }else{
                if(pos==x){
                    nodo.setEnlace(new Nodo(elem,nodo.getEnlace()));
                    nodo=nodo.getEnlace();
                    pos=0;
                }
                nodo=nodo.getEnlace();
                pos++;
            }
        }
    }
}
