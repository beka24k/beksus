
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

    public int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = chain[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode newNode = new HashNode<>(key, value);
        newNode.next = chain[index];
        chain[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode node = chain[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }


}