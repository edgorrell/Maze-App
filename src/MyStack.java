import java.util.NoSuchElementException;

public class MyStack<T> extends WorkList<T> implements StackADT<T>{

    public T top() throws NoSuchElementException{
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public void add(T item){
        push(item);
    }

    public void push(T item){
        Node<T> n = new Node<T>(item, first);
        this.first = n;
    }

    public T remove(){
        return pop();
    }

    public T pop() throws NoSuchElementException{
        if(first == null){
            throw new NoSuchElementException();
        }
        T item = this.first.item;
        this.first = this.first.next;
        return item;
    }

    public void clear(){
        this.first = null;
    }

    public boolean isEmpty(){
        return this.first == null;
    }
}
