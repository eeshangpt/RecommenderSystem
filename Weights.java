
import java.util.Random;

public class Weights {

    int[][] population = new int[25][10];

    public Weights() {
        for (int i = 0; i < 25; i++) {
            population[i] = new int[10];
        }
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 10; j++) {
                population[i][j] = random.nextInt(15);
            }
        }
    }

    public int[] applyGA() {

        Weights w = new Weights();
        for (int i = 0; i < 30; i++) {
            applySelection(w);
            applyCrossover(w);
        }
        return w.population[0];
    }

    private void applySelection(Weights w) {

        Random r = new Random();
        for (int i = 0; i < 20; i += 2) {
            int p = r.nextInt(9);
            for (int j = 0; j < 10; j++) {
                if (j > p) {
                    swap(population[i][j], population[i + 1][j]);
                }
            }
        }

    }

    private void applyCrossover(Weights w) {

        Random random = new Random();
        double pm = 0.1, r;
        for (int i = 20; i < 25; i++) {
            for (int j = 0; j < 10; j++) {
                r = random.nextDouble();
                if (r < pm) {
                    w.population[i][j] = random.nextInt(15);
                }
            }
        }
    }

    private void swap(int a, int b) {

        int temp;
        temp = a;
        a = b;
        b = temp;

    }
}
