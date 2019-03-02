package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import java.lang.reflect.Array;
import java.util.Iterator;



public class QueueArray<T extends Comparable<T>> implements Queue<T>, Iterable<T> {
    
    private T[]      queue;
    private int      size;
    private int      front = -1;
    private int      back  =  0;
    private int      count =  0;
    private Class<T> type  = null;
    
    public QueueArray(Class<T> type, int size){
        this.type    = type;
        this.size    = size; 
        this.queue   = (T[]) Array.newInstance(type, size);
    }
    public QueueArray(Class<T> type){
        this(type,10);
    }
    
    @Override
    public boolean enqueue(T value) throws isFullException {
        try{
            isfull();
            queue[back++  % size ] = value; //back es la variable back verifica donde se inserta el nuevo 
            count ++; //cuantos estan en la cola
            return true;
        }catch(isFullException e){
            System.err.println("Full Queue | Cola llena");
            return false;
        }
    }
    
    @Override
    public T dequeue() throws isEmptyException {
        try{
            isempty();
            count--;
            return queue[++front % size  ]; //front es la variable donde va a salir el siguiente valor
        }catch(isEmptyException e){
            System.err.println("Empty Queue | Cola vacia");
            return null;
        }
    }

    @Override
    public boolean removeAll() throws isEmptyException {
              front = -1;
              back  =  0;
              count =  0;
              return true;
    }

    @Override
    public void isfull() throws isFullException {
        if (count == size)
            throw new isFullException("Full Queue | Cola llena");
    }

    @Override
    public void isempty() throws isEmptyException {
        if (count == 0)
            throw new isEmptyException("Empty Queue | Cola vacia");
    }
    
    @Override
    public T front() throws isEmptyException {
        return queue[(front+1) %size];
    }

    @Override
    public T last() throws isEmptyException {
        return queue[(back-1) %size];
    }

            int _front = 0;
            int _count = 0;
            
    @Override
    public Iterator<T> iterator() {
        _front = front;
        _count = count;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return (_count--!=0);
            }
            @Override
            public T next() {
                return queue[++_front %size];
            }
        };
    }
    public static void main(String[] args) {
        QueueArray<Double> enteros = new QueueArray<>(Double.class,4);
        try {
            enteros.enqueue(20d);
            enteros.enqueue(17d);
            enteros.enqueue(12d);
            System.out.println("salio el valor de: "+enteros.dequeue());
            enteros.enqueue(-40d);
            enteros.enqueue(15d);
            enteros.enqueue(-1d);
            
        } catch (isEmptyException | isFullException e) {
            System.err.println(e.getMessage());
        }
        
    }

}