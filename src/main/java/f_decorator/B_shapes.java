package f_decorator;

interface Shape {
    String info(); // deliberately different from toString
}

class Circle implements Shape {
    private float radius;

    // We will have a few constructors

    Circle() {
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    // And the ability to resize
    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class Square implements Shape {
    private float side;

    public Square() {
    }

    public Square(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A square with side " + side;
    }
}

class ColoredShape implements Shape {
    // Which shape we want to decorate?
    private Shape shape;
    // The color we want to add
    private String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    // We will override the info method
    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShape implements Shape {
    // Which shape we want to decorate?
    private Shape shape;
    // The transparency we want to add
    private int transparency;

    public TransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    // We will override the info method
    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

class DynamicDecoratorDemo {

    public static void main(String[] args) {


        Square square = new  Square(20);
        System.out.println(square.info());
        // Let's add color

        ColoredShape blueSquare = new ColoredShape(square, "blue");
        System.out.println(blueSquare.info());

        Circle circle = new Circle(10);
        System.out.println(circle.info());

// Let's add transparency
        TransparentShape myCircle = new TransparentShape(circle, 50);
        System.out.println(myCircle.info());

        // We can stack them
        TransparentShape myHalfTransparentBlueCircle = new TransparentShape(blueSquare, 50);
        System.out.println(myHalfTransparentBlueCircle.info());

    }
}