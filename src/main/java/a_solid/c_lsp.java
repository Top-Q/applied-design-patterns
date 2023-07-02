package a_solid;

// LSP - (Liskov Substitution Principle) - if S is a subtype of T,
// then objects of type T may be replaced with objects of type S
// objects of a superclass should be replaceable with objects of its subclasses without breaking the application

// Let's see how we can violate this principle and how we can fix it.


class Rectangle {
    protected int width, height;

    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }

    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public boolean isSquare() {
        return width == height;
    }

}

class Square extends Rectangle {

    public Square() {
    }

    public Square(int size) {
        width = height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

}

/**
 * To fix it, we can create a factory class. Maybe we don't need Square class at all.
 */
class RectangleFactory {

        public static Rectangle newRectangle(int width, int height) {
            return new Rectangle(width, height);
        }

        public static Rectangle newSquare(int size) {
            return new Rectangle(size, size);
        }
}

class LSPDemo {

    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println(
                "Expected area of " + (width * 10) +
                        ", got " + r.getArea()
        );
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        useIt(rc);

        Rectangle sq = new Square();
        sq.setWidth(5);
        sq.setHeight(2);
        useIt(sq);

        Rectangle newSq = RectangleFactory.newSquare(5);
        System.out.println("newSq is a square: " + newSq.isSquare());
        newSq.setWidth(2);
        System.out.println("newSq is a square: " + newSq.isSquare());



    }


}