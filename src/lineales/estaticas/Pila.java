/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author manul
 */
public class Pila {
    private Object [] array;
    private static final int TAM=20;
    private int tope;
    
    public Pila(){
        this.array= new Object[TAM];
        this.tope=-1;
    }
    
    public boolean apilar (Object elem){
        boolean exito;
        if(this.tope+1<TAM){
            tope++;
            array[tope]=elem;
            exito=true;
        }else{
            exito=false;
        }
       return exito;
    }
    
    public boolean desapilar(){
        boolean exito=false;
        if(tope!=-1){
            array[tope]=null;
            tope--;
            exito=true;
        }
        return exito;
    }
    
    public Object obtenerTope(){
        Object estado;
        if(tope==-1){
            estado="No hay tope la pila esta vacia";
        }else{
            estado= this.array[tope];
        }
        return estado;
    }
    
        
    public boolean esVacia(){
        boolean vacio=false;
        if(tope==-1){
            vacio=true;
        }
        return vacio;
    }
    
    public void vaciar(){
        for (int i = 0; i <= tope; i++) {
            array[i]=null;
            tope=-1;
        }
    }
    
    public Pila clone(){
        Pila clon=new Pila();
        clon.array=this.array.clone();
        clon.tope=this.tope;
        return clon;
    }
    
    public String toString(){
        String cadena="";
   
        for (int i = 0; i <= tope; i++) {
            
            cadena= cadena+"Elemento "+(i+1)+": "+array[tope-i]+" - ";
        }
        if(tope==-1){
            cadena= cadena+" --> La pila esta vacia";
        }else{
        cadena= cadena+" --> Tope: "+this.array[tope];
        }
        return cadena;
        
    }
        
    
    
}
