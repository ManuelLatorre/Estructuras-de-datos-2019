/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import conjuntistas.ABB;
import java.lang.Comparable;
import lineales.dinamicas.Lista;
/**
 *
 * @author Manuel
 */
public class TestArbolABB {
    public static void main(String[] args) {
        ABB arbol = new ABB();
        //System.out.println("ALtura null:"+  arbol.altura());
        Object uno=1, dos=2;
        Lista lista=new Lista();
        System.out.println( arbol.insertar(56));
        System.out.println( arbol.insertar(13));
        System.out.println( arbol.insertar(7));
        System.out.println( arbol.insertar(24));
        System.out.println( arbol.insertar(15));
        System.out.println( arbol.insertar(78));
        System.out.println( arbol.insertar(100));
        
        System.out.println(arbol.listar());
        /*System.out.println(arbol.pertenece(7));
        System.out.println(arbol.esVacio());
        System.out.println(arbol.listarRango(7,100));*/
     //   System.out.println(arbol.eliminarMinimo());
        //System.out.println(arbol.listar());
      /*  ABB clon;
        clon=arbol.clonarParteInvertida(13);
        System.out.println(clon.listar());
        lista= arbol.listarMayoresQue(9, 12);
        System.out.println(lista.toString());*/
        
        ABB clon= arbol.clonarParteInvertida(13);
        System.out.println(clon.listar());

    }
}
