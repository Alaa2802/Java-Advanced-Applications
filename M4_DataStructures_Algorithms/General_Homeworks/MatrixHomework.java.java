
import java.util.*;

public class HomeWork3 {
    static Random rand = new Random();

    public static void main(String[] args) {
        int[] pop1 = {4, 2, 7, 3, 6, 8, 5, 1};
        int[] pop2 = {1, 5, 2, 6, 8, 7, 4, 3};
        int[] pop3 = {3, 6, 8, 2, 7, 5, 1, 4};
        int[] pop4 = {5, 7, 1, 8, 4, 2, 3, 6};

        ArrayList<int[]> population = new ArrayList<>();
        population.add(pop1);
        population.add(pop2);
        population.add(pop3);
        population.add(pop4);

        double[] fitness = {18.5, 26.0, 20.2, 24.3};

        int[] parent1 = tournament(population, fitness, 3);
        int[] parent2 = tournament(population, fitness, 3);
        // Eğer aynı çıktıysa yeniden seç (parent'lar farklı olsun)
        while (Arrays.equals(parent1, parent2)) {
            parent2 = tournament(population, fitness, 3);
        }

        System.out.println("Parent 1: " + Arrays.toString(parent1));
        System.out.println("Parent 2: " + Arrays.toString(parent2));

        int[] child = crossover(parent1, parent2);
        System.out.println("Crossover Çocuk: " + Arrays.toString(child));

        int[] childMut = mutate(child, 0.05);
        System.out.println("Mutasyonlu Çocuk: " + Arrays.toString(childMut));

        System.out.println("---- OX1 ----");
        int[] ox = orderX(parent1, parent2);
        System.out.println("OX1 Çocuk: " + Arrays.toString(ox));

        System.out.println("---- PMX ----");
        int[] pmx = pmx(parent1, parent2);
        System.out.println("PMX Çocuk: " + Arrays.toString(pmx));

        System.out.println("---- CX ----");
        int[] cx = cycle(parent1, parent2);
        System.out.println("CX Çocuk: " + Arrays.toString(cx));
    }

    // Gerçek k-tournament: k rastgele al, en iyi fitness seç
    public static int[] tournament(ArrayList<int[]> pop, double[] fit, int k) {
        int n = pop.size();
        if (k > n) k = n;
        int bestIndex = -1;
        double bestFitness = Double.NEGATIVE_INFINITY;

        for (int t = 0; t < k; t++) {
            int idx = rand.nextInt(n); // rastgele bir birey seç
            double f = fit[idx];
            if (f > bestFitness) {
                bestFitness = f;
                bestIndex = idx;
            }
        }
        return pop.get(bestIndex);
    }
    // Tek nokta çaprazlama (permütasyon uyarlanmış)
    public static int[] crossover(int[] p1, int[] p2) {
        int n = p1.length;
        int cut = rand.nextInt(n - 1) + 1;
        int[] c = new int[n];
        HashSet<Integer> used = new HashSet<>();

        for (int i = 0; i < cut; i++) {
            c[i] = p1[i];
            used.add(p1[i]);
        }

        int idx = cut;
        int j = cut;
        while (idx < n) {
            int g = p2[j % n];
            if (!used.contains(g)) {
                c[idx++] = g;
                used.add(g);
            }
            j++;
        }
        return c;
    }

    // Swap mutasyonu
    public static int[] mutate(int[] g, double rate) {
        int[] c = Arrays.copyOf(g, g.length);
        if (rand.nextDouble() < rate) {
            int i = rand.nextInt(c.length);
            int j = rand.nextInt(c.length);
            while (i == j) j = rand.nextInt(c.length);
            int tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
        return c;
    }

    // OX1
    public static int[] orderX(int[] p1, int[] p2) {
        int n = p1.length;
        int a = rand.nextInt(n);
        int b = rand.nextInt(n);
        if (a > b) { int t = a; a = b; b = t; }

        int[] c = new int[n];
        Arrays.fill(c, -1);

        for (int i = a; i <= b; i++) c[i] = p1[i];

        int idx = (b + 1) % n;
        for (int g : p2) {
            if (!contains(c, g)) {
                c[idx] = g;
                idx = (idx + 1) % n;
            }
        }
        return c;
    }

    public static boolean contains(int[] arr, int v) {
        for (int x : arr) if (x == v) return true;
        return false;
    }

    // Düzeltilmiş PMX
    public static int[] pmx(int[] p1, int[] p2) {
        int n = p1.length;
        int[] c = new int[n];
        Arrays.fill(c, -1);

        int a = rand.nextInt(n);
        int b = rand.nextInt(n);
        if (a > b) { int t = a; a = b; b = t; }

        for (int i = a; i <= b; i++) c[i] = p1[i];

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = a; i <= b; i++) map.put(p1[i], p2[i]);

        for (int i = 0; i < n; i++) {
            if (i >= a && i <= b) continue;
            int g = p2[i];
            while (contains(c, g)) {
                if (map.containsKey(g)) g = map.get(g);
                else break;
            }
            c[i] = g;
        }
        return c;
    }

    // CX
    public static int[] cycle(int[] p1, int[] p2) {
        int n = p1.length;
        int[] c = new int[n];
        Arrays.fill(c, -1);
        boolean[] vis = new boolean[n];
        int cycle = 1;

        for (int s = 0; s < n; s++) {
            if (vis[s]) continue;
            int idx = s;
            ArrayList<Integer> list = new ArrayList<>();

            while (!vis[idx]) {
                list.add(idx);
                vis[idx] = true;
                int val = p2[idx];
                idx = find(p1, val);
            }

            for (int id : list) c[id] = (cycle % 2 == 1 ? p1[id] : p2[id]);
            cycle++;
        }
        return c;
    }

    public static int find(int[] arr, int v) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == v) return i;
        return -1;
    }
}
