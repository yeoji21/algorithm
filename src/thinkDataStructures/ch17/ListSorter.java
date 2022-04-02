package thinkDataStructures.ch17;

import java.util.*;

public class ListSorter<T> {

    public void insertionSort(List<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            T elementI = list.get(i);
            int j = i;
            for (; j > 0; j--) {
                T elementJ = list.get(j - 1);
                if(comparator.compare(elementI, elementJ) >= 0) break;
                list.set(j, elementJ);
            }
            list.set(j, elementI);
        }
    }

    public void mergeSortInPlace(List<T> list, Comparator<T> comparator) {
        List<T> sorted = mergeSort(list, comparator);
        list.clear();
        list.addAll(sorted);
    }

    public List<T> mergeSort(List<T> list, Comparator<T> comparator) {
        int size = list.size();
        if(size <= 1) return list;

        List<T> first = mergeSort(new LinkedList<>(list.subList(0, size / 2)), comparator);
        List<T> second = mergeSort(new LinkedList<>(list.subList(size / 2, size)), comparator);

        return merge(first, second, comparator);
    }

    private List<T> merge(List<T> first, List<T> second, Comparator<T> comparator) {
        List<T> result = new LinkedList<>();
        int total = first.size() + second.size();
        for (int i = 0; i < total; i++) {
            List<T> winner = pickWinner(first, second, comparator);
            result.add(winner.remove(0));
        }
        return result;
    }

    private List<T> pickWinner(List<T> first, List<T> second, Comparator<T> comparator) {
        if(first.size() == 0) return second;
        if(second.size() == 0) return first;
        int res = comparator.compare(first.get(0), second.get(0));
        if(res < 0) return first;
        if(res > 0) return second;
        return first;
    }

    public static void radixSort(int[] arr) {
        int maxD = getMaxD(arr);
        int n = arr.length;
        int bucketSize = 10;

        Queue<Integer>[] bucket = new LinkedList[bucketSize];
        for (int i = 0; i < bucketSize; i++) bucket[i] = new LinkedList<>();

        int factor = 1;
        for (int d = 0; d < maxD; d++) {
            for (int i = 0; i < n; i++)
                bucket[(arr[i] / factor) % 10].add(arr[i]);

            for (int i = 0, j = 0; i < bucketSize; i++) {
                while (!bucket[i].isEmpty())
                    arr[j++] = bucket[i].poll();
            }
            factor *= 10;
        }
    }

    private static int getMaxD(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int maxD = 0;
        for (int i = 1; max / i > 0; i *= 10, maxD++);
        return maxD;
    }

    public void heapSort(List<T> list, Comparator<T> comparator) {
        PriorityQueue<T> heap = new PriorityQueue<>(list.size(), comparator);
        heap.addAll(list);
        list.clear();
        while(!heap.isEmpty()) list.add(heap.poll());
    }

    public List<T> topK(int k, List<T> list, Comparator<T> comparator) {
        PriorityQueue<T> heap = new PriorityQueue<>(list.size(), comparator);
        list.forEach(element -> {
            if(heap.size() < k) heap.offer(element);
            else{
                if (comparator.compare(element, heap.peek()) > 0) {
                    heap.poll();
                    heap.offer(element);
                }
            }
        });
        ArrayList<T> result = new ArrayList<>();
        while(!heap.isEmpty()) result.add(heap.poll());
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer elt1, Integer elt2) {
                return elt1.compareTo(elt2);
            }
        };

        ListSorter<Integer> sorter = new ListSorter<Integer>();
        sorter.insertionSort(list, comparator);
        System.out.println(list);

        list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        sorter.mergeSortInPlace(list, comparator);
        System.out.println(list);

        int[] arr = {28, 93, 39, 81, 62, 72, 38, 26, 100};
        radixSort(arr);
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
        System.out.println();

        list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        sorter.heapSort(list, comparator);
        System.out.println(list);

        list = new ArrayList<Integer>(Arrays.asList(6, 3, 5, 8, 1, 4, 2, 7));
        List<Integer> queue = sorter.topK(4, list, comparator);
        System.out.println(queue);
    }
}
