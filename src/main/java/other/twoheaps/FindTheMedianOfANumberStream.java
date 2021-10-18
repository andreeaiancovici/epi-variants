package other.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTheMedianOfANumberStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    void insertNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else return maxHeap.peek();
    }

    public static void main(String[] args) {
        FindTheMedianOfANumberStream stream = new FindTheMedianOfANumberStream();
        stream.insertNum(3);
        stream.insertNum(1);
        stream.insertNum(5);
        stream.insertNum(4);
        System.out.println(stream.findMedian());
    }
}
