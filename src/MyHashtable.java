
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

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = chain[index];
        V temp = null;
        if (node != null && node.key.equals(key)) {
            temp = node.value;
            chain[index] = node.next;
            size--;
        } else {
            while (node != null && node.next != null) {
                if (node.next.key.equals(key)) {
                    temp = node.next.value;
                    node.next = node.next.next;
                    size--;
                    break;
                }
                node = node.next;
            }
        }
        return temp;
    }
    public boolean contains(V value){
        for(int i=0;i<capacity;i++){
            HashNode node=chain[i];
            while(node!=null){
                if(node.value.equals(value)){
                    return true;
                }
                node=node.next;
            }
        }return false;
    }
    public K getKey(V value){
        if(contains(value)){
            for(int i=0;i<capacity;i++){
                HashNode node=chain[i];
                while(node!=null){
                    if(node.value.equals(value)){
                        return (K) node.key;
                    }
                    node=node.next;
                }
            }
        }
        return null;
    }

}