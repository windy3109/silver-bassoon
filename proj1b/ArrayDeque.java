public class ArrayDeque<T> implements Deque<T> {

    private int size;
    private T[] items;
    public ArrayDeque() {

        size = 0;
        items = (T[]) new Object[8];

    }

    private void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }



    public void addFirst(T item){
        if (size == items.length) {
            resize(size * 2);
        }
        System.arraycopy(items, 0, items, 1, size);
        items[0] = item;
        size++;
    }

    public void addLast(T item){
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = item;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }else{
            T item = items[0];
            System.arraycopy(items, 1, items, 0, size - 1);
            size--;
            items[size] = null;

            if ((double)size /items.length < 0.25 && items.length >= 16) {
            resize((size / 4));
            }
            return item;
        }
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T item = items[size - 1];
        size = size - 1;
        items[size] = null;
        if ((double)size / items.length < 0.25 && items.length >= 16) {
            resize((size / 4));
        }
        return item;

    }
    public T get(int index){
        return items[index];
    }







}
