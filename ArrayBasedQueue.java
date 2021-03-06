/**
 * Author: bbrighttaer
 * @param <E> Generic type
 */
public class ArrayBasedQueue<E> implements Queue<E> {
    private int size;
    private int head_index;
    private final E[] queue;

    public ArrayBasedQueue(int queue_size) {
        this.size = 0;
        this.head_index = 0;
        this.queue = (E[]) new Object[queue_size];
    }

    
    public void enqueue(E element) {
        int insertion_index = (head_index + size) % queue.length;
        this.queue[insertion_index] = element;
        size++;
    }

    
    public E dequeue() throws Exception {
        checkQueue();
        E out = queue[head_index];
        head_index = (head_index + 1) % queue.length;
        size--;
        return out;
    }

    private void checkQueue() throws Exception {
        if (isEmpty())
            throw new Exception("The queue is empty");
    }

    
    public E first() throws Exception {
        checkQueue();
        return queue[head_index];
    }

    
    public int getSize() {
        return size;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public String toString() {
        StringBuilder bldr = new StringBuilder();
        if (!isEmpty()) {
            for (int i = 0; i < queue.length; i++) {
                bldr.append(queue[i]);
                if (i + 1 != queue.length)
                    bldr.append(", ");
            }
        }
        return String.format("ArrayBasedQueue[%s]", bldr);
    }
}
