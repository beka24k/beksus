/**
 * MyHashtable is an implementation of a hash table data structure.
 * It uses chaining to handle collisions and supports insertion,
 * retrieval, removal, and several other operations.
 *
 * @param <K> the key type for the hash table
 * @param <V> the value type for the hash table
 */
public class MyHashtable<K, V> {
    private int size;
    private int capacity;
    private HashNode[] chain;

    /**
     * Constructs a new MyHashtable object with a default capacity of 11.
     */
    public MyHashtable() {
        size = 0;
        capacity = 11;//def size
        chain = new HashNode[capacity];
    }

    /**
     * Constructs a new MyHashtable object with a specified capacity.
     *
     * @param M the initial capacity of the hash table
     */
    public MyHashtable(int M) {
        this.capacity = M;
        this.chain = new HashNode[M];
    }

    /**
     * HashNode is an inner class used to store key-value pairs
     * and a reference to the next node in the chain.
     */
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        /**
         * Constructs a new HashNode object with the given key and value.
         *
         * @param key   the key for the node
         * @param value the value for the node
         */
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Returns a hash code for the given key.
     * This implementation simply returns the key's own hash code.
     *
     * @param key the key to hash
     * @return the hash code for the key
     */
    public int hash(K key) {
        MyTestingClass hasher = new MyTestingClass(key, null);
        return Math.abs(hasher.hashCode() % capacity);
    }

    /**
     * Returns the number of elements in the hash table.
     *
     * @return the number of elements in the hash table
     */
    public int size() {
        return size;
    }

    /**
     * Inserts a key-value pair into the hash table.
     * If the key already exists in the table, its value is updated.
     *
     * @param key   the key for the new node
     * @param value the value for the new node
     */
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

    /**
     * Retrieves the value associated with the given key.
     * Returns null if the key is not found in the table.
     *
     * @param key the key to retrieve
     * @return the value associated with the key, or null if the key is not found
     */
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

    /**
     * Removes the key-value pair with the given key from the hash table.
     *
     * @param key the key to remove
     * @return the value associated with the removed key, or null if the key was not found
     */

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

    /**
     * Checks whether the hash table contains a key-value pair with the given value.
     *
     * @param value the value to search for
     * @return true if a key-value pair with the given value was found, false otherwise
     */
    public boolean contains(V value) {
        for (int i = 0; i < capacity; i++) {
            HashNode node = chain[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    /**
     * Gets the key associated with the given value in the hash table.
     *
     * @param value the value to search for
     * @return the key associated with the given value, or null if the value was not found
     */
    public K getKey(V value) {
        if (contains(value)) {
            for (int i = 0; i < capacity; i++) {
                HashNode node = chain[i];
                while (node != null) {
                    if (node.value.equals(value)) {
                        return (K) node.key;
                    }
                    node = node.next;
                }
            }
        }
        return null;
    }

    /**
     * Prints the number of elements in each bucket of the hash table.
     */
    public void counter() {
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            HashNode node = chain[i];
            while (node != null) {
                count++;
                node = node.next;
            }
            System.out.println(i + " bucket " + count + " elements");
            count = 0;
        }


    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        HashNode node = chain[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public V[] values() {
        int counter = size - 1;
        V[] array = (V[]) new Object[size];
        for (int i = 0; i < capacity; i++) {
            HashNode node = chain[i];
            while (node != null) {
                array[counter] = (V) node.value;
                counter--;
                node = node.next;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        return array;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            HashNode<K, V> node = chain[i];
            chain[i] = null; // Remove the reference to the first node in the bucket
            while (node != null) {
                HashNode<K, V> nextNode = node.next;
                node.next = null; // Remove the reference to the next node
                node = nextNode; // Move to the next node
            }
        }
        size = 0;
    }

    public void rehash(int newCapacity) {
        int temp = capacity;
        HashNode[] newChain = new HashNode[newCapacity];
        capacity = newCapacity;
        for (int i = 0; i < temp; i++) {
            HashNode node = chain[i];
            while (node != null) {
                int newIndex = hash((K) node.key);
                node.next = newChain[newIndex];
                newChain[newIndex] = node;
                node = node.next;
            }
        }
        chain = newChain;
    }

    //defense
    public void remove(K key, V oldvalue, V newValue) {
        int index = hash(key);
        HashNode node = chain[index];
        while (node != null) {
            if (node.value.equals(oldvalue)) {
                node.value = newValue;
                break;
            }
            if (!node.value.equals(oldvalue)) {
                System.err.println("it is not value of this hashtable");
                break;
            }
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append("Bucket ").append(i).append(": ");
            HashNode<K, V> node = chain[i];
            while (node != null) {
                sb.append("(").append(node.key).append(", ").append(node.value).append(") ");
                node = node.next;
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
