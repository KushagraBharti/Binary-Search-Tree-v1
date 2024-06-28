//public interface MyList<E> extends Iterable<E> {
public interface MyList<E>{
    public void add(E e);
    public void add(int index, E e);
    public void clear(); //will clear the list
    public boolean contains(E e); //tell us if an element in in the list
    public E get(int index);
    public int indexOf(E e);
    public boolean isEmpty();
    public int lastIndexOf(E e);
    public boolean remove(E e);
    public E remove(int index);
    public int size();
}