package Practice;


import java.util.*;
import java.util.concurrent.TimeUnit;

public class PerformanceChecker {

    public void checkAdding(int count) {
        long startTime;
        long endTime;

        ArrayList<Student> arrayList = new ArrayList<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            arrayList.add(new Student());
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList: " + (endTime - startTime));

        LinkedList<Student> linkedList = new LinkedList<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            linkedList.add(new Student());
        }
        endTime = System.currentTimeMillis();
        System.out.println("MyLinkedList: " + (endTime - startTime));

        TreeSet<Student> treeSet = new TreeSet<>();
        startTime = System.currentTimeMillis();
        treeSet.add(new Student());
        for (int i = 0; i < count; i++) {
            treeSet.add(new Student());
        }
        endTime = System.currentTimeMillis();
        System.out.println("TreeSet: " + (endTime - startTime));

        HashSet<Student> hashSet = new HashSet<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            hashSet.add(new Student());
        }
        endTime = System.currentTimeMillis();
        System.out.println("HashSet: " + (endTime - startTime));




    }

    public  void checkReading(int count) {


    }

    public void checkRemoving(int count) {

    }
}
