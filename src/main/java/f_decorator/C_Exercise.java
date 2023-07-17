package f_decorator;

/**
 * The following code scenario shows a Dragon which is both a Bird and a Lizard.
 * Complete the Dragon's implementation.
 * Take special care when implementing setAge() !
 */
class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{
    private int age;
    public void setAge(int age)
    {
        // todo
    }
    public String fly()
    {
        // todo
        return null;
    }
    public String crawl()
    {
        // todo
        return null;
    }
}