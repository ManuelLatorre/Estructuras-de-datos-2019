/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.linealesTPS;


import lineales.dinamicas.*;
import java.util.Scanner;

/**
 *
 * @author manul
 */
public class TestPila {
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
 
        Pila pila= new Pila();
        Pila clon;
        
        //Apila
        System.out.println("Apilar: "+apilar(pila));
        
        System.out.println(pila.toString());
        
        //Miro si la pila es capicua
        System.out.println("\nEs capicua: "+capicua(sc,pila));
        
        //Desapila
        System.out.println("\nDesapilar: "+desApilar(pila));
        System.out.println(pila.toString());
        
        //Clona una pila en base a otra
       
        System.out.println("\nClon: "+pila.clone().toString());
        
        
        //Obtiene el elemento que esta en el tope
        System.out.println("\nTope: "+obtenerTope(pila));
        
        //Verifica si la pila es vacia
        System.out.println("\nEs vacia?: "+esVacia(pila));
        
        //Vacia la pila
        pila.vaciar();
        System.out.println("\nSe vacio correctamente: "+esVacia(pila));
        System.out.println("\nTope: "+obtenerTope(pila));

        
       
       
    }
    public static boolean apilar(Pila pila) {
        pila.apilar("1");
        pila.apilar("2");
        pila.apilar("3");
        pila.apilar("4");
        return true;//Como lo utilizo para probar y se que apila 
    }
    public static boolean desApilar(Pila pila){
        return pila.desapilar();
    }
    public static Pila clonar(Pila pila) {
        return  pila.clone();
        
    }
    public static Object obtenerTope(Pila pila){
        return pila.obtenerTope();
    }
    public static boolean esVacia(Pila pila) {
        return pila.esVacia();
    }
    public static void vaciar(Pila pila) {
        pila.vaciar();
    }
    public static boolean capicua(Scanner sc,Pila pila) {
           boolean capicua=true;
         Pila pilaNueva=new Pila();
        Pila pilaClon;
        pilaClon=pila.clone();
        while(pilaClon.esVacia()==false){
            pilaNueva.apilar(pilaClon.obtenerTope());
            pilaClon.desapilar();
        }
        
        while((pila.esVacia()==false && capicua==true)){
            if(pila.obtenerTope()!=pilaNueva.obtenerTope()){
                capicua=false;
            }
            pila.desapilar();
            pilaNueva.desapilar();
        }
        vaciar(pila); //Con strings no me desapilaba la pila por alguna razon preguntar en clase
        apilar(pila);
        return capicua;
    }

}
