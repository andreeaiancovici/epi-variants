package epi.primitive._5._11.variant;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Question:
 * Given four points in the plane, how would you check if they are the vertices of a rectangle?
 * ---
 * Memo:
 * The formula for the distance, D, between two points whose coordinates are (x1,y1) and (x2,y2) is:
 * D = sqrt([(x2− x1)^2 + (y2 − y1)^2])
 * Pythagorean Theorem
 * a^2 = b^2 + c^2, where a, b and c make a right angle triangle.
 * ---
 * Solution:
 * We can check if 4 points form a rectangle in 2 steps:
 * - compute the unique distances between each 2 points (we should end with 3 unique distances);
 * - apply Pythagorean Theorem between the 3 unique distances.
 * ---
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class FourPointsFormRectangle {

    public static void main(String[] args) {
        assertTrue(isRectangle(Arrays.asList(new Point(4, 3), new Point(8, 9), new Point(4, 9), new Point(8, 3))));
        assertTrue(isRectangle(Arrays.asList(new Point(2, 4), new Point(4, 2), new Point(7, 5), new Point(5, 7))));
        assertFalse(isRectangle(Arrays.asList(new Point(7, 3), new Point(10, 2), new Point(10, 0), new Point(7, 0))));
    }

    private static boolean isRectangle(List<Point> points) {
        // Keep distances sorted
        Set<Integer> uniqueDistances = new TreeSet<>();

        // Compute distances between each 2 points
        for(int i = 0; i < points.size() - 1; i++) {
            for(int j = i + 1; j < points.size(); j++) {
                uniqueDistances.add(distance(points.get(i), points.get(j)));
            }
        }

        //If we have more than 3 distances (rectangle length, width and diagonal), the points don't form a rectangle
        if(uniqueDistances.size() > 3) {
            return false;
        }

        List<Integer> uniqueDistancesList = new ArrayList<>(uniqueDistances);
        // Because we used a tree set to keep distances sorted
        // We can apply Pythagorean Theorem between the first 2 points and the last one
        return uniqueDistancesList.get(0) + uniqueDistancesList.get(1) == uniqueDistancesList.get(2);
    }

    private static int distance(Point a, Point b) {
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
