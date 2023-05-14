
public class MyHashtable<K, V> {
    private int size;
    private int capacity;
    private HashNode[] chain;

    public MyHashtable() {
        size = 0;
        capacity = 11;//def size
        chain = new HashNode[capacity];
    }

    public MyHashtable(int M) {
        this.capacity = M;
        this.chain = new HashNode[M];
    }

    private class HashNode<K, v> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


}