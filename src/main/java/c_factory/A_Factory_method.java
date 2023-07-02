package c_factory;

class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Now let's say that we want to be able to create a point in polar coordinates also.
//    public Point(double rho, double theta) {
//        x = rho * Math.cos(theta);
//        y = rho * Math.sin(theta);
//    }


    /**
     * DON'T DO THIS!
     * This is a BAD BAD example
     * @param a x if cartesian, rho if polar
     * @param b y if cartesian, theta if polar
     * @param cs
     */
    public Point(double a, double b, CoordinateSystem cs) {
        switch (cs) {
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                this.x = a * Math.cos(b);
                this.y = a * Math.sin(b);
                break;
        }

        // The constructor is now very confusing. We will probably need a lot of documentation to explain it.
        // This is very bad.
        // The name of the constructor has to be the name of the class so we can't use it to tell a story.
    }


}

enum CoordinateSystem {
    CARTESIAN,
    POLAR
}

