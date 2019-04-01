
/**
 * List Interface for the AP Subset
 */
public interface APList<T>
{
    int size();
    T get(int i);
    T set(int i, T x);
    T remove(int i);
    void add(T x);
    void add(int i, T x);
    void concatenate(APList<T> other);
}
