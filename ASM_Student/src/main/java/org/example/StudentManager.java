package org.example;
import java.util.*;

public class StudentManager {
    private List<Student> students;
    private Map<String, Student> idIndex;
    private MaxHeap maxHeap;

    public StudentManager() {
        students = new ArrayList<>();
        idIndex = new HashMap<>();
        maxHeap = new MaxHeap();
    }

    // Add student
    public boolean addStudent(Student student) {
        if (idIndex.containsKey(student.getId())) {
            System.out.println("Error: Duplicate student ID " + student.getId());
            return false;
        }
        students.add(student);
        idIndex.put(student.getId(), student);
        maxHeap.insert(student);
        return true;
    }


    // Edit student (by id)
    public boolean editStudent(String id, String newName, Double newMark) {
        Student s = idIndex.get(id);
        if (s == null) return false;
        if (newName != null) s.setFullName(newName);
        if (newMark != null) s.setMark(newMark);
        // Rebuild heap if marks changed (simplest safe approach)
        rebuildHeap();
        return true;
    }

    public boolean deleteStudent(String id) {
        Student s = idIndex.remove(id);
        if (s == null) return false;
        students.remove(s);
        rebuildHeap();
        return true;
    }

    public Student searchById(String id) {
        Student result = idIndex.get(id);
        if (result == null) {
            System.out.println("No student found with ID: " + id);
        }
        return result;
    }


    public List<Student> searchByName(String q) {
        List<Student> result = new ArrayList<>();
        String lower = q.toLowerCase();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(lower)) result.add(s);
        }
        return result;
    }

    // Sort students by mark (descending)
    public void sortByMark(boolean descending) {
        MergeSortUtils.mergeSortByMark(students, descending);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<Student> topK(int k) {
        rebuildHeapIfNeeded();
        return maxHeap.topK(k);
    }

    private void rebuildHeap() {
        maxHeap.build(students);
    }

    private void rebuildHeapIfNeeded() {
        rebuildHeap();
    }

}
