
/**
 * Implements a Linked List
 */
public class APLinkedList<T> implements APList<T>
{
    private int size;
    public Link<T> first;
    public Link<T> last;
    
    public APLinkedList() {
        size = 0;
        first = null;
    }
    
    public int size() {
        return size;
    }
    
    public T get(int i) {
        Link<T> link = this.first;
        for(int k = 0; k < i; k++) {
            link = link.next;
        }
        return link.data;
    }
    
    public T set(int i, T x) {
        Link <T> link = this.first;
        for(int k = 0; k < i; k++) {
            link = link.next;
        }
        T oldData = link.data;
        link.data = x;
        return oldData;
    }
    
    public T remove(int i) {
        if(i == 0) {
            Link<T> toRemove = first;
            first = first.next;
            size--;
            return toRemove.data;
        }
        else {
            Link<T> link = first;
            for(int k = 0; k < i - 1; k++) {
                link = link.next;
            }
            Link<T> toRemove = link.next;
            link.next = link.next.next;
            if(i == size) {
                this.last = link.next;
            }
            size--;
            return toRemove.data;
        }
    }
    
    public void add(T x) {
        Link<T> newLink = new Link<T>(x);
        if(this.first == null) {
            this.first = newLink;
            this.last = newLink;
        }
        else {
            this.last.next = newLink;
            this.last = newLink;
        }
        size++;
    }
    
    public void add(int i, T x) {
        if(i == 0) {
            Link<T> oldFirst = this.first;
            this.first = new Link(x);
            this.first.next = oldFirst;
        }
        else {
            Link<T> link = this.first;
            for(int k = 0; k < i - 1; k++) {
                link = link.next;
            }
            Link toMove = link.next;
            link.next = new Link<T>(x);
            link.next.next = toMove;
            
            if(i == size) {
                this.last = link.next;
            }
        }
        size++;
    }
    
    public String toString() {
        String ans = "[";
        Link<T> link = this.first;
        for(int i = 0; i < size; i++) {
            ans += link.data.toString() + ", ";
            link = link.next;
        }
        ans = ans.substring(0, ans.length() - 2);
        ans += "]";
        return ans;
    }
    
    public void concatenate(APList<T> other) {
        if(other instanceof APLinkedList) {
            this.last.next = ((APLinkedList) other).first;
            this.last = ((APLinkedList) other).last;
        }
        else {
            for(int i = 0; i < other.size(); i++) {
                this.add(other.get(i));
            }
        }
    }
    
    /**
    * A private Link class
    */
    private class Link<T>
    {
        public T data;
        public Link<T> next;
    
        public Link(T x) {
            data = x;
        }
    }
}
