/**
 * Dynamic array implementation -- works like ArrayList.
 */
public class APArrayList<T> implements APList<T>
{
    private Object[] list;
    private int size;
    
    public APArrayList() {
        list = new Object[10];
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public T get(int i) {
        return (T) list[i];
    }
    
    public T set(int i, T x) {
        T y = (T) list[i];
        list[i] = x;
        return y;
    }
    
    public T remove(int i) {
        T x = (T) list[i];
        for(int k = i; k < size - 1; k++) {
            list[k] = list[k + 1];
        }
        size--;
        return x;
    }
    
    public void add(T x) {
        this.add(size, x);
    }
    
    public void add(int i, T x) {
        if(size == list.length) {
            resize();
        }
        for(int k = size; k > i; k--) {
            list[k] = list[k - 1];
        }
        list[i] = x;
        size++;
    }
    
    public void concatenate(APList<T> other) {
        for(int i = 0; i < other.size(); i++) {
            this.add(other.get(i));
        }
    }
    
    public String toString() {
        String ans = "[";
        for(int i = 0; i < size; i++) {
            ans += list[i] + ", ";
        }
        ans = ans.substring(0, ans.length() - 2);
        ans += "]";
        return ans;
    }
    
    private void resize() {
        Object[] oldList = list;
        list = new Object[list.length + 5];
        for(int k = 0; k < size; k++) {
            list[k] = oldList[k];
        }
    }
}
