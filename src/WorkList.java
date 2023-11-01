import java.util.NoSuchElementException;

public class WorkList<T>{
    protected Node<T> first = null;

    public T getFirst(){
        if (this.first == null){
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public void add(T item){}

    public T remove(){
        return null;
    }

    public boolean isEmpty(){
        return true;
    }

    public void clear(){}

    
    public int size(){
        int size = 0;
        Node<T> n = first;
        while(n != null){
            n = n.next;
            size++;
        }
        return size;
    }

    public boolean contains(T item){
        Node<T> n = first;
        while(n.next != null){
            if(n.item.equals(item)){
                return true;
            }
            n = n.next;
        }
        return false;
    }

    static class Node<T>{
        T item;
        Node<T> next;

        public Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }
}