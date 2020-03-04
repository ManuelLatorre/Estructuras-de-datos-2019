/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author Manuel
 */
public class NodoArbol {
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    public NodoArbol(Object elemen, NodoArbol izq, NodoArbol der){
        this.elem=elemen;
        this.izquierdo=izq;
        this.derecho=der;
    }
    public NodoArbol(Object elemen){
        this.elem=elemen;
        this.derecho=null;
        this.izquierdo=null;
    }
    
    public Object getElem(){
        return this.elem;
    }
    
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    
    public void setElem(Object elemen){
        this.elem=elemen;
    }
    
    public void setIzquierdo(NodoArbol izq){
        this.izquierdo=izq;
    }
    
    public void setDerecho(NodoArbol der){
        this.derecho=der;
    }
}
    

