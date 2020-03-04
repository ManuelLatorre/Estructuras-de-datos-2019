/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

import lineales.dinamicas.Lista;

/**
 *
 * @author Manuel
 */
public class ABB {

    private NodoArbolABB raiz;

    public void ABB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elem) {
        boolean inserto;
        if (this.raiz == null) {
            this.raiz = new NodoArbolABB(elem);
            inserto = true;
        } else {
            inserto = hacerInsercion(this.raiz, elem);
        }

        return inserto;
    }

    private boolean hacerInsercion(NodoArbolABB nodo, Comparable elem) {
        boolean inserto = true;
        if (nodo != null) {
            if (nodo.getElem().compareTo(elem) > 0) {
                if (nodo.getIzquierdo() == null) {
                    nodo.setIzquierdo(new NodoArbolABB(elem));
                } else {
                    inserto = hacerInsercion(nodo.getIzquierdo(), elem);
                }
            } else {
                if (nodo.getElem().compareTo(elem) < 0) {
                    if (nodo.getDerecho() == null) {
                        nodo.setDerecho(new NodoArbolABB(elem));
                    } else {
                        inserto = hacerInsercion(nodo.getDerecho(), elem);
                    }
                } else {
                    inserto = false;

                }
            }
        }

        return inserto;
    }

    public boolean pertenece(Comparable elem) {
        return perteneceAux(this.raiz, elem);
    }

    private boolean perteneceAux(NodoArbolABB nodo, Comparable elem) {
        boolean pertenece = false;
        if (nodo != null && !pertenece) {
            if (nodo.getElem().equals(elem)) {
                pertenece = true;
            } else {
                if (nodo.getElem().compareTo(elem) > 0) {
                    pertenece = perteneceAux(nodo.getIzquierdo(), elem);
                } else {
                    pertenece = perteneceAux(nodo.getDerecho(), elem);
                }

            }

        }
        return pertenece;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo) {
        Lista lista = new Lista();
        return listarRangoAux(this.raiz, lista, elemMinimo, elemMaximo);
    }

    private Lista listarRangoAux(NodoArbolABB nodo, Lista lista, Comparable elemMinimo, Comparable elemMaximo) {
        if (nodo != null) {
            if (nodo.getElem().compareTo(elemMinimo) >= 0 && nodo.getElem().compareTo(elemMaximo) <= 0) {
                lista.insertar(nodo.getElem(), (lista.longitud() + 1));
            }
            if (nodo.getElem().compareTo(elemMinimo) <= 0) {
                listarRangoAux(nodo.getDerecho(), lista, elemMinimo, elemMaximo);
            } else {
                if (nodo.getElem().compareTo(elemMaximo) >= 0) {
                    listarRangoAux(nodo.getIzquierdo(), lista, elemMinimo, elemMaximo);
                } else {
                    if (nodo.getElem().compareTo(elemMinimo) > 0 && nodo.getElem().compareTo(elemMaximo) < 0) {

                        listarRangoAux(nodo.getIzquierdo(), lista, elemMinimo, elemMaximo);
                        listarRangoAux(nodo.getDerecho(), lista, elemMinimo, elemMaximo);
                    }
                }

            }
        }
        return lista;
    }

    public Object minimoElem() {
        Object minimo = null;
        if (!esVacio()) {
            minimo = minimoElemAux(this.raiz).getElem();
        }
        return minimo;
    }

    private NodoArbolABB minimoElemAux(NodoArbolABB nodo) {
        NodoArbolABB minimo;
        if (nodo.getIzquierdo() != null) {
            minimo = minimoElemAux(nodo.getIzquierdo());
        } else {
            minimo = nodo;
        }
        return minimo;
    }

    public Object maximoElem() {
        Object maximo = null;
        if (!esVacio()) {
            maximo = maximoElemAux(this.raiz).getElem();
        }
        return maximo;
    }

    private NodoArbolABB maximoElemAux(NodoArbolABB nodo) {
        NodoArbolABB maximo;
        if (nodo.getDerecho() != null) {
            maximo = maximoElemAux(nodo.getDerecho());
        } else {
            maximo = nodo;
        }
        return maximo;
    }

    public Lista listar() {
        Lista lista = new Lista();

        return listarAux(this.raiz, lista);
    }

    private Lista listarAux(NodoArbolABB nodo, Lista lista) {
        if (nodo != null) {
            listarAux(nodo.getIzquierdo(), lista);
            lista.insertar(nodo.getElem(), (lista.longitud() + 1));
            listarAux(nodo.getDerecho(), lista);
        }
        return lista;
    }

    public boolean eliminar(Comparable elem) {
        return eliminarAux(this.raiz, elem, false);

    }

    private boolean eliminarAux(NodoArbolABB nodo, Comparable elem, boolean elimino) {

        if (nodo != null && !elimino) {
            if (nodo.equals(this.raiz) && nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                this.raiz = null;
            } else {
                if (nodo.getElem().compareTo(elem) == 0 && nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                    caso1(nodo);
                    elimino = true;
                } else {
                    if (nodo.getElem().compareTo(elem) == 0 && ((nodo.getIzquierdo() != null && nodo.getDerecho() == null) || (nodo.getIzquierdo() == null && nodo.getDerecho() != null))) {
                        caso2(nodo);
                        elimino = true;
                    } else {
                        if (nodo.getElem().compareTo(elem) == 0 && nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                            caso3(nodo);
                            elimino = true;
                        }
                    }
                }
                elimino = eliminarAux(nodo.getIzquierdo(), elem, elimino);
                elimino = eliminarAux(nodo.getDerecho(), elem, elimino);
            }
        }
        return elimino;
    }

    public void caso1(NodoArbolABB nodo) {

        NodoArbolABB padreElem;
        padreElem = buscaPadre(this.raiz, nodo);
        if (padreElem.getIzquierdo() != null && padreElem.getIzquierdo().equals(nodo)) {
            padreElem.setIzquierdo(null);
        } else {
            padreElem.setDerecho(null);
        }

    }

    public void caso2(NodoArbolABB nodo) {
        NodoArbolABB padre;
        padre = buscaPadre(this.raiz, nodo);
        if (nodo.equals(this.raiz)) {
            if (nodo.getIzquierdo() != null && nodo.getDerecho() == null) {
                this.raiz = nodo.getIzquierdo();
            } else {
                if (nodo.getIzquierdo() == null && nodo.getDerecho() != null) {
                    this.raiz = nodo.getDerecho();
                }
            }
        } else {
            if (nodo.getIzquierdo() != null && padre.getIzquierdo() != null && padre.getIzquierdo().equals(nodo)) {
                padre.setIzquierdo(nodo.getIzquierdo());
            } else {
                if (nodo.getDerecho() != null && padre.getIzquierdo() != null && padre.getIzquierdo().equals(nodo)) {
                    padre.setIzquierdo(nodo.getDerecho());
                } else {
                    if (nodo.getIzquierdo() != null && padre.getDerecho() != null && padre.getDerecho().equals(nodo)) {
                        padre.setDerecho(nodo.getIzquierdo());
                    } else {
                        if (nodo.getDerecho() != null && padre.getDerecho() != null && padre.getDerecho().equals(nodo)) {
                            padre.setDerecho(nodo.getDerecho());
                        }
                    }
                }
            }
        }
    }

    public void caso3(NodoArbolABB nodo) {
        NodoArbolABB candidato = candidato(nodo.getIzquierdo());
        NodoArbolABB padreCand = buscaPadre(this.raiz, candidato);
        nodo.setElem(candidato.getElem());

        if (candidato.getIzquierdo() != null) {
            padreCand.setIzquierdo(candidato.getIzquierdo());
        } else {
            padreCand.setIzquierdo(null);
        }

    }

    private NodoArbolABB candidato(NodoArbolABB nodo) {
        NodoArbolABB nodoCand = null;
        if (nodo.getDerecho() != null) {
            candidato(nodo.getDerecho());
        } else {
            nodoCand = nodo;
        }

        return nodoCand;
    }

    private NodoArbolABB buscaPadre(NodoArbolABB nodo, NodoArbolABB elem) { //Recibe raiz y el elemento al que quiero buscarle el padre
        NodoArbolABB padre = null;
        if (nodo != null) {
            if ((nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem() == elem.getElem()) || (nodo.getDerecho() != null && nodo.getDerecho().getElem() == elem.getElem())) {
                padre = nodo;
            } else {
                padre = buscaPadre(nodo.getIzquierdo(), elem);
                if (padre == null) {
                    padre = buscaPadre(nodo.getDerecho(), elem);
                }
            }

        }
        return padre;
    }

    public boolean eliminarMinimo() {
        boolean eliminado = false;
        if (!esVacio()) {
            eliminarMinimoAux(this.raiz);
            eliminado = true;
        }
        return eliminado;
    }

    private void eliminarMinimoAux(NodoArbolABB nodo) {
        if (nodo != null) {
            if (nodo.equals(this.raiz) && nodo.getIzquierdo() == null) {
                this.raiz = nodo.getDerecho();
            } else {
                if (nodo.getIzquierdo() == null) {
                    NodoArbolABB padre = buscaPadre(this.raiz, nodo);
                    padre.setIzquierdo(nodo.getDerecho());
                } else {
                    eliminarMinimoAux(nodo.getIzquierdo());
                }
            }

        }
    }

    public ABB clonarParteInvertida(Comparable elem) {
        ABB clon = new ABB();
        clon.raiz=new NodoArbolABB(elem);
        if (!esVacio()) {
            clonarParteInvertidaAux(elem, false, this.raiz,clon.raiz);
        }
        return clon;
    }

    private void clonarParteInvertidaAux(Comparable elem, boolean encontrado, NodoArbolABB nodo, NodoArbolABB clon) {
        if(nodo!=null){
            if(!encontrado){
                if(nodo.getElem().compareTo(elem)>0){
                    clonarParteInvertidaAux(elem,encontrado,nodo.getIzquierdo(),clon);
                }else{
                    if(nodo.getElem().compareTo(elem)<0){
                        clonarParteInvertidaAux(elem,encontrado,nodo.getDerecho(),clon);
                    }else{
                        encontrado=true;
                    }
                }
            }
            if(encontrado){
                if(nodo.getDerecho()!=null){
                    clon.setIzquierdo(new NodoArbolABB(nodo.getDerecho().getElem()));
                }
                
                if(nodo.getIzquierdo()!=null){
                    clon.setDerecho(new NodoArbolABB(nodo.getIzquierdo().getElem()));
                }
                clonarParteInvertidaAux(elem,encontrado,nodo.getIzquierdo(),clon.getDerecho());
                clonarParteInvertidaAux(elem,encontrado,nodo.getDerecho(),clon.getIzquierdo());
            }
        }
    }

    public boolean eliminarMinSubArbol(Comparable elem) {
        boolean exito = false;
        if (!esVacio()) {
            exito = eliminarMinSubArbolAux(this.raiz, elem, null);
        }
        return exito;
    }

    private boolean eliminarMinSubArbolAux(NodoArbolABB nodo, Comparable elem, NodoArbolABB padre) {
        boolean exito = false;
        if (this.raiz.getElem().equals(elem) && this.raiz.getIzquierdo() == null) {
            this.raiz = this.raiz.getDerecho();
        } else {
            if (nodo.getIzquierdo() != null && padre == null) {
                if (nodo.getIzquierdo().getElem().equals(elem) || nodo.getDerecho().getElem().equals(elem)) {
                    padre = nodo;
                }

                if (nodo.getElem().compareTo(elem) > 0) {
                    exito = eliminarMinSubArbolAux(nodo.getIzquierdo(), elem, padre);
                } else {
                    if (nodo.getElem().compareTo(elem) < 0) {
                        exito = eliminarMinSubArbolAux(nodo.getDerecho(), elem, padre);
                    }
                }
            }

            if (!exito && padre != null) {
                if (padre.getIzquierdo().equals(nodo)) {
                    if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                        padre.setIzquierdo(null);
                        exito = true;
                    }
                    if (nodo.getIzquierdo() == null && nodo.getDerecho() != null) {
                        padre.setIzquierdo(nodo.getDerecho());
                        exito = true;
                    }
                    if (nodo.getIzquierdo() != null) {

                        exito = eliminarMinSubArbolAux(nodo.getIzquierdo(), elem, nodo);
                    }
                } else {
                    if (padre.getDerecho().equals(nodo)) {
                        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                            padre.setDerecho(null);
                            exito = true;
                        }
                        if (nodo.getIzquierdo() == null && nodo.getDerecho() != null) {
                            padre.setDerecho(nodo.getDerecho());
                            exito = true;
                        }
                        if (nodo.getIzquierdo() != null) {
                            exito = eliminarMinSubArbolAux(nodo.getIzquierdo(), elem, nodo);
                        }
                    }
                }
            }
        }
        return exito;
    }

    public Lista listarMayoresQue(Comparable valor, Comparable elem) {
        Lista lista = new Lista();
        if (!esVacio()) {
            listarMayoresQueAux(valor,elem,lista,false,this.raiz);
        }
        return lista;
    }
    
    public void listarMayoresQueAux(Comparable valor,Comparable elem, Lista lista,boolean encontrado, NodoArbolABB nodo){
        if(nodo!=null){
            if(!encontrado){
                if(nodo.getElem().compareTo(elem)>0){
                    listarMayoresQueAux(valor,elem,lista,encontrado,nodo.getIzquierdo());
                }else{
                    if(nodo.getElem().compareTo(elem)<0){
                        listarMayoresQueAux(valor,elem,lista,encontrado,nodo.getDerecho());
                    }else{
                        encontrado=true;
                    }
                }
            }
            if(encontrado){
                if(nodo.getIzquierdo()!=null && nodo.getIzquierdo().getDerecho()!=null && nodo.getIzquierdo().getDerecho().getElem().compareTo(valor)>0){
                    listarMayoresQueAux(valor,elem,lista,encontrado,nodo.getIzquierdo());
                }
                if(nodo.getIzquierdo()!=null && nodo.getIzquierdo().getElem().compareTo(valor)>0){
                    listarMayoresQueAux(valor,elem,lista,encontrado,nodo.getIzquierdo());
                }
                if(nodo.getElem().compareTo(valor)>0){
                    lista.insertar(nodo.getElem(),(lista.longitud()+1));
                }
                listarMayoresQueAux(valor,elem,lista,encontrado,nodo.getDerecho());
            }
        }
}
}
