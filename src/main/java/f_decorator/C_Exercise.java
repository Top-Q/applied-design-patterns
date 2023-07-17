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
    private Bird bird;
    private Lizard lizard;
    private int age;

    public Dragon(Bird bird, Lizard lizard)
    {
        this.bird = bird;
        this.lizard = lizard;
    }

    public void setAge(int age)
    {
        this.age = age;
        bird.age = age;
        lizard.age = age;
    }
    public String fly()
    {
       return bird.fly();
    }
    public String crawl()
    {
        return lizard.crawl();
    }
}

class DragonDemo {
    public static void main(String[] args) {
        Dragon dragon = new Dragon(new Bird(), new Lizard());
        dragon.setAge(1);
        System.out.println(dragon.fly());
        System.out.println(dragon.crawl());

        dragon.setAge(5);
        System.out.println(dragon.fly());
        System.out.println(dragon.crawl());

    }
}