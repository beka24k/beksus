import java.util.Random;

/**
 * A class for testing purposes that generates random IDs and names for testing hash table functionality.
 *
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
public class MyTestingClass<K, V> {
    private Random random;
    private K id;
    private V name;

    /**
     * Constructor for MyTestingClass.
     *
     * @param id   The ID of the object.
     * @param name The name of the object.
     */
    public MyTestingClass(K id, V name) {
        this.id = id;
        this.name = name;
        this.random = new Random();
    }

    /**
     * Hashcode making own hash for hashtable
     * @return integer value hash
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    /**
     * Generates 10000 random elements and adds them to a hash table.
     */
    public void tenThousandtest() {
        MyHashtable<K, V> pipi = new MyHashtable<>();
        for (int i = 0; i < 10000; i++) {
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            MyTestingClass key = new MyTestingClass(x, y + "Student");
            pipi.put((K) key.id, (V) key.name);
        }

        // print number of elements in each bucket
        pipi.counter();

    }

    /**
     * Tests all methods in the MyHashtable
     **/
    public void tester() {
        MyHashtable pipi = new MyHashtable();
        pipi.put(45, "fdngdgn");
        pipi.put(5, "sdfgnf");
        pipi.put(4, "fngdfgn");
        pipi.put(42, "hfgh");
        pipi.put(23, "dsfgs");
        pipi.put(42, "dfgds");
        pipi.put(124, "dsfg");
        System.out.println(pipi.getKey("hfgh"));
        System.out.println(pipi.get(4));
        System.out.println(pipi.contains("dsfg"));
        System.out.println(pipi.remove(5));
        System.out.println(pipi.get(5));
    }
}