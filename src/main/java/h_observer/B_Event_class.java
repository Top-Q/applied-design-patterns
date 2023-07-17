package h_observer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Event<TArgs> {

    private int count = 0;

    private Map<Integer, Consumer<TArgs>> handlers = new HashMap<>();

    public Subscription addHandler(Consumer<TArgs> handler) {
        int i = count;
        handlers.put(count++, handler);
        return new Subscription(this, i);
    }

    public void fire(TArgs args) {
        for (Consumer<TArgs> handler : handlers.values())
            handler.accept(args);
    }

    class Subscription implements AutoCloseable {
        private Event<TArgs> event;
        private int id;

        public Subscription(Event<TArgs> event, int id) {
            this.event = event;
            this.id = id;
        }

        @Override
        public void close() {
            event.handlers.remove(id);
        }
    }

}

class PropertyChangedEventArgs {
    public Object source;
    public String propertyName;
    public Object newValue;

    public PropertyChangedEventArgs(Object source, String propertyName, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}

class Person0 {
    public Event<PropertyChangedEventArgs> propertyChangedEvent = new Event<>();

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        propertyChangedEvent.fire(new PropertyChangedEventArgs(this, "age", age));
    }
}

class MyAwesomeEventDemo {
    public static void main(String[] args) {
        Person0 person = new Person0();
        final Event<PropertyChangedEventArgs>.Subscription subscription = person.propertyChangedEvent.addHandler(x -> {
            System.out.println("Person's " + x.propertyName + " has changed to " + x.newValue );
        });
        person.setAge(17);
        person.setAge(18);
        subscription.close();
        person.setAge(19);

        try (Event<PropertyChangedEventArgs>.Subscription subscription2 = person.propertyChangedEvent.addHandler(x -> {
            System.out.println("Person's " + x.propertyName + " has changed to " + x.newValue );
        })) {
            person.setAge(20);
            person.setAge(21);
        }
        person.setAge(22);





    }
}