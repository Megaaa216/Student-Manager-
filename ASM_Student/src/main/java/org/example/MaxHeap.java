package org.example;
import java.util.*;

public class MaxHeap {
    private final List<Student> heap;

    public List<Student> topK(int k) {
        List<Student> tmp = new ArrayList<>(heap);
        MaxHeap copy = new MaxHeap();
        copy.build(tmp);
        List<Student> top = new ArrayList<>();
        for (int i = 0; i < k && copy.size() > 0; i++) top.add(copy.extractMax());
        return top;
    }

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public void build(List<Student> students) {
        heap.clear();
        heap.addAll(students);
        for (int i = parent(heap.size() - 1); i >= 0; i--) siftDown(i);
    }

    public void insert(Student s) {
        heap.add(s);
        siftUp(heap.size() - 1);
    }

    public Student extractMax() {
        if (heap.isEmpty()) return null;
        Student max = heap.get(0);
        Student last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return max;
    }

    public Student peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    public int size() { return heap.size(); }

    private void siftUp(int idx) {
        while (idx > 0) {
            int p = parent(idx);
            if (heap.get(p).getMark() >= heap.get(idx).getMark()) break;
            swap(idx, p);
            idx = p;
        }
    }

    private void siftDown(int idx) {
        int n = heap.size();
        while (true) {
            int l = left(idx), r = right(idx);
            int largest = idx;
            if (l < n && heap.get(l).getMark() > heap.get(largest).getMark()) largest = l;
            if (r < n && heap.get(r).getMark() > heap.get(largest).getMark()) largest = r;
            if (largest == idx) break;
            swap(idx, largest);
            idx = largest;
        }
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }
    private void swap(int i, int j) {
        Student t = heap.get(i); heap.set(i, heap.get(j)); heap.set(j, t);
    }

}
