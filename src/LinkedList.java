import java.util.Objects;
public class LinkedList<T> {
 private static class Node<T>{T v;Node<T> next;Node(T v){this.v=v;}}
 private Node<T> head,tail;private int size;private long accesses,comparisons,movements;
 public int size(){return size;}
 public void add(T x){Node<T> n=new Node<>(x);if(head==null)head=tail=n;else{tail.next=n;tail=n;}size++;movements++;}
 public void add(int index,T x){checkAdd(index);if(index==size){add(x);return;}if(index==0){Node<T> n=new Node<>(x);n.next=head;head=n;size++;movements++;return;}Node<T> p=node(index-1);Node<T> n=new Node<>(x);n.next=p.next;p.next=n;size++;movements++;}
 public T remove(int index){check(index);T r;if(index==0){r=head.v;head=head.next;size--;if(size==0)tail=null;movements++;return r;}Node<T> p=node(index-1);r=p.next.v;if(p.next==tail)tail=p;p.next=p.next.next;size--;movements++;return r;}
 public T get(int index){check(index);return node(index).v;}
 public boolean contains(T x){Node<T> c=head;while(c!=null){comparisons++;accesses++;if(Objects.equals(c.v,x))return true;c=c.next;}return false;}
 private Node<T> node(int index){Node<T> c=head;for(int i=0;i<index;i++){c=c.next;accesses++;}accesses++;return c;}
 private void check(int i){if(i<0||i>=size)throw new IndexOutOfBoundsException();}private void checkAdd(int i){if(i<0||i>size)throw new IndexOutOfBoundsException();}
 public void resetMetrics(){accesses=comparisons=movements=0;}public long getAccesses(){return accesses;}public long getComparisons(){return comparisons;}public long getMovements(){return movements;}
}
