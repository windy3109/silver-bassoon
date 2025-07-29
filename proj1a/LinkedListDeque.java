public class LinkedListDeque<T> {
    public class Intnode{
        public T item ;
        public Intnode next;
        public Intnode prev;

        public Intnode(T i , Intnode p , Intnode n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private int  size ;
    private Intnode senfront ;
    private Intnode senback ;
    public LinkedListDeque () {
        size = 0;
        senfront = new Intnode(null,null,null);
        senback = new Intnode(null,null,null);
        senfront.next = senback;
        senback.prev = senfront;
    }

    public void addFirst(T item){
        senfront.next.prev  = new Intnode(item, senfront, senfront.next);
        senfront.next = senfront.next.prev;
        size += 1;
    }
    public void addLast(T item){
        senback.prev.next = new Intnode(item, senback.prev, senback);
        senback.prev = senback.prev.next;
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
    public void printDeque(){
        Intnode curr = senfront.next;
        if (curr == senback){
            System.out.println("Deque is empty");
        }
        while(curr != senback){
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
    }

    public T removeFirst(){

        if (isEmpty()){
            return null;
        }else{
            T temp = (T) senfront.next.item;
            senfront.next.next.prev = senfront;
            senfront.next = senfront.next.next;
            size -= 1;
            return temp;
        }
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }else{
            T temp = (T) senback.prev.item;
            senback.prev.prev.next = senback;
            senback.prev = senback.prev.prev;
            size -= 1;
            return temp;

        }
    }

    public T get(int index){
        if (index < 0 || index >= size){
            return null;
        }
        Intnode curr = senfront;
        for (; index == 0; index--){
            curr = curr.next;
        }
        return (T) curr.item;
    }

    public T set(int index ,Intnode p){
        if (index == 0){
            return (T) p.item;
        }else return (T) set(index-1,p.next);

    }

    public T getRecursive(int index){
        if (index < 0 || index >= size){
            return null;
        }
        return set(index,senfront.next);

    }








}
