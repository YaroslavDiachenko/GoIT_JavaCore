package HomeWork;


public class Main {
    public static void main(String[] args) {

        MyHashMap<String, String> list2 = new MyHashMap<>();
        list2.put("0", "Zero");
        list2.put("1", "One");
        list2.put("2", "Two");
        list2.put("3", "Three");
        list2.put("4", "Four");
        list2.put("111", "Five");
        list2.put("222", "Six");
        list2.put("77767", "Seven");
        list2.show();

        list2.put("222","New");
        list2.show();

        System.out.println(list2.get("111"));

        list2.clear();
        list2.show();

    }
}
