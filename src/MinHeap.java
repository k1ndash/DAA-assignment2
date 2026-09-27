public class MinHeap<T extends Comparable<T>>{
    private Object[] a=new Object[10];private int size;private long comparisons;
    public int size(){return size;} public void insert(T x){ensure();a[size]=x;int i=size++;while(i>0){int p=(i-1)/2;comparisons++;if(val(p).compareTo(val(i))<=0)break;swap(p,i);i=p;}}
    public T peekMin(){if(size==0)throw new IllegalStateException();return val(0);} public T extractMin(){if(size==0)throw new IllegalStateException();T r=val(0);a[0]=a[--size];a[size]=null;int i=0;while(true){int l=2*i+1,rn=l+1,s=i;if(l<size){comparisons++;if(val(l).compareTo(val(s))<0)s=l;}if(rn<size){comparisons++;if(val(rn).compareTo(val(s))<0)s=rn;}if(s==i)break;swap(i,s);i=s;}return r;}
    public boolean isValidHeap(){for(int i=1;i<size;i++)if(val((i-1)/2).compareTo(val(i))>0)return false;return true;} private void ensure(){if(size<a.length)return;Object[] n=new Object[a.length*2];System.arraycopy(a,0,n,0,size);a=n;}@SuppressWarnings("unchecked")private T val(int i){return(T)a[i];}private void swap(int i,int j){Object t=a[i];a[i]=a[j];a[j]=t;}public long getComparisons(){return comparisons;}public void resetMetrics(){comparisons=0;}
}
