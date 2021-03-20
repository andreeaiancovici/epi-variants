package variants;

import java.util.Random;

//Page 85 Variant
//Time complexity O(n^2)
//Space complexity O(1)
public class NonuniformRandomNumberExpDist {
    //Use exponential distribution 2^x
    public static void main(String[] args) {
        double value = new Random().nextDouble();
        System.out.println(Math.log(value) / Math.log(2));
    }
}
