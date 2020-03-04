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
public class NodoGen {
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    public NodoGen (Object elemen, NodoGen hijoIzq, NodoGen hermanoDer){
        this.elem=elemen;
        this.hijoIzquierdo=hijoIzq;
        this.hermanoDerecho=hermanoDer;
    }
    
    public Object getElem(){
        return this.elem;
    }
    
    public NodoGen getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }
    
    public NodoGen getHermanoDerecho(){
        return this.hermanoDerecho;
    }
    
    public void setElem(Object elemen){
        this.elem=elemen;
    }
    
    public void setHijoIzquierdo(NodoGen hijoIzq){
        this.hijoIzquierdo=hijoIzq;
    }
    
    public void setHermanoDerecho(NodoGen hermanoDer){
        this.hermanoDerecho=hermanoDer;
    }
}
