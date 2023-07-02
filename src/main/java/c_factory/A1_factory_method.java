package c_factory;

class BetterPoint {
    private double x,y;

    private BetterPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static class Factory {
        public static BetterPoint newCartesianPoint(double x, double y) {
            return new BetterPoint(x, y);
        }

        public static BetterPoint newPolarPoint(double rho, double theta) {
            return new BetterPoint(rho*Math.cos(theta), rho*Math.sin(theta));
        }
    }


    public String toString() {
        return "x: " + x + " y: " + y;
    }
}

class FactoryDemo1 {
    public static void main(String[] args) {
        BetterPoint point0 = BetterPoint.Factory.newCartesianPoint(1, 2);
        BetterPoint point1 = BetterPoint.Factory.newPolarPoint(1, 2);
        System.out.println(point0);
        System.out.println(point1);
    }
}