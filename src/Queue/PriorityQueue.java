package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import Queue.QueueArray;


public class PriorityQueue<T extends QueueArray> {

    static QueueArray<Double>[] dobles = new QueueArray[5];

    enum prioridad {
        Muy_alta, Alta, Media, Baja, Muy_baja
    };



    public static void insert(int prioridad, double dato) {
        try {
            dobles[prioridad].enqueue(dato);
        } catch (isFullException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void print() {
        for (QueueArray<Double> queue : dobles) {
            try {
                queue.isempty();
                for (Double a : queue) {
                    System.out.print(a + ", ");
                }
                System.out.println();
            } catch (isEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
     public static void _init_ () {
        for (int i = 0; i < dobles.length; i++) {
            dobles[i] = new QueueArray<>(Double.class, 4);
        }
    }

    public static void main(String[] args) {
        _init_();
        insert(prioridad.Muy_alta.ordinal(), 1d);
        insert(prioridad.Muy_alta.ordinal(), 2d);
        insert(prioridad.Muy_alta.ordinal(), 3d);
        insert(prioridad.Media.ordinal(), 4d);
        insert(prioridad.Media.ordinal(), 5d);
        insert(prioridad.Baja.ordinal(), 6d);
        insert(prioridad.Muy_baja.ordinal(), 7d);
        insert(prioridad.Alta.ordinal(), 4d);
        print();
    }
}