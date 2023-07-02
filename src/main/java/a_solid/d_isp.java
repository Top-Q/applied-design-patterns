package a_solid;

// ISP - Interface Segregation Principle

// This is basically a recommendation to create small interfaces by splitting large interfaces into smaller ones.

class Document {

}

interface Machine {

    void print(Document d);
    void fax(Document d) throws Exception;
    void scan(Document d) throws Exception;
}
// Everything is good when we want to implment multifunction printer
class MultiFunctionPrinter implements Machine {

    public void print(Document d) {
        //
    }

    public void fax(Document d) {
        //
    }

    public void scan(Document d) {
        //
    }
}
// YAGNO - You Ain't Gonna Need It
class OldFashionedPrinter implements Machine {

    public void print(Document d) {
        // yep
    }

    public void fax(Document d) throws Exception {
        throw new Exception("Not Implemented");
    }

    public void scan(Document d) throws Exception {
        throw new Exception("Not Implemented");
    }
}

interface Printer {

    void print(Document d);
}

interface Scanner {

    void scan(Document d);
}

interface Fax {

    void fax(Document d);
}

class JustAPrinter implements Printer {

    public void print(Document d) {
        // yep
    }
}

class Photocopier implements Printer, Scanner {

    public void print(Document d) {
        //
    }

    public void scan(Document d) {
        //
    }
}

interface MultiFunctionDevice extends Printer, Scanner, Fax {

}

class MultiFunctionMachine implements MultiFunctionDevice {

    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }

    @Override
    public void fax(Document d) {

    }
}


