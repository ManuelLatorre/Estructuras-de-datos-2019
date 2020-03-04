/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.linealesTPS;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

/**
 *
 * @author Manuel
 */
public class TestCadenas {
    public static void main(String[] args) {
        Cola cola= new Cola();
        cola.poner('A');
        cola.poner('B');
        cola.poner('#');
        cola.poner('C');
        cola.poner('#');
        cola.poner('D');
        cola.poner('E');
        cola.poner('F');
        System.out.println(generar(cola).toString());
    }
    public static Cola generar(Cola c1) {
        Cola nueva=new Cola();
        Cola auxCola= c1;
        Cola auxCola2= new Cola();
        Pila pila= new Pila();
        while(auxCola.obtenerFrente()!=null){
            if(auxCola.obtenerFrente().equals('#')){
                while(!pila.esVacia()){
                    nueva.poner(pila.obtenerTope());
                    pila.desapilar();
                }
                while(!auxCola2.esVacia()){
                    nueva.poner(auxCola2.obtenerFrente());
                    auxCola2.sacar();
                }
                if(!auxCola.esVacia()){
                nueva.poner(auxCola.obtenerFrente());
                auxCola.sacar();
                }
            }else{
                
                nueva.poner(auxCola.obtenerFrente());
                pila.apilar(auxCola.obtenerFrente());  
                auxCola2.poner(auxCola.obtenerFrente());
                auxCola.sacar();    
            }
            if(auxCola.esVacia()){
                while(!pila.esVacia()){
                    nueva.poner(pila.obtenerTope());
                    pila.desapilar();
                }
                while(!auxCola2.esVacia()){
                    nueva.poner(auxCola2.obtenerFrente());
                    auxCola2.sacar();
                }
            }
            
        }      
        return nueva;
    }
}
