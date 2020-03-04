/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.linealesTPS;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;
import static tests.linealesTPS.TestCadenas.generar;

/**
 *
 * @author Manuel
 */
public class TestMatematica {

    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.poner('A');
        cola.poner('B');
        cola.poner('#');
        cola.poner('C');
        cola.poner('#');
        cola.poner('D');
        cola.poner('E');
        cola.poner('F');


        /*Cola cola2=cola.clone();
        cola2.sacar();
        System.out.println(cola.toString());
        System.out.println(cola2.toString());
        System.out.println("Es balanceada " + verificarBalanceo(cola));
        Lista lista = generarSecuenciaInver(cola, 4);
        System.out.println(lista.toString());*/
        Cola cola2 = generar(cola);
        System.out.println(cola2.toString());

    }

    public static boolean verificarBalanceo(Cola cola) {
        Pila pila = new Pila();
        boolean balanceado = true;
        while (!cola.esVacia() && balanceado) {
            if (cola.obtenerFrente().equals('[') || cola.obtenerFrente().equals('(') || cola.obtenerFrente().equals('{')) {
                pila.apilar(cola.obtenerFrente());
                cola.sacar();
            }

            if (cola.obtenerFrente().equals(']') && pila.obtenerTope().equals('[')) {
                pila.desapilar();
            } else {
                if (cola.obtenerFrente().equals(']') && !pila.obtenerTope().equals('[')) {
                    balanceado = false;
                }
            }

            if (cola.obtenerFrente().equals(')') && pila.obtenerTope().equals('(')) {
                pila.desapilar();
            } else {
                if (cola.obtenerFrente().equals(')') && !pila.obtenerTope().equals('(')) {
                    balanceado = false;
                }
            }

            if (cola.obtenerFrente().equals('}') && pila.obtenerTope().equals('{')) {
                pila.desapilar();
            } else {
                if (cola.obtenerFrente().equals('}') && !pila.obtenerTope().equals('{')) {
                    balanceado = false;
                }
            }

            cola.sacar();
        }

        if (!pila.esVacia()) {
            balanceado = false;
        }
        return balanceado;
    }

    public static Lista generarSecuencia(Cola cola, int t) {
        int cont = 0, cont2 = 0;
        Lista lista = new Lista();
        Cola colaAux = cola.clone();
        Pila pila = new Pila();

        while (!cola.esVacia()) {
            while (cont < t && !colaAux.esVacia()) {
                pila.apilar(colaAux.obtenerFrente());
                colaAux.sacar();
                cont++;
            }
            if (cont2 < t) {
                lista.insertar(cola.obtenerFrente(), (lista.longitud() + 1));
                cola.sacar();
                cont2++;
            } else {
                if (!pila.esVacia()) {
                    lista.insertar(pila.obtenerTope(), (lista.longitud() + 1));
                    pila.desapilar();
                }
            }
            if (pila.esVacia()) {
                cont = 0;
                cont2 = 0;
            }
        }

        while (!pila.esVacia()) {
            lista.insertar(pila.obtenerTope(), (lista.longitud() + 1));
            pila.desapilar();
        }
        return lista;
    }

    public static Lista generarSecuenciaInver(Cola cola, int t) {
        Cola colaAux = cola.clone();
        Pila pila = new Pila();
        Lista lista = new Lista();
        int cont = 0, cont2 = 0;
        while (!cola.esVacia()) {
            while (cont < t && !colaAux.esVacia()) {
                pila.apilar(colaAux.obtenerFrente());
                colaAux.sacar();
                cont++;
            }
            if (!pila.esVacia()) {
                lista.insertar(pila.obtenerTope(), (lista.longitud() + 1));
                pila.desapilar();
            } else {
                if (cont2 < t) {
                    lista.insertar(cola.obtenerFrente(), (lista.longitud() + 1));
                    cola.sacar();
                    cont2++;
                }
            }
            if (cont2 >= t) {
                cont2 = 0;
                cont = 0;
            }
        }
        return lista;
    }

    public static Cola generar(Cola cola) {
        Cola cola2 = new Cola();
        Pila pila = new Pila();
        Cola colaAux = cola.clone();
        while (!cola.esVacia()) {

            while (!colaAux.esVacia() && !colaAux.obtenerFrente().equals('#')) {
                pila.apilar(colaAux.obtenerFrente());
                cola2.poner(colaAux.obtenerFrente());
                colaAux.sacar();
            }

            while (!pila.esVacia()) {
                cola2.poner(pila.obtenerTope());
                pila.desapilar();
            }
            while (!cola.esVacia() && !cola.obtenerFrente().equals('#')) {
                cola2.poner(cola.obtenerFrente());
                cola.sacar();
            }

            if (!cola.esVacia()) {
                colaAux.sacar();
                cola.sacar();
                cola2.poner('#');
            }
        }
        return cola2;
    }
}
