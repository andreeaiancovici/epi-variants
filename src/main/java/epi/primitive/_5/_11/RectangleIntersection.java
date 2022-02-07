package epi.primitive._5._11;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Write a program which tests if two rectangles have a nonempty intersection.
 * If the intersection is nonempty, return the rectangle formed by their intersection.
 * ---
 * Solution:
 * We have 4 cases for relative positions between 2 rectangles:
 * <p>
 * x1     x2 x1`     x1`
 * ┌───────┐ ┌───────┐
 * │   R1  │ │   R2  │
 * │       │ │       │
 * └───────┘ │       │
 * └───────┘
 * x1`         x1`
 * ┌───────────┐
 * x1    │  x2       │
 * ┌─────┼──┐        │
 * │   R1│  │  R2    │
 * └─────┼──┘        │
 * │           │
 * └───────────┘
 * <p>
 * <p>
 * x1`          x2`
 * ┌─────────────┐
 * │  x1     x2  │
 * │  ┌───────┐  │
 * │  │   R1  │  │
 * │  │       │  │
 * │  └───────┘  │
 * │      R2     │
 * └─────────────┘
 * <p>
 * x1`      x2`
 * ┌─────────┐
 * │    x1   │     x2
 * │    ┌────┼──────┐
 * │ R2 │    │      │
 * │    │    │ R1   │
 * │    └────┼──────┘
 * │         │
 * └─────────┘
 * x1`       x2`
 * ┌──────────┐ ┌─────────┐
 * │          │ │         │
 * │    R2    │ │    R1   │
 * │          │ │         │
 * └──────────┘ └─────────┘
 * x1       x2
 * ---
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class RectangleIntersection {

    public static void main(String[] args) {
        assertEquals(new Rectangle(44, 66, 49, 6), intersectRectangle(new Rectangle(44, 66, 84, 14), new Rectangle(8, 54, 85, 18)));
    }

    private static Rectangle intersectRectangle(Rectangle R1, Rectangle R2) {
        // Use the above drawings as guidelines
        Rectangle rectangle = new Rectangle(0, 0, -1, -1);

        // First we tackle the corner cases where there is no intersection (first and last drawing)
        // We compare the last edge (let's say A) (for both x and y axes) from R1 / R2 with the first edge from R2 / R1 (let's say B)
        // If any A < B then there is no intersection
        if (R1.x + R1.width < R2.x || R2.x + R2.width < R1.x || R1.y + R1.height < R2.y || R2.y + R2.height < R1.y) {
            return rectangle;
        }

        // We only have left the 3 middle cases
        // Check x axis lines, by comparing first edge of R1 / R2 with second edge of R2 / R1
        // As we can see from the drawings, the intersection occurs when:
        // - x1` < x2
        // - x1 < x2`
        if (R2.x < R1.x + R1.width || R1.x < R2.x + R2.width) {
            // Compute intersection x axis points
            rectangle.x = Math.max(R1.x, R2.x);
            rectangle.width = Math.min(R1.x + R1.width, R2.x + R2.width) - rectangle.x;
        }

        // Repeat the above step for y axis
        if (R2.y < R1.y + R1.height || R1.y < R2.y + R2.height) {
            // Compute intersection y axis points
            rectangle.y = Math.max(R1.y, R2.y);
            rectangle.height = Math.min(R1.y + R1.height, R2.y + R2.height) - rectangle.y;
        }

        return rectangle;
    }
}
