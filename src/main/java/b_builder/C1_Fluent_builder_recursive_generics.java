package b_builder;

class BetterPersonBuilder<SELF extends BetterPersonBuilder<SELF>> {

    protected Person person = new Person();

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    protected SELF self() {
        return (SELF)this;
    }

    public Person build() {
        return person;
    }

}

class BetterEmployeeBuilder extends BetterPersonBuilder<BetterEmployeeBuilder> {

    public BetterEmployeeBuilder worksAs(String position) {
        person.position = position;
        return self();
    }

}

class RecursiveGenericsDemo {

    public static void main(String[] args) {
        BetterEmployeeBuilder eb = new BetterEmployeeBuilder()
                .withName("Itai").worksAs("Developer");
        System.out.println(eb.build());
    }

}