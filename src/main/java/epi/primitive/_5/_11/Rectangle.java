package epi.primitive._5._11;

public class Rectangle {
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

        Rectangle rectangle = (Rectangle) o;

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
