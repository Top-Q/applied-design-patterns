package a_solid;

// Let's fix the problem that we saw in the last example.

import org.javatuples.Triplet;

import java.util.List;
import java.util.stream.Collectors;

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

class BetterRelationships implements RelationshipBrowser {
    // Triplet class requires javatuples
    private List<Triplet<Person, Relationship, Person>> relations;

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Person> findAllChildrenOf(String name) {

        return relations.stream()
                .filter(x -> x.getValue0().name.equals(name)
                        && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }

}

class BetterResearch {

        public BetterResearch(RelationshipBrowser relationships) {
            List<Person> children = relationships.findAllChildrenOf("John");
            children.forEach(child -> System.out.println("John has a child called " + child.name));
        }
}

class DemoDip2 {

    public static void main(String[] args) {
        // The main code looks exactly the same as before
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        // low-level module
        BetterRelationships relationships = new BetterRelationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new BetterResearch(relationships);
    }

}
