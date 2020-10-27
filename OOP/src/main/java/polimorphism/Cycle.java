package polimorphism;

public class Cycle {
    public void ride(Direction key) {
        System.out.println("Cycle.ride" + key);
        System.out.println("wheels = " + wheels());
    }

    public int wheels() {
        return 4;
    }
}