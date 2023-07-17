package e_composite;


import java.util.*;
import java.util.function.Consumer;

interface SomeNeurons extends Iterable<Neuron>
{
    default void connectTo(SomeNeurons other)
    {
        // Input test
        if (this == other) return;

        for (Neuron from : this)
            for (Neuron to : other)
            {
                from.out.add(to);
                to.in.add(from);
            }
    }
}

class Neuron implements SomeNeurons
{
    public ArrayList<Neuron> in, out;

    public void connectTo(Neuron other)
    {
        out.add(other);
        other.in.add(this);
    }

    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }
}

// The problem is that we also have neuron layers, which are collections of neurons.
class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons
{
}

class NeuralNetworkDemo {
    public static void main(String[] args) {
        Neuron neuron0 = new Neuron();
        Neuron neuron1 = new Neuron();
        NeuronLayer layer0 = new NeuronLayer();
        NeuronLayer layer1 = new NeuronLayer();

        // We need to support four different way to connect, and we support only one of them.
        neuron0.connectTo(neuron1);
        neuron0.connectTo(layer0);
        layer0.connectTo(layer1);
        layer0.connectTo(layer1);
    }
}
