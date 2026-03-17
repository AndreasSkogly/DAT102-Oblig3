import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int antElement = 100000;
        final int maxVerdi = 1000000;
        final int antSok = 10000;

        HashSet<Integer> hashSet = new HashSet<>();
        Integer[] tabell = new Integer[antElement];
        int[] soketall = new int[antSok];

        int tall = 376;
        for (int i = 0; i < antElement; i++) {
            hashSet.add(tall);
            tabell[i] = tall;
            tall = (tall + 45713) % maxVerdi;
        }

        Arrays.sort(tabell);

        Random tilfeldig = new Random();
        for (int i = 0; i < antSok; i++) {
            soketall[i] = tilfeldig.nextInt(maxVerdi);
        }

        int antFunnetHash = 0;
        long startHash = System.nanoTime();
        for (int x : soketall) {
            if (hashSet.contains(x)) {
                antFunnetHash++;
            }
        }

        long sluttHash = System.nanoTime();

        int antFunnetBin = 0;
        long startBin = System.nanoTime();
        for (int x : soketall) {
            if (Arrays.binarySearch(tabell, x) >= 0) {
                antFunnetBin++;
            }
        }
        long sluttBin = System.nanoTime();

        double tidHashMs =(sluttHash-startHash)/1000000.0;
        double tidBinMs =(sluttBin-startBin)/1000000.0;

        System.out.println("HashSet");
        System.out.println();
        System.out.println("Antall funn: " + antFunnetHash);
        System.out.println("Tid: " + tidHashMs + " ms");

        System.out.println();

        System.out.println("Binærsøk:");
        System.out.println();
        System.out.println("Antall funn: " + antFunnetBin);
        System.out.println("Tid: " + tidBinMs + " ms");
    }
}