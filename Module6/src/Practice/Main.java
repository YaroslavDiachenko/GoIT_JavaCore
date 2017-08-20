package Practice;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    static void printStudents(ArrayList<Student> students, int course) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getCourse() == course)
                System.out.print(s.getName() + " ");
        }
    }

    static HashSet<Student> union(HashSet<Student> set1, HashSet<Student> set2) {
        set1.addAll(set2);
        return set1;
    }

    static HashSet<Student> intersect(HashSet<Student> set1, HashSet<Student> set2) {
        HashSet<Student> set3 = new HashSet<>();
        for (Student i : set1) {
            for (Student j : set2) {
                if (i.equals(j)) set3.add(i);
            }
        }
        return set3;
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Bob", 1));
        students.add(new Student("Daniel", 1));
        students.add(new Student("Lucas", 2));
        students.add(new Student("David", 2));
        students.add(new Student("John", 3));
        students.add(new Student("Luke", 3));

//        printStudents(students,3);

        HashSet<Student> students1 = new HashSet<>();
        students1.add(new Student("Bob", 1));
        students1.add(new Student("James", 1));
        students1.add(new Student("Oliver", 1));
        students1.add(new Student("Daniel", 1));
        students1.add(new Student("Joseph", 1));

        HashSet<Student> students2 = new HashSet<>();
        students2.add(new Student("Bob", 1));
        students2.add(new Student("Oliver", 1));
        students2.add(new Student("Joseph", 1));

//        // union:
//        for(Student i : students1) {
//            System.out.print(i.getName() + " ");
//        }
//        System.out.println("");
//
//        union(students1,students2);
//
//        for(Student i : students1) {
//            System.out.print(i.getName() + " ");
//        }

        // intersect:
//        HashSet<Student> students4 = intersect(students1,students2);
//        for(Student i : students4) {
//            System.out.print(i.getName() + " ");
//        }

        PerformanceChecker performanceChecker = new PerformanceChecker();
        performanceChecker.checkAdding(100000);



    }
}
