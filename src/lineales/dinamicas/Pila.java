/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author manul
 */
public class Pila {
    private Nodo tope;
    
    public Pila(){
        this.tope=null;
    }
    
    public boolean apilar(Object nuevoElem){
        Nodo nuevo= new Nodo(nuevoElem, this.tope);
        this.tope= nuevo;
        return true;
    }
    
    public boolean desapilar(){
        boolean exito=false;
        if(this.tope!=null){
        this.tope= this.tope.getEnlace();
        exito=true;
        }
        return exito;
    }
    
    public Object obtenerTope(){
        Object estado;
        if(tope==null){
            estado="No se puedo obtener el tope, la pila esta vacia";
        }else{
            estado=this.tope.getElem();
        }
        return estado;
    }
    
    public boolean esVacia(){
        boolean vacia=false;
        if(this.tope==null){
            vacia=true;
        }
        return vacia;
    }
    
    public void vaciar(){
        tope=null;
    }
    
    
    public Pila clone(){
        return cloneAux(this.tope);
    }

    private Pila cloneAux(Nodo nodo){
        Pila clon=new Pila();
     
        if(this.tope!=null){
        if(nodo.getEnlace()==null){
           clon.apilar(nodo.getElem());
        }else{
            clon= cloneAux(nodo.getEnlace());
            clon.apilar(nodo.getElem());
        }
        }
        return clon;
    }
    
    public String toString(){
        String s="";

        if(this.tope==null){
            s= "Pila vacia";
        }else{
            Nodo aux=this.tope;
        
            while(aux!=null){
                s=s+ aux.getElem().toString()+", ";
                aux=aux.getEnlace();
            }
        }
        return s;
    }
    
}
