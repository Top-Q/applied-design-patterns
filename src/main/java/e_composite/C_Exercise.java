package e_composite;

import java.util.*;
import java.util.function.Consumer;

/*
Consider the code presented below. The MyList.sum()
 method adds up all the values in a list of ValueContainer
 elements it gets passed. We can have a single value or a set of values.

Complete the implementation of the interfaces so that sum() begins to work correctly.
 */
import java.util.*;

interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
    {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        // todo
        return null;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        // todo
    }

    @Override
    public Spliterator<Integer> spliterator() {
        // todo
        return null;
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
}


class MyList extends ArrayList<ValueContainer>
{
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
        // todo
        return 0;
    }
}