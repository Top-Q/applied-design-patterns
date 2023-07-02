package c_factory;

class Person0
{
    public final int id;
    public String name;

    public Person0(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

}

class PersonFactory0
{
    private static int id = 0;

    public Person0 createPerson(String name)
    {
        return new Person0(id++, name);
    }
}

class FactoryDemo0
{
    public static void main(String[] args)
    {
        PersonFactory0 personFactory = new PersonFactory0();
        Person0 person1 = personFactory.createPerson("Chris");
        Person0 person2 = personFactory.createPerson("Sarah");
        Person0 person3 = personFactory.createPerson("John");
        System.out.println(person1.id + " " + person1.name);
        System.out.println(person2.id + " " + person2.name);
        System.out.println(person3.id + " " + person3.name);
    }
}