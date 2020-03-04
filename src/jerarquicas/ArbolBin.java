/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.Lista;

/**
 *
 * @author Manuel
 */
public class ArbolBin {

    private NodoArbol raiz;

    public void ArbolBin() {
        raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        boolean exito = true;

        if (this.raiz == null) {
            this.raiz = new NodoArbol(elemNuevo);
        } else {
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo));
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo));
                    } else {
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    public NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem() == buscado) {
                resultado = n;
            } else {
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        boolean vacio = false;
        if (this.raiz == null) {
            vacio = true;
        }
        return vacio;
    }

    public int altura() {
        return (buscaAlt(this.raiz));
    }

    private int buscaAlt(NodoArbol nodo) {
        int altura1 = -1, altura2 = -1, resultado;
        if (nodo != null) {
            altura1 = buscaAlt(nodo.getIzquierdo()) + 1;
            altura2 = buscaAlt(nodo.getDerecho()) + 1;
        }
        resultado = altura1;
        if (altura1 < altura2) {
            resultado = altura2;
        }
        return resultado;
    }

    public int nivel(Object elem) {
        int cont = 0;
        return buscaNivel(this.raiz, elem, cont);
    }

    private int buscaNivel(NodoArbol nodo, Object elem, int cont) {
        int resultado = 0;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                resultado = cont;
            } else {
                resultado = buscaNivel(nodo.getIzquierdo(), elem, (cont + 1));
                if (resultado == 0) {
                    resultado = buscaNivel(nodo.getDerecho(), elem, (cont + 1));
                }
            }
        }
        return resultado;
    }

    public Object padre(Object elem) {
        return buscaPadre(this.raiz, elem);
    }

    private Object buscaPadre(NodoArbol nodo, Object elem) {
        Object padre = null;
        if (nodo != null) {
            if ((nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem() == elem) || (nodo.getDerecho() != null && nodo.getDerecho().getElem() == elem)) {
                padre = nodo.getElem();
            } else {
                padre = buscaPadre(nodo.getIzquierdo(), elem);
                if (padre == null) {
                    padre = buscaPadre(nodo.getDerecho(), elem);
                }
            }

        }
        return padre;
    }

    public Lista listarPreorden() {
        int cont = 1;
        Lista lista = new Lista();
        return cargaListaPreorden(this.raiz, lista, cont);
    }

    private Lista cargaListaPreorden(NodoArbol nodo, Lista lista, int cont) {
        if (nodo != null) {
            lista.insertar(nodo.getElem(), cont);
            cargaListaPreorden(nodo.getDerecho(), lista, cont + 1);
            cargaListaPreorden(nodo.getIzquierdo(), lista, cont + 1);
        }
        return lista;
    }

    public Lista listarPosorden() {
        int cont = 0;
        Lista lista = new Lista();
        return cargaListaPosorden(this.raiz, lista, cont);
    }

    private Lista cargaListaPosorden(NodoArbol nodo, Lista lista, int cont) {
        if (nodo != null) {
            cargaListaPosorden(nodo.getIzquierdo(), lista, cont + 1);
            cargaListaPosorden(nodo.getDerecho(), lista, cont + 1);
            System.out.println(nodo.getElem());
            lista.insertar(nodo.getElem(), cont);

        }
        return lista;
    }

    public String toString() {
        char vieneDe = 'R';
        return auxToString(this.raiz, vieneDe);
    }

    public String auxToString(NodoArbol nodo, char vieneDe) {
        String miCadena = "";
        if (nodo != null) {
            if (vieneDe == 'I') {
                System.out.print("HI: " + nodo.getElem() + ", ");
            } else {
                if (vieneDe == 'D') {
                    System.out.print("HD: " + nodo.getElem() + ", ");
                } else {
                    if (vieneDe == 'R') {
                        System.out.print("Raiz: " + nodo.getElem() + ", ");
                    }
                }
            }
            auxToString(nodo.getIzquierdo(), 'I');
            auxToString(nodo.getDerecho(), 'D');
        }
        return miCadena;
    }

    public boolean verificarPatron(Lista patron) {
        int cont = 1;
        boolean existe = false;

        if (this.raiz != null && !patron.esVacia()) {
            existe = verifica(this.raiz, patron, cont);
        }

        return existe;
    }

    private boolean verifica(NodoArbol nodo, Lista auxPatron, int cont) {
        boolean pat = false;
        if (nodo != null) {
            if (nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem().equals(auxPatron.recuperar(cont + 1))) {
                pat = verifica(nodo.getIzquierdo(), auxPatron, cont + 1);
            } else {
                if (nodo.getDerecho() != null && nodo.getDerecho().getElem().equals(auxPatron.recuperar(cont + 1))) {
                    pat = verifica(nodo.getDerecho(), auxPatron, cont + 1);
                } else {
                    if (cont == auxPatron.longitud() && nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                        pat = true;
                    }
                }
            }
        }
        return pat;
    }

    public Lista frontera() {
        Lista lista= new Lista();
        if(!esVacio()){
            fronteraAux(this.raiz,lista);
        }
        return lista;
    }

    private void fronteraAux(NodoArbol nodo, Lista lista) {
        if(nodo!=null){
            if(nodo.getIzquierdo()==null && nodo.getDerecho()==null){
                lista.insertar(nodo.getElem(), lista.longitud()+1);
            }
            fronteraAux(nodo.getIzquierdo(),lista);
            fronteraAux(nodo.getDerecho(),lista);
        }
    }

    public ArbolBin clonInver() {
        ArbolBin arbol = new ArbolBin();
        char pos = 'R';
        NodoArbol padre = new NodoArbol(this.raiz);
        return creoClonInver(this.raiz, arbol, pos, padre);
    }

    private ArbolBin creoClonInver(NodoArbol nodo, ArbolBin arbol, char pos, NodoArbol papa) {
        if (nodo != null) {
            if (pos == 'R') {
                arbol.raiz = new NodoArbol(this.raiz.getElem());
                papa = arbol.raiz;
            } else {
                if (pos == 'D') {
                    papa.setIzquierdo(new NodoArbol(nodo.getElem()));
                    if (papa.getIzquierdo() != null) {
                        papa = papa.getIzquierdo();
                    }
                } else {
                    if (pos == 'I') {
                        papa.setDerecho(new NodoArbol(nodo.getElem()));
                        if (papa.getDerecho() != null) {
                            papa = papa.getDerecho();
                        }
                    }
                }
            }

            creoClonInver(nodo.getDerecho(), arbol, 'D', papa);
            creoClonInver(nodo.getIzquierdo(), arbol, 'I', papa);

        }
        return arbol;
    }

    public ArbolBin clonInver2() {
        ArbolBin arbol = new ArbolBin();
        arbol.raiz = new NodoArbol(this.raiz.getElem());
        NodoArbol padre = arbol.raiz;

        return creoClonInver2(this.raiz, padre, arbol);
    }

    private ArbolBin creoClonInver2(NodoArbol nodo, NodoArbol padre, ArbolBin arbol) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                padre.setIzquierdo(new NodoArbol(nodo.getDerecho().getElem()));
                padre.setDerecho(new NodoArbol(nodo.getIzquierdo().getElem()));

            } else {
                if (nodo.getIzquierdo() != null && nodo.getDerecho() == null) {
                    padre.setIzquierdo(new NodoArbol(nodo.getIzquierdo().getElem()));

                } else {
                    if (nodo.getIzquierdo() == null && nodo.getDerecho() != null) {
                        padre.setIzquierdo(new NodoArbol(nodo.getDerecho().getElem()));
                    }
                }
            }
            creoClonInver2(nodo.getIzquierdo(), padre.getIzquierdo(), arbol);
            creoClonInver2(nodo.getDerecho(), padre.getDerecho(), arbol);
        }
        return arbol;
    }

    public Lista armarListaInorden(int x) {
        Lista lista = new Lista();
        if (!esVacio()) {
            armarListaInOrdenAux(x, lista, false, this.raiz);
        }
        return lista;
    }

    private void armarListaInOrdenAux(int x, Lista lista, boolean encontrado, NodoArbol nodo) {
        if (nodo != null) {
            if (!encontrado) {
                if (nodo.getElem().equals(x)) {
                    armarListaInOrdenAux(x, lista, true, nodo);
                }
                if (nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem().equals(x)) {
                    armarListaInOrdenAux(x, lista, true, nodo.getIzquierdo());
                } else {
                    if (nodo.getDerecho() != null && nodo.getDerecho().getElem().equals(x)) {
                        armarListaInOrdenAux(x, lista, true, nodo.getDerecho());
                    } else {
                        armarListaInOrdenAux(x, lista, encontrado, nodo.getIzquierdo());
                        armarListaInOrdenAux(x, lista, encontrado, nodo.getDerecho());
                    }
                }
            }
            if (encontrado) {
                armarListaInOrdenAux(x, lista, encontrado, nodo.getIzquierdo());
                lista.insertar(nodo.getElem(), lista.longitud() + 1);
                armarListaInOrdenAux(x, lista, encontrado, nodo.getDerecho());

            }
        }
    }

    public boolean equals(ArbolBin otro) {
        boolean iguales;
        if (!esVacio() && !otro.esVacio()) {
            iguales = equalsAux(otro.raiz, this.raiz);
        } else {
            iguales = false;
        }
        return iguales;
    }

    private boolean equalsAux(NodoArbol otro, NodoArbol nodo) {
        boolean iguales = true;
        if (nodo != null && otro != null && iguales) {
            if (!nodo.getElem().equals(otro.getElem())) {
                iguales = false;
            } else {
                iguales = equalsAux(otro.getIzquierdo(), nodo.getIzquierdo());
                if (iguales) {
                    iguales = equalsAux(otro.getDerecho(), nodo.getDerecho());
                }
            }
        } else {
            if ((nodo != null && otro == null) || (nodo == null && otro != null)) {
                iguales = false;
            }
        }
        return iguales;
    }

    public boolean verificaPatron(Lista patron) {
        boolean verifica;
        if ((patron.esVacia() && !esVacio()) || (!patron.esVacia() && esVacio())) {
            verifica = false;
        } else {
            verifica = verificaPatronAux(patron, this.raiz, 2);
        }
        return verifica;
    }

    private boolean verificaPatronAux(Lista patron, NodoArbol nodo, int cont) {
        boolean iguales = true;
        if (nodo != null) {
            System.out.println(nodo.getElem());
            if (!this.raiz.getElem().equals(patron.recuperar(1))) {
                iguales = false;
            } else {
                if (nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem().equals(patron.recuperar(cont))) {
                    iguales = verificaPatronAux(patron, nodo.getIzquierdo(), cont + 1);
                } else {
                    if (nodo.getDerecho() != null && nodo.getDerecho().getElem().equals(patron.recuperar(cont))) {
                        iguales = verificaPatronAux(patron, nodo.getDerecho(), cont + 1);
                    } else {
                        if (nodo.getIzquierdo() != null || nodo.getDerecho() != null) {
                            iguales = false;
                        }
                    }
                }
            }
        }
        return iguales;
    }
    

}
