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
public class ArbolGen {

    private NodoGen raiz;

    public void ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        NodoGen nodoPadre, hijo;
        boolean exito;
        if (this.raiz == null) {
            this.raiz = new NodoGen(elemNuevo, null, null);
            exito = true;
        } else {
            nodoPadre = buscoPadre(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (nodoPadre.getHijoIzquierdo() == null) {
                    nodoPadre.setHijoIzquierdo(new NodoGen(elemNuevo, null, null));
                    exito = true;
                } else {
                    hijo = nodoPadre.getHijoIzquierdo();
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    NodoGen nuevo = new NodoGen(elemNuevo, null, null);
                    hijo.setHermanoDerecho(nuevo);
                    exito = true;
                }
            } else {
                exito = false;
            }
        }

        System.out.println(listarPreOrden());

        return true;
    }

    private NodoGen buscoPadre(NodoGen nodo, Object elemPadre) {
        NodoGen padre = null;

        if (nodo != null) {
            if (nodo.getElem().equals(elemPadre)) {
                padre = nodo;
            } else {
                padre = buscoPadre(nodo.getHijoIzquierdo(), elemPadre);
                if (padre == null) {
                    padre = buscoPadre(nodo.getHermanoDerecho(), elemPadre);
                }
            }
        }
        return padre;
    }

    public boolean esVacio() {
        boolean vacio = false;
        if (this.raiz == null) {
            vacio = true;
        }
        return vacio;
    }

    public int altura() {
        int result = -1;
        if (!esVacio()) {
            result = buscoAltura(this.raiz);
        }
        return result;
    }

    private int buscoAltura(NodoGen nodo) {
        int result, alt1 = 0, alt2 = 0;
        if (nodo != null) {
            if (nodo.getHermanoDerecho() != null) {
                alt1 = buscoAltura(nodo.getHermanoDerecho());

            }
            if (nodo.getHijoIzquierdo() != null) {
                alt2 = buscoAltura(nodo.getHijoIzquierdo()) + 1;
            }
        }
        result = alt1;
        if (alt1 < alt2) {
            result = alt2;

        }

        return result;
    }

    public boolean pertenece(Object elem) {
        boolean encontrado = false;
        if (this.raiz.getElem().equals(elem)) {
            encontrado = true;
        } else {
            if (!esVacio()) {
                encontrado = buscoElem(this.raiz, elem, encontrado);
            }
        }
        return encontrado;
    }

    private boolean buscoElem(NodoGen nodo, Object elem, boolean encontrado) {

        if (nodo != null && !encontrado) {
            System.out.print(nodo.getElem());
            if (nodo.getElem().equals(elem)) {
                encontrado = true;
            }
            if (nodo.getHermanoDerecho() == null) {
                encontrado = buscoElem(nodo.getHijoIzquierdo(), elem, encontrado);
            } else {
                encontrado = buscoElem(nodo.getHermanoDerecho(), elem, encontrado);
                if (nodo.getHijoIzquierdo() != null) {
                    encontrado = buscoElem(nodo.getHijoIzquierdo(), elem, encontrado);
                }

            }
        }
        return encontrado;
    }

    public Object padre(Object elem) {
        
        return padreAux(this.raiz, elem, false);
    }

    private Object padreAux(NodoGen n,Object elem,boolean parar){
        Object padre="";
        if(n!=null){          
            NodoGen hijo = n.getHijoIzquierdo();          
            while(hijo != null && !parar){
                if(hijo.getElem().equals(elem)){
                    padre = n.getElem();
                    parar = true;
                }else{
                    hijo = hijo.getHermanoDerecho();
                }
            }
            hijo = n.getHijoIzquierdo();
            while(hijo!=null && !parar && padre.equals("")){
                padre = padreAux(hijo,elem,parar);
                hijo = hijo.getHermanoDerecho();
            }         
        }
        return padre;
    }

    public ArbolGen clonar() {
        ArbolGen clon = new ArbolGen();
        imprimo(this.raiz);
        if (!esVacio()) {
            clon.raiz = new NodoGen(this.raiz.getElem(), null, null);
            clono(this.raiz, clon.raiz);
        }

        return clon;
    }

    private void imprimo(NodoGen nodo) { //ELIMINAR
        if (nodo != null) {

            System.out.print(nodo.getElem());

            if (nodo.getHermanoDerecho() != null) {
                imprimo(nodo.getHermanoDerecho());
            }
            if (nodo.getHijoIzquierdo() != null) {
                imprimo(nodo.getHijoIzquierdo());
            }

        }

    }

    private void clono(NodoGen nodo, NodoGen nodoClon) {
        if (nodo != null) {
            if (nodo.getHermanoDerecho() != null) {
                nodoClon.setHermanoDerecho(new NodoGen(nodo.getHermanoDerecho().getElem(), null, null));
                clono(nodo.getHermanoDerecho(), nodoClon.getHermanoDerecho());

            }
            if (nodo.getHijoIzquierdo() != null) {
                nodoClon.setHijoIzquierdo(new NodoGen(nodo.getHijoIzquierdo().getElem(), null, null));
                clono(nodo.getHijoIzquierdo(), nodoClon.getHijoIzquierdo());
            }
        }

    }

    public int nivel(Object elem){
        return buscoNivel(this.raiz,elem,0);
    }
    
    private int buscoNivel(NodoGen nodo,Object elem,int contador){
        int nivel=0;
            if (nodo != null) {
            if(nodo.getElem().equals(elem)){
                nivel=contador;
            }else{
                nivel= buscoNivel(nodo.getHijoIzquierdo(),elem,(contador+1));
                if(nivel==0){
                    nivel=buscoNivel(nodo.getHermanoDerecho(),elem,contador);
                }
            }
        }
        return nivel;
    }
    public Lista listarPreOrden() {
        Lista lista = new Lista();
        listarPreOrdenAux(this.raiz, lista);
        return lista;
    }

    private void listarPreOrdenAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            lista.insertar(nodo.getElem(), lista.longitud() + 1);

            if (nodo.getHijoIzquierdo() != null) {
                listarPreOrdenAux(nodo.getHijoIzquierdo(), lista);

                NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarPreOrdenAux(hijo, lista);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }
    
    public Lista ancestros(Object elem){
        Lista lista= new Lista();
        listoAncestros(this.raiz,lista,elem,false);
        return lista;
    }
    
    private ArbolGen listoAncestros(NodoGen nodo,Lista lista,Object elem,boolean encontrado){
        ArbolGen ancestro1=new ArbolGen();
         ArbolGen ancestro2=new ArbolGen();
        if(nodo!=null && !encontrado ){
            if(nodo.getHermanoDerecho()!=null){
                ancestro1= listoAncestros(nodo.getHermanoDerecho(),lista,elem,encontrado);
                
            }

            if(nodo.getHijoIzquierdo()!=null){       
                ancestro1=listoAncestros(nodo.getHijoIzquierdo(),lista,elem,encontrado);
            }
          
           
        }
        return ancestro1;
    }
        
    
    
    
    
    public Lista listarPosOrden(){
        Lista lista= new Lista();
        listarPosOrdenAux(this.raiz,lista);
        return lista;
    }
    private void listarPosOrdenAux(NodoGen nodo, Lista lista){
        if(nodo!=null){
            if(nodo.getHijoIzquierdo()!=null){
                listarPosOrdenAux(nodo.getHijoIzquierdo(),lista);
                NodoGen hijo= nodo.getHijoIzquierdo().getHermanoDerecho();
                while(hijo!=null){
                    listarPosOrdenAux(hijo,lista);
                    hijo= hijo.getHermanoDerecho();
                }
            }
            lista.insertar(nodo.getElem(),lista.longitud()+1);
        }
    }
    
    public Lista listarInOrden(){
        Lista lista= new Lista();
        listarInOrdenAux(this.raiz,lista);
        return lista;
    }
    private void listarInOrdenAux(NodoGen nodo, Lista lista){
        if(nodo!=null){
            if(nodo.getHijoIzquierdo()!=null){
                listarInOrdenAux(nodo.getHijoIzquierdo(),lista);
            }
            lista.insertar(nodo.getElem(), (lista.longitud()+1));
            
            if(nodo.getHijoIzquierdo()!=null){
                NodoGen hijo= nodo.getHijoIzquierdo().getHermanoDerecho();
                while(hijo!=null){
                    listarPosOrdenAux(hijo,lista);
                    hijo=hijo.getHermanoDerecho();
                }
            }
        }
    }
    
    public void insertarEnPosicion(Object elem,Object padre,int pos){
        if(!esVacio()){
            insertarEnPosicionAux(elem,padre,pos,this.raiz,false,0,false);
        }
    }
    
    private void insertarEnPosicionAux(Object elem, Object padre,int pos, NodoGen nodo,boolean insertado,int cont,boolean padreEnc){
        if(nodo!=null&& !insertado){
            if(nodo.getElem().equals(padre)){
                padreEnc=true;
            }else{
                if(!padreEnc){
                insertarEnPosicionAux(elem,padre,pos,nodo.getHijoIzquierdo(),insertado,cont,padreEnc);
                insertarEnPosicionAux(elem,padre,pos,nodo.getHermanoDerecho(),insertado,cont,padreEnc);
                }
            }
            
            if(padreEnc){
                if(pos==1){
                    nodo.setHijoIzquierdo(new NodoGen(elem,null,nodo.getHijoIzquierdo()));
                    insertado=true;
                }else{
                    if(cont==0){
                        cont++;
                        insertarEnPosicionAux(elem,padre,pos,nodo.getHijoIzquierdo(),insertado,cont,padreEnc);
                    }else{
                        if((cont<(pos-1) || pos<0)&& nodo.getHermanoDerecho()!=null){
                          
                            insertarEnPosicionAux(elem,padre,pos,nodo.getHermanoDerecho(),insertado,(cont+1),padreEnc);
                        }else{
                            if(cont==(pos-1) || nodo.getHermanoDerecho()==null){   
                                nodo.setHermanoDerecho(new NodoGen (elem,null,nodo.getHermanoDerecho()));
                                insertado=true;
                            }
                        }
                    }
                }
            }
            if(insertado){
                insertarEnPosicionAux(elem,padre,pos,nodo,insertado,cont,padreEnc);
            }
        }
    }
}
