package q64;

/**
 * Created by leibro on 2017/3/22.
 */
public class Solution {
    private MinHeap min = new MinHeap();
    private MaxHeap max = new MaxHeap();
    private int count = 0;
    public void Insert(Integer num) {
        count ++;
        if(count % 2 == 0) {
            if(min.size() > 0 && num > min.min()) {
                int a = min.delMin();
                min.push(num);
                max.push(a);
            } else {
                max.push(num);
            }
        }
        if(count % 2 == 1) {
            if(max.size() > 0 && num < max.max()) {
                int a = max.delMax();
                max.push(num);
                min.push(a);
            } else {
                min.push(num);
            }
        }
    }

    public Double GetMedian() {
        if(count % 2 == 1)
            return (double)min.min();
        else
            return (double)(min.min() + max.max()) / (double)2;
    }

    private static class MaxHeap {
        private int[] heap;
        private int size;
        private int capacity = 10;

        MaxHeap() {
            heap = new int[11];
            size = 0;
        }

        int max() {
            return heap[1];
        }

        int size() {
            return this.size;
        }

        int delMax() {
            swap(1,size --);
            int max = heap[size + 1];
            sink(1);
            return max;
        }

        void push(int i) {
            if(size < capacity) {
                heap[++ size] = i;
                swim(size);
            } else {
                delMax();
                push(i);
            }
        }

        private void sink(int k) {
            while(k * 2 < heap.length) {
                int j = k * 2;
                if(j + 1 < heap.length && heap[j + 1] > heap[j])
                    j = j + 1;
                if(heap[k] < heap[j])
                    swap(k,j);
                k = j;
            }
        }

        private void swim(int k) {
            while(k / 2 > 0) {
                if(heap[k] > heap[k / 2])
                    swap(k,k / 2);
                k = k / 2;
            }
        }

        private void swap(int i,int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    private static class MinHeap {
        private int[] heap;
        private int capacity = 10;
        private int size;

        MinHeap() {
            heap = new int[capacity + 1];
            size = 0;
        }

        int size() {
            return this.size;
        }

        int min() {
            return heap[1];
        }

        void push(int i) {
            if(size < capacity) {
                heap[++ size] = i;
                swim(size);
            } else {
                delMin();
                push(i);
            }
        }

        int delMin() {
            swap(1,size --);
            int min = heap[size + 1];
            sink(1);
            return min;
        }

        private void swim(int k) {
            while(k / 2 > 0) {
                if(heap[k] < heap[k / 2])
                    swap(k,k / 2);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while(k * 2 < heap.length) {
                int j = k * 2;
                if(j + 1 < heap.length && heap[j + 1] < heap[j])
                    j = j + 1;
                if(heap[k] < heap[j])
                    swap(k,j);
                k = j;
            }
        }


        private void swap(int i,int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Insert(5);
        System.out.println(solution.GetMedian());
        solution.Insert(2);
        System.out.println(solution.GetMedian());
        solution.Insert(3);
        System.out.println(solution.GetMedian());
        solution.Insert(4);
        System.out.println(solution.GetMedian());
        solution.Insert(1);
        System.out.println(solution.GetMedian());
        solution.Insert(6);
        System.out.println(solution.GetMedian());
        solution.Insert(7);
        System.out.println(solution.GetMedian());
        solution.Insert(0);
        System.out.println(solution.GetMedian());
        solution.Insert(8);
        System.out.println(solution.GetMedian());
    }
}
