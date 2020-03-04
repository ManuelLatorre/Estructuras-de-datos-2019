/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.linealesTPS;

/**
 *
 * @author Manuel
 */
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
public class MixLineales {
    public static void main(String[] args) {
        Cola c1= new Cola();
        c1.poner('A');
        c1.poner('B');
        c1.poner('$');
        c1.poner('C');
        c1.poner('$');
        c1.poner('D');
        c1.poner('E');
        c1.poner('F');
        System.out.println(c1.toString());
        Cola c2= generarOtraCola(c1);
        System.out.println(c2.toString());
      
    }
    public static Cola generarOtraCola(Cola c1){
        Cola c2 = new Cola();
        Cola auxCola=c1;
        Pila auxPila = new Pila();
        
        while (auxCola.obtenerFrente()!=null){
            if(auxCola.obtenerFrente().equals('$')){             
                while(!auxPila.esVacia()){
                    c2.poner(auxPila.obtenerTope());
                    auxPila.desapilar();
                }
                c2.poner(auxCola.obtenerFrente());
                auxCola.sacar();
                    
            }else{
                c2.poner(auxCola.obtenerFrente());
                auxPila.apilar(auxCola.obtenerFrente());
                auxCola.sacar();   
            } 

        }
        while(!auxPila.esVacia()){
            c2.poner(auxPila.obtenerTope());
            auxPila.desapilar();
        }
        return c2;
    }
}
