package b_builder;

// We have an object with many fields, and we want to build it.

class FullPerson {

    public String name;

    public String position;

    public String company;

    public String address;

    public String postcode;

    public String phone;

    public String email;

    @Override
    public String toString(){
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

class FullPersonBuilder {

    protected FullPerson person = new FullPerson();

    public FullPerson build() {
        return person;
    }

    public FullPersonBuilder withName(String name) {
        person.name = name;
        return this;
    }

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

}

// It's important that we will extend the FullPersonBuilder class.
class PersonAddressBuilder extends FullPersonBuilder {

    public PersonAddressBuilder(FullPerson person) {
        this.person = person;
    }

    public PersonAddressBuilder livesAt(String address) {
        person.address = address;
        return this;
    }

    public PersonAddressBuilder postcode(String postcode) {
        person.postcode = postcode;
        return this;
    }


}

class PersonJobBuilder extends FullPersonBuilder {

    public PersonJobBuilder(FullPerson person) {
        this.person = person;
    }

    public PersonJobBuilder worksAs(String position) {
        person.position = position;
        return this;
    }

    public PersonJobBuilder at(String company) {
        person.company = company;
        return this;
    }

}

class BuilderFacetsDemo {

    public static void main(String[] args) {
        FullPersonBuilder pb = new FullPersonBuilder();
        pb.withName("Itai")
                .lives()
                .livesAt("Hagalil")
                .postcode("432222")
                .works()
                .at("Top-Q")
                .worksAs("CTO");

        FullPerson person = pb.build();
        System.out.println(person);
    }

}
