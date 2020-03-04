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
public class Cola {
    private Nodo frente;
    private Nodo fin;
    
    public Cola(){
        this.frente=null;
        this.fin=null;
    }
    
    public boolean poner(Object elem){
        if(this.frente==null){
            Nodo nuevo=new Nodo(elem, null);
            this.fin=nuevo;
            this.frente=nuevo;
        }else{
            Nodo nuevo=new Nodo(elem, null);
            this.fin.setEnlace(nuevo);
            this.fin=nuevo;
        }
        return true;
    }
    
    public boolean sacar(){
        boolean exito;
        if(frente==null){
            exito=false;    
        }else{
          
            this.frente=this.frente.getEnlace();
            if(this.frente==null){
                this.fin=null;
            }
            exito=true;
        }
        return exito;
    }
    
    public Object obtenerFrente(){
        Object elem;
        if(this.frente==null){
            elem=null;
        }else{
            elem=this.frente.getElem();
        }
        return elem;
    }
    
    public boolean esVacia(){
        return this.frente==null;
    }
    
    public void vaciar(){
        this.frente=null;
        this.fin=null;
    }
    
    public Cola clone(){
        Cola clon=new Cola();
        Nodo auxFrente=this.frente;
        Nodo nuevo=new Nodo(auxFrente.getElem(),null);
        clon.frente=nuevo;
        clon.fin=nuevo;
        auxFrente= auxFrente.getEnlace();
        
        while(auxFrente!=this.fin.getEnlace()){
        nuevo=new Nodo(auxFrente.getElem(),null);
        clon.fin.setEnlace(nuevo);
        clon.fin=nuevo;
        auxFrente=auxFrente.getEnlace();
    }
        return clon;
    }
    
    public String toString(){
        Nodo auxFrente=this.frente;
        String string="[";
        while(auxFrente!= null){
            string= string+ auxFrente.getElem()+", ";
            auxFrente=auxFrente.getEnlace();
        }
        string=string+ "  <--";
        return string;
    }
}
