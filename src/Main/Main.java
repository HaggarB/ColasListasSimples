package Main;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import Queue.QueuelinkedList;

public class Main {

    //public static QueuelinkedList<Double> numeritos;

    public static void main(String[] args) throws isFullException, isEmptyException {

        QueuelinkedList<Double> numeritos = new QueuelinkedList<>(7);
        
        //agregando numeros en la cola
        
        numeritos.enqueue(3d);
        numeritos.enqueue(15d);
        numeritos.enqueue(21d);
        numeritos.enqueue(14d);
        numeritos.enqueue(16d);
        numeritos.enqueue(113d);
        numeritos.enqueue(-4d);
        
        for (Double numerito : numeritos) {
            System.out.println(numerito);
        }
        
        System.out.println("El ultimo numero de la cola es: " + numeritos.last());
        System.out.println("El numero en dequeue es: " + numeritos.dequeue());
        System.out.println("El numero en front es: " + numeritos.front());
        
        /*for (Double numerito : numeritos) {
            System.out.println(numerito);
        }*/
        
        numeritos.enqueue(33d);
        numeritos.enqueue(555d);
        
        
        System.out.println("El ultimo numero de la cola es: " + numeritos.last());
        System.out.println("El numero en dequeue es: " + numeritos.dequeue());
        System.out.println("El numero en front es: " + numeritos.front());
        
        //probando removeAll
        numeritos.removeAll();
        
        for (Double numerito : numeritos) {
            System.out.println(numerito);
        }
        
        //Probando isempty
        System.out.println("El ultimo numero de la cola es: " + numeritos.last());
        System.out.println("El numero en dequeue es: " + numeritos.dequeue());
        System.out.println("El numero en front es: " + numeritos.front());
        
     

    }

}
