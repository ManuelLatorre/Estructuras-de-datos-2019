/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.linealesTPS;
import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;
/**
 *
 * @author Manuel
 */
public class TestArbolBin {
    public static void main(String[] args) {
       ArbolBin arbol=new ArbolBin();
       ArbolBin arbol2=new ArbolBin();
       Lista lista=new Lista();
       arbol.insertar(4, null, 'R');
       arbol.insertar(3, 4, 'I');
       arbol.insertar(2, 4, 'D');
       arbol.insertar(5, 3, 'I');
       arbol.insertar(1, 2, 'I');
       arbol.insertar(6, 2, 'D');
       arbol.insertar(8, 6, 'I');
       

       arbol.toString();
        System.out.println("");
        arbol2=arbol.clonInver();
        arbol2.toString();
        
    }
}
