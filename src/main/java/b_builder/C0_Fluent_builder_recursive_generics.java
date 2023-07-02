package b_builder;

class Person{

    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder {

    protected Person person = new Person();

    public PersonBuilder withName(String name)
    {
        person.name = name;
        return this;
    }

    public Person build()
    {
        return person;
    }
}

class EmployeeBuilder extends PersonBuilder {

        public EmployeeBuilder worksAs(String position)
        {
            // Remember that person is protected in PersonBuilder.
            person.position = position;
            return this;
        }

}

class Builder3Demo {

    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person person = pb.withName("Itai").build();
        System.out.println(person);

        EmployeeBuilder eb = new EmployeeBuilder();
//        Person itai = eb.withName("Itai").worksAs("Top-Q").build();  // Doesn't work
    }
}