package hopfield;

public class Layer {


    protected Neuron neuron[] = new Neuron[4];
    protected boolean output[] = new boolean[4];

    protected int neurons;
    public static final double lambda = 1.0;

    Layer(int weights[][]) {
        neurons = weights[0].length;

        neuron = new Neuron[neurons];
        output = new boolean[neurons];

        for (int i = 0; i < neurons; i++)
            neuron[i] = new Neuron(weights[i]);
    }

    public boolean threshold(int k) {
        double kk = k * lambda;
        double a = Math.exp(kk);
        double b = Math.exp(-kk);
        double tanh = (a - b) / (a + b);
        return (tanh >= 0);
    }

    void activation(boolean pattern[]) {
        int i, j;
        for (i = 0; i < 4; i++) {
            neuron[i].activation = neuron[i].act(pattern);
            output[i] = threshold(neuron[i].activation);
        }
    }
}
