package h_observer;

import java.util.ArrayList;
import java.util.List;

class PropertyChangedEvent<T> {
    public T source;
    public String propertyName;
    public Object newValue;

    public PropertyChangedEvent(T source, String propertyName, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}

interface Observer<T> {
    void handle(PropertyChangedEvent<T> args);
}

abstract class Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer<T> observer) {
        observers.remove(observer);
    }

    protected void propertyChanged(T source, String propertyName, Object newValue) {
        for (Observer<T> o : observers)
            o.handle(new PropertyChangedEvent<T>(source, propertyName, newValue));
    }
}


class Person extends Observable<Person> {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        propertyChanged(this, "age", age);
    }

}

class ObserverDemo0 implements Observer<Person> {
    public ObserverDemo0() {
        Person person = new Person();
        person.subscribe(this);
        for (int i = 20; i < 24; ++i) {
            person.setAge(i);
        }

        person.unsubscribe(this);

        // We will not see anything since we unsubscribed.
        for (int i = 24; i < 30; ++i) {
            person.setAge(i);
        }


    }

    @Override
    public void handle(PropertyChangedEvent<Person> args) {
        System.out.println("Person's " + args.propertyName + " has been changed to " + args.newValue);
    }

    public static void main(String[] args) {
        new ObserverDemo0();
    }
}


