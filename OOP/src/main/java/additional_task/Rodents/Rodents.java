package additional_task.Rodents;
import java.util.Random;
public class Rodents {
    private static void control(Rodent rodent) {
        rodent.wind();
    }

    private static Rodent randRodentGen() {
        Random random = new Random();

        switch (random.nextInt(3)) {
            case 0: return new Mouse();
            default: return new Hamster();
        }
    }

    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[10];
        for (int index = 0; index < rodents.length; index++) {
            rodents[index] = randRodentGen();
        }
        for (Rodent r : rodents) {
            control(r);
            System.out.println();
        }

        for (Rodent r : rodents) {
            r.dispose();
            System.out.println();
        }


    }
}
