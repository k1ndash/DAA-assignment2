import java.util.Objects;

public class DynamicArray<T> {
    private Object[] data = new Object[10];
    private int size;
    private long accesses, comparisons, movements;
    public int size(){ return size; }
    public void add(T x){ ensure(size+1); data[size++]=x; movements++; }
    public void add(int index,T x){ checkAdd(index); ensure(size+1); for(int i=size;i>index;i--){data[i]=data[i-1]; movements++;} data[index]=x; movements++; size++; }
    public T remove(int index){ check(index); T old=getRaw(index); for(int i=index;i<size-1;i++){data[i]=data[i+1]; movements++;} data[--size]=null; movements++; return old; }
    public T get(int index){ check(index); accesses++; return getRaw(index); }
    public boolean contains(T x){ for(int i=0;i<size;i++){comparisons++; if(Objects.equals(data[i],x)) return true;} return false; }
    private void ensure(int need){ if(need<=data.length)return; Object[] n=new Object[Math.max(need,data.length*2)]; for(int i=0;i<size;i++){n[i]=data[i]; movements++;} data=n; }
    @SuppressWarnings("unchecked") private T getRaw(int i){ return (T)data[i]; }
    private void check(int i){if(i<0||i>=size)throw new IndexOutOfBoundsException();}
    private void checkAdd(int i){if(i<0||i>size)throw new IndexOutOfBoundsException();}
    public void resetMetrics(){accesses=comparisons=movements=0;}
    public long getAccesses(){return accesses;} public long getComparisons(){return comparisons;} public long getMovements(){return movements;}
}
