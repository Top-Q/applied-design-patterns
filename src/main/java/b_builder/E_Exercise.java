package b_builder;

/**
 * You are asked to implement the Builder design pattern for rendering simple chunks of code.
 *
 * Sample use of the builder you are asked to create:
 *
 * CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
 * System.out.println(cb);
 * The expected output of the above code is:
 *
 * public class Person
 * {
 *   public String name;
 *   public int age;
 * }
 */

class CodeBuilder
{
    public CodeBuilder(String className)
    {
        // todo
    }

    public CodeBuilder addField(String name, String type)
    {
        // todo
        return this;
    }

    @Override
    public String toString()
    {
        // todo
        return null;
    }
}