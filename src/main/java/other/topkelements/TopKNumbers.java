package other.topkelements;

import java.util.PriorityQueue;

public class TopKNumbers {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 12, 2, 11};
        int K = 3;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < K) {
                minHeap.add(num);
            } else {
                if (num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }

        System.out.println("Done");
    }
}
