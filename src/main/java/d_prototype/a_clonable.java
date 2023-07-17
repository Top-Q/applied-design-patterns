package d_prototype;

import java.util.Arrays;

class Address  {
    public String streetName;
    public int houseNumber;

    public Address(String streetName, int houseNumber)
    {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public Object clone() {
        return new Address(streetName, houseNumber);
    }

    @Override
    public String toString()
    {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

}

class Person implements Cloneable{
    public String[] names;
    public Address address;

    public Person(String[] names, Address address)
    {
        this.names = names;
        this.address = address;
    }

    public String toString() {
        return "names: " + Arrays.toString(names) + " address: " + address;
    }

    @Override
    public Object clone()  {
        return new Person(names.clone(), (Address) address.clone());
    }

}

class Demo {


    public static void main(String[] args) throws CloneNotSupportedException {

        Person itai = new Person(new String[]{"Itai", "Agmon"}, new Address("Bar-Ilan", 10));
        // Big mistake. Never do it
        //        Person yoni = itai;
        //        yoni.names[0] = "Yoni";


        Person yoni = (Person) itai.clone();
        yoni.names[0] = "Yoni";
        yoni.names[1] = "Davidson";

        System.out.println(itai);
        System.out.println(yoni);

    }
}