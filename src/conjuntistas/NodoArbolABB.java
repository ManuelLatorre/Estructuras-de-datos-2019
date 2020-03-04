/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;


/**
 *
 * @author Manuel
 */
public class NodoArbolABB {
    private Comparable elem;
    private NodoArbolABB izquierdo;
    private NodoArbolABB derecho;
    
    public NodoArbolABB(Comparable elemen, NodoArbolABB izq, NodoArbolABB der){
        this.elem=elemen;
        this.izquierdo=izq;
        this.derecho=der;
    }
    public NodoArbolABB(Comparable elemen){
        this.elem=elemen;
        this.derecho=null;
        this.izquierdo=null;
    }
    
    public Comparable getElem(){
        return this.elem;
    }
    
    public NodoArbolABB getIzquierdo(){
        return this.izquierdo;
    }
    
    public NodoArbolABB getDerecho(){
        return this.derecho;
    }
    
    public void setElem(Comparable elemen){
        this.elem=elemen;
    }
    
    public void setIzquierdo(NodoArbolABB izq){
        this.izquierdo=izq;
    }
    
    public void setDerecho(NodoArbolABB der){
        this.derecho=der;
    }
}
    

