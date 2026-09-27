public class Tests{
 public static void main(String[]args){
  DynamicArray<Integer>a=new DynamicArray<>(); assert a.size()==0; a.add(1);a.add(1);a.add(1,2);assert a.get(1)==2;assert a.contains(1);assert a.remove(1)==2;try{a.get(9);assert false;}catch(IndexOutOfBoundsException e){}
  LinkedList<Integer>l=new LinkedList<>();assert l.size()==0;l.add(1);l.add(1);l.add(1,2);assert l.get(1)==2;assert l.contains(1);assert l.remove(0)==1;try{l.remove(-1);assert false;}catch(IndexOutOfBoundsException e){}
  MinHeap<Integer>h=new MinHeap<>();int[]v={5,2,8,2,1,9,3};for(int x:v){h.insert(x);assert h.isValidHeap();}int last=Integer.MIN_VALUE;while(h.size()>0){int x=h.extractMin();assert x>=last;last=x;assert h.isValidHeap();}
  DynamicArray<Integer>big=new DynamicArray<>();for(int i=0;i<100000;i++)big.add(i);assert big.get(99999)==99999;
  System.out.println("All tests passed.");
 }
}
