import java.util.NoSuchElementException;

public class MyStack<T> extends WorkList<T> implements StackADT<T>{

    public T top() throws NoSuchElementException{
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.item;
    }
    
    @Override
    public void add(T item){
        push(item);
    }

    public void push(T item){
        Node<T> n = new Node<T>(item, first);
        first = n;
    }

    @Override
    public T remove(){
        return pop();
    }

    public T pop() throws NoSuchElementException{
        if(first == null){
            throw new NoSuchElementException();
        }
        T item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public void clear(){
        first = null;
    }

    @Override
    public boolean isEmpty(){
        return first == null;
    }
}
