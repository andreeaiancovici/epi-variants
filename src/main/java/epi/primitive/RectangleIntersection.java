package epi.primitive;

import static org.junit.Assert.assertEquals;

/*
Write a program which tests if two rectangles have a nonempty intersection. If the
intersection is nonempty, return the rectangle formed by their intersection.
Time Complexity: O(1)
Space Complexity: O(1)
 */
public class RectangleIntersection {

    public static void main(String[] args) {
        assertEquals(new Rectangle(44, 66, 49, 6), intersectRectangle(new Rectangle(44, 66, 84, 14), new Rectangle(8, 54, 85, 18)));
    }

    private static Rectangle intersectRectangle(Rectangle R1, Rectangle R2) {
        Rectangle rectangle = new Rectangle(0, 0, -1, -1);

        if(R1.x + R1.width < R2.x || R2.x + R2.width < R1.x || R1.y + R1.height < R2.y || R2.y + R2.height < R1.y) {
            return rectangle;
        }

        if(R2.x < R1.x + R1.width || R1.x < R2.x + R2.width) {
            rectangle.x = Math.max(R1.x, R2.x);
            rectangle.width = Math.min(R1.x + R1.width, R2.x + R2.width) - rectangle.x;
        }

        if(R2.y < R1.y + R1.height || R1.y < R2.y + R2.height) {
            rectangle.y = Math.max(R1.y, R2.y);
            rectangle.height = Math.min(R1.y + R1.height, R2.y + R2.height) - rectangle.y;
        }

        return rectangle;
    }

    public static class Rectangle {
        int x, y, width, height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Rectangle rectangle = (Rectangle)o;

            if (x != rectangle.x) {
                return false;
            }
            if (y != rectangle.y) {
                return false;
            }
            if (width != rectangle.width) {
                return false;
            }
            return height == rectangle.height;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + width;
            result = 31 * result + height;
            return result;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + ", " + width + ", " + height + "]";
        }
    }
}
