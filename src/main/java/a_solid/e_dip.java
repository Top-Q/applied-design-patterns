package a_solid;

// DIP - Dependency Inversion Principle
// NOT TO BE CONFUSED WITH DEPENDENCY INJECTION
// The priniciple states that:
// A. High-level modules should not depend on low-level modules. Both should depend on abstractions.
// B. Abstractions should not depend on details. Details should depend on abstractions.
//
// Abstract is abstract class or an interface. Details are implementation (Concrete class) of abstract classes
// or interfaces.

// We will focus on the first part of the principle, which is the most important one.
// Let's say we want to make a tree like a family tree.


import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

enum Relationship
{
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    public String name;
    // dob etc.

    public Person(String name) {
        this.name = name;
    }
}

// Now we want to module the relationships between different people. - Low Level Module
class Relationships {

    private List<Triplet<Person, Relationship, Person>> relations =
            new ArrayList<>();

    public void addParentAndChild(Person parent, Person child)
    {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }
}

// How we can now research the relationships?
class Research {

    public Research(Relationships relationships)
        {
            final List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
            relations.stream()
                    .filter(x -> x.getValue0().name.equals("John")
                            && x.getValue1() == Relationship.PARENT)
                    .forEach(ch -> System.out.println(
                            "John has a child called " + ch.getValue2().name
                    ));


    }
}

class DemoDip {

    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        // Low-level module
        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }

}
