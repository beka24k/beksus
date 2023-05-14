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

}
