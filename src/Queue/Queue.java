package Queue;

import Excepciones.*;

public interface   Queue<T> {
    public boolean enqueue (T value) throws isFullException;
    public T       dequeue ()        throws isEmptyException;
    public boolean removeAll()       throws isEmptyException;
    public void    isfull()          throws isFullException;
    public void    isempty()         throws isEmptyException;
    public T       front()           throws isEmptyException; 
    public T       last()            throws isEmptyException;
}
