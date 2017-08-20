package HomeWork;


public class Main {

    public static void main(String[] args) {

//        System.out.println("\nOracle LinkedList:");
//        Queue<Integer> list1 = new LinkedList<>();
//        list1.add(0);
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(4);
//        System.out.println(list1.toString());


        System.out.println("\n------------------");
        MyQueue<Integer> list2 = new MyQueue<>();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.show();

        list2.remove();
        list2.show();

    }
}
