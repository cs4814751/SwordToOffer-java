package q31;

import java.util.ArrayList;

/**
 * Created by leibro on 2017/3/16.
 */
public class Solution {
    private ArrayList<Integer> res = new ArrayList<>();
//Partition解法
/*    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input.length < k)
            return res;
        if(k <= 0)
            return res;
        int lo = 0,hi = input.length;
        int p = partition(input,lo,hi);
        while(true) {
            if(p + 1 == k) {
                saveResult(input,k);
                return res;
            } else if(p + 1 < k) {
                lo = p + 1;
                hi = hi;
                if(lo == hi - 1) {
                    p = lo;
                    continue;
                }
                p = partition(input,lo,hi);
            } else if(p + 1 > k) {
                lo = lo;
                hi = p + 1;
                if(lo == hi - 1) {
                    p = lo;
                    continue;
                }
                p = partition(input,lo,hi);
            }
        }
    }


    public int partition(int[] a,int lo,int hi) {
        int i = lo,j = hi;
        int v = a[lo];
        while(true) {
            while(a[++ i] < v)
                if(i == hi)
                    break;
            while(a[-- j] > v)
                if(j == lo)
                    break;
            if(i >= j)
                break;
            swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
    }

    private void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void saveResult(int[] a,int k) {
        for(int i = 0;i < k;i ++) {
            res.add(a[i]);
        }
    } */




//最大堆解法
    private static class MaxHeap {
        private int[] heap;
        private int capacity;
        private int size;

        MaxHeap(int k) {
            heap = new int[k + 1];
            capacity = k;
            size = 0;
        }

        private void swim(int k) {
            while (k / 2 > 0) {
                int parent = k / 2;
                if(heap[k] > heap[parent]) {
                    swap(k,parent);
                    k = parent;
                } else {
                    break;
                }
            }
        }

        private void sink(int k) {
            while(k * 2 < size) {
                int j = k * 2;
                if(j + 1 < size && heap[j] < heap[j + 1])
                    j ++;
                if(heap[k] < heap[j]) {
                    swap(k, j);
                    k = j;
                }
                else
                    break;
            }
        }

        private void push(int a) {
            if(size == capacity) {
                if(heap[1] > a) {
                    delMax();
                    push(a);
                } else {
                    return;
                }
            } else {
                heap[++ size] = a;
                swim(size);
            }
        }


        private int delMax() {
            int max = heap[1];
            swap(1,size --);
            sink(1);
            return max;
        }

        private void swap(int i,int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input.length < k || k <= 0)
            return res;
        MaxHeap heap = new MaxHeap(k);
        for(int i = 0;i < input.length;i ++) {
            heap.push(input[i]);
        }
        while(heap.size > 0)
            res.add(heap.delMax());
        return res;
    }




}
