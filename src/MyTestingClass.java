import java.util.Random;

public class MyTestingClass<K, V> {
    private Random random;
    private K id;
    private V name;

    public MyTestingClass(K id, V name) {
        this.id = id;
        this.name = name;
        this.random = new Random();
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public void tenThousandtest() {
        MyHashtable<K, V> pipi = new MyHashtable<>();
        for (int i = 0; i < 10000; i++) {
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            Temp key=new Temp(x,"Student"+y);
            pipi.put((K) key.name, (V) key.id);
        }

        pipi.counter();

    }
    public void tester(){
        MyHashtable<Integer, String> pipi = new MyHashtable<>();
        pipi.put(45,"fdngdgn");
        pipi.put(5,"sdfgnf");
        pipi.put(4,"fngdfgn");
        pipi.put(42,"hfgh");
        pipi.put(23,"dsfgs");
        pipi.put(42,"dfgds");
        pipi.put(124,"dsfg");
        System.out.println(pipi.getKey("hfgh"));
        System.out.println(pipi.get(4));
        System.out.println(pipi.contains("dsfg"));
        System.out.println(pipi.remove(5));
        System.out.println(pipi.get(5));
    }



}
