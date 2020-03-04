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
public class Cola {
    private int TAM=6;
    private Object[]array;
    private int frente;
    private int fin;
    
    public Cola(){
        this.array=new Object[TAM];
        this.frente=0;
        this.fin=0;
    }
    
    public boolean poner(Object elem){
        boolean exito;
        if ((this.fin+1) % this.TAM!=frente){
            this.array[fin]=elem;
            this.fin=(fin+1)%TAM;
            exito=true;
        }else{
                exito=false;
        }
        
        return exito;
    }
    
    public boolean sacar(){
        boolean exito;
        if(this.esVacia()){
            exito=false;
        }else{
            this.frente= ((this.frente +1)%this.TAM);
            exito=true;
        }
        return exito;
    }
    
    public Object obtenerFrente(){
        Object objFrente;
        if(esVacia()){
            objFrente= "\033[31mNo se puede obtener el frente ya que la cola esta vacia";
        }else{
            objFrente=this.array[this.frente];
        }
        return objFrente;
    }
    
    public boolean esVacia(){    
        return this.array[this.frente]==null;
    }
    
    public void vaciar(){
        while((this.fin) % this.TAM!= this.frente){
            this.array[this.fin-1]=null;
            this.fin=fin-1;
        }
        this.fin=0;
        this.frente=0;
    }
    
    public Cola clone(){
        Cola clon= new Cola();
        clon.array=this.array.clone();
        clon.fin=this.fin;
        clon.frente=this.frente;
        return clon;
    }
    
    public String toString(){
        String string="[";
        int auxFrente=this.frente;
        if(esVacia()){
            string="La cola esta vacia";
        }else{
            while((this.fin) % this.TAM != auxFrente){
                string= string +this.array[auxFrente]+", ";
                auxFrente= ((auxFrente +1)%this.TAM);
            }
            string= string+ " <--";
        }
        return string;
    }
    
    

    
}
