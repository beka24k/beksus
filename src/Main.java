public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyHashtable aa=new MyHashtable();
        MyTestingClass asd=new MyTestingClass(null,null);
        aa.put(45,"sdf");
        aa.put(451,"asf");
        aa.put(454,"zxcv");
        aa.put(475,"asdf");
        aa.put(455,"zxcv");
        aa.put(435,"asdf");
        aa.put(485,"qwer");
        aa.remove(45,"s","sfsdfg");
        System.out.println(aa.get(45));

        }
}