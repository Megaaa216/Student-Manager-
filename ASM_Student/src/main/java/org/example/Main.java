package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentManager mgr = new StudentManager();

        mgr.addStudent(new Student("S001", "Alice Nguyen", 8.7));
        mgr.addStudent(new Student("S002", "Binh Tran", 6.2));
        mgr.addStudent(new Student("S003", "Chi Le", 9.3));
        mgr.addStudent(new Student("S004", "Duong Pham", 4.9));

        System.out.println("All students:");
        mgr.getStudents().forEach(System.out::println);

        System.out.println("\nSearch by ID S003:");
        System.out.println(mgr.searchById("S003"));

        System.out.println("\nSearch by name contains 'bin':");
        mgr.searchByName("bin").forEach(System.out::println);

        System.out.println("\nTop 2 students (by mark):");
        mgr.topK(2).forEach(System.out::println);

        System.out.println("\nSorted students descending:");
        mgr.sortByMark(true);
        mgr.getStudents().forEach(System.out::println);

        System.out.println("\nEditing S002 mark to 9.1:");
        mgr.editStudent("S002", null, 9.1);
        mgr.sortByMark(true);
        mgr.getStudents().forEach(System.out::println);

        System.out.println("\nDeleting S004:");
        mgr.deleteStudent("S004");
        mgr.getStudents().forEach(System.out::println);
    }
}