import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Odev2 {
    public static void main(String[] args) {
        int[] perfect_solution = {4, 2, 7, 3, 6, 8, 5, 1};
        List<int[]> initial_population = generate_population(100);
        int fitness = calculate_fitness(perfect_solution);
        System.out.println("Mükemmel bir çözümün uygunluğu: " + fitness);
        int[] firstPopulation = initial_population.get(0);
        System.out.println("Popülasyondaki ilk genotip: " + Arrays.toString(firstPopulation));
        System.out.println(initial_population.size() + " genotipten oluşan bir popülasyon oluşturuldu.");
    }

    public static int calculate_fitness(int[] geno) {
        int fitness = 28;
        int a = 0;
        for (int i = 0; i < geno.length; i++) {
            for (int j = i + 1; j < geno.length; j++) {
                if (Math.abs(i - j) == Math.abs(geno[i] - geno[j])) {
                    a++;
                }
            }
        }
        return fitness - a;
    }

    public static List<int[]> generate_population(int size) {
        List<int[]> population = new ArrayList<>();
        int[] geno = {1, 2, 3, 4, 5, 6, 7, 8};
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int[] clone = geno.clone();
            for (int j = clone.length - 1; j > 0; j--) {
                int k = random.nextInt(j + 1);
                int temp = clone[j];
                clone[j] = clone[k];
                clone[k] = temp;
            }
            population.add(clone);
        }
        return population;
    }
}