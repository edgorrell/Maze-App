import java.util.NoSuchElementException;

public class MyQueue<T> extends WorkList<T> implements QueueADT<T>{    
    private Node<T> last = null;
    
    public T front(){
        return getFirst();
    }

    @Override
    public void add(T item){
        enqueue(item);
    }

    public void enqueue(T element){
        if(size() == 0){
            first = new Node<T>(element, null);
            last = first;
            return;
        }
        Node<T> node = new Node<T>(element, null);
        last.next = node;
        this.last = node;
    }

    @Override
    public T remove(){
        return dequeue();
    }

    public T dequeue() throws NoSuchElementException{
        if (this.first == null){
            throw new NoSuchElementException();
        }
        T element = this.first.item;
        if(this.first.equals(this.last)){
            this.first = null;
            this.last = null;
            return element;
        } else {
            this.first = this.first.next;
            return element;
        }
    }

    @Override
    public boolean isEmpty(){
        return this.first == null && this.last == null;
    }

    @Override
    public void clear(){
        this.first = null;
        this.last = null;
    }
}

