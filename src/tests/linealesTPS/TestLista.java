/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.linealesTPS;
import lineales.dinamicas.Lista;

/**
 *
 * @author Manuel
 */
public class TestLista {
    public static void main(String[] args) {
        Lista lista= new Lista();
        lista.insertar(1, 1);
        lista.insertar(2, 2);
        lista.insertar(3, 3);
        lista.insertar(4, 4);
        lista.insertar(5, 5);
        lista.insertar(6, 6);
        lista.insertar(7, 7);
      
       
        System.out.println(lista.toString());
        /*System.out.println(lista.obtenerMultiplos(3).toString());
        lista.eliminarApariciones('D');
        System.out.println(lista.toString());*/
        lista.agregarProducto(2);
        System.out.println(lista.toString());
        
    }
}
