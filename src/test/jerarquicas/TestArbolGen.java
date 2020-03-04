/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import jerarquicas.ArbolGen;

/**
 *
 * @author Manuel
 */
public class TestArbolGen {
    public static void main(String[] args) {
        ArbolGen arbol= new ArbolGen();
       
        arbol.insertar('A', null);
        arbol.insertar('H', 'A');
        arbol.insertar('B', 'A');
        arbol.insertar('Z', 'A');
        arbol.insertar('D', 'H');
        arbol.insertar('M', 'H');
        arbol.insertar('Q', 'H');
        arbol.insertar('P', 'D');
        arbol.insertar('B', 'D');
        arbol.insertar('L', 'Q');
        arbol.insertar('F', 'Z');
        arbol.insertar('C', 'Z');
        arbol.insertar('J', 'Z');
        arbol.insertar('W', 'F');
        arbol.insertar('H', 'F');
        arbol.insertar('V', 'J');
        arbol.insertar('M', 'J');      
        arbol.insertarEnPosicion('R', 'A', 5);
        System.out.println(arbol.listarPreOrden());
        
    }
}
