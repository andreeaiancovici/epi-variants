package epi.arrays;

import java.util.*;

/*
Design a program that takes as input a size k,and reads packets, continuously
maintaining a uniform random subset of size k of the read packets.
Time Complexity: O(total numbers in stream)
Space Complexity: O(k)
 */
public class OnlineSampling {

    public static void main(String[] args) {
        onlineRandomSample(Arrays.asList(1,2,3,4,5,6,7,8,9).iterator(),5);
    }

    private static List<Integer> onlineRandomSample(Iterator<Integer> stream, int k) {
        List<Integer> result = new ArrayList<>(k);
        for(int i = 0; stream.hasNext() && i < k; i++) {
            result.add(stream.next());
        }
        int totalNumbers = k;
        Random random = new Random();
        while(stream.hasNext()) {
            Integer number = stream.next();
            totalNumbers++;
            int index = random.nextInt(totalNumbers);
            if(index < k) {
                result.set(index, number);
            }
        }
        return result;
    }
}
