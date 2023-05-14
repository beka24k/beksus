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


}
