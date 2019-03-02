
package Queue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import java.util.Iterator;
import List.linkedList;


public class QueuelinkedList<T extends Comparable<T>> implements Queue<T>, Iterable<T> {
    
    private linkedList<T>   queue;
    private int      size;
    private int      front = -1;
    private int      back  =  0;
    private int      count =  0;
  
    
    public QueuelinkedList (int size){
       
        queue = new linkedList<>();
        this.size = size;
        this.count = 0;
        this.front = -1;
        this.back = 0;
        for (int i = 0; i < size; i++) {
            queue.add((T) null);
        }
    }
    
    
   
    @Override
    public boolean enqueue(T value) throws isFullException {
        try{
            isfull();
            count ++; //cuantos estan en la cola
            queue.getElementAt(back++ % size).setValue(value); //back es la variable donde se verifica el nuevo
            return true;
        }catch(isFullException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override
    public T dequeue() throws isEmptyException {
        try{
            isempty();
            count--;
            return queue.getElementAt(++front % size).getValue();
        }catch(isEmptyException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean removeAll() throws isEmptyException {
        for (int i = 0; i < size; i++) {
            queue.getElementAt(i).setValue((T)null);
        }
              front = -1;
              back  =  0;
              count =  0;
              return true;
    }

    @Override
    public void isfull() throws isFullException {
        if (count == size)
            throw new isFullException("Full Queue | La cola esta llena");
    }

    @Override
    public void isempty() throws isEmptyException {
        if (count == 0)
            throw new isEmptyException("Empty Queue | La cola esta vacia");
    }
    
    @Override
    public T front() throws isEmptyException {
        try {
           isempty();
           return queue.getElementAt((front+1) % size).getValue();
        } catch (isEmptyException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public T last() throws isEmptyException {
        try {
            isempty();
            return queue.getElementAt((back-1) % size).getValue();
        } catch (isEmptyException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

   @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
        int _count=count;
        int _front=front;
            @Override
            public boolean hasNext() {
                return (_count-- != 0);
            }

            @Override
            public T next() {
                return queue.getElementAt(++_front % size).getValue();
            }
        };
    }

}
