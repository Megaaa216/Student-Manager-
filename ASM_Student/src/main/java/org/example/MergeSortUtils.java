package org.example;
import java.util.*;

public class MergeSortUtils {
    public static void mergeSortByMark(List<Student> list, boolean descending) {
        if (list == null || list.size() <= 1) return;
        List<Student> aux = new ArrayList<>(list);
        mergeSort(list, aux, 0, list.size() - 1, descending);
    }

    private static void mergeSort(List<Student> a, List<Student> aux, int lo, int hi, boolean desc) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, aux, lo, mid, desc);
        mergeSort(a, aux, mid + 1, hi, desc);
        merge(a, aux, lo, mid, hi, desc);
    }

    private static void merge(List<Student> a, List<Student> aux, int lo, int mid, int hi, boolean desc) {
        for (int i = lo; i <= hi; i++) aux.set(i, a.get(i));
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            boolean takeLeft = desc
                    ? aux.get(i).getMark() >= aux.get(j).getMark()
                    : aux.get(i).getMark() <= aux.get(j).getMark();
            if (takeLeft) a.set(k++, aux.get(i++));
            else a.set(k++, aux.get(j++));
        }
        while (i <= mid) a.set(k++, aux.get(i++));
    }
}
