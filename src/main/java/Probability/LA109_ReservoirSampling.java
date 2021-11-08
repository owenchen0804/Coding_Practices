package Probability;

public class LA109_ReservoirSampling {
    private Integer sample;
    private int count;
    public LA109_ReservoirSampling() {
        // Write your constructor code here if necessary.
        this.count = 0;
        this.sample = null;
    }

    public void read(int value) {
        // Write your implementation here.
        count++;
        int prob = (int) (Math.random() * count);
        if (prob == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        // Write your implementation here.
        return sample;
    }
}
