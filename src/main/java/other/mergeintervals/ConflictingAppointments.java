package other.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

/*Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.*/
//Time: O(n*log(n))
//Space: O(1)
public class ConflictingAppointments {
    public static void main(String[] args) {
        int[][] appointments = {{6,7}, {2,4}, {8,12}};
        Arrays.sort(appointments, Comparator.comparingInt(o -> o[0]));
        boolean canAttend = true;
        for(int i = 1; i < appointments.length; i++){
            if(appointments[i - 1][1] >= appointments[i][0]) {
                canAttend = false;
                break;
            }
        }
        System.out.printf("A person can attend all appointments is '%s'.", canAttend);
    }
}