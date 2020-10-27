package additional_task.Rodents;

public abstract class Rodent {
    private static long refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public void move() {
        System.out.println("Rodent makes a move");
    }

    public abstract void specialEffects();

    public void wind() {
        move();
        specialEffects();
    }

    public static void addRef() {
        refcount++;
    }

    public void dispose() {
        if (--refcount == 0) {
            System.out.println("Все грызуны покинули этот уровень");
        }
    }
}
