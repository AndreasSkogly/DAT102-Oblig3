import java.util.*;

import static java.util.Collections.max;

public class HobbyMatchMain {
    public static void main(String[] args) {


        Person Daniel = new Person("Daniel", Set.of("Gaming", "Fotball", "Fisking","Trening","Ski"));
        Person Jesper = new Person("Jesper", Set.of("Gaming", "Fotball", "Curling", "Gitar","Håndball"));
        Person Stian = new Person("Stian", Set.of("Synging","Roping","Gaming","Fotball","Ski"));

        double m1 = match(Daniel, Jesper);
        double m2 = match(Daniel, Stian);
        double m3 = match(Jesper, Stian);
        List<Double> svar = new ArrayList<>();

        double bestScore = m1;
        String bestMatch = Daniel.getNavn() + " og " + Jesper.getNavn();

        if(m2>bestScore){
            bestScore = m2;
            bestMatch = Daniel.getNavn() + " og " + Stian.getNavn();
        }
        if(m3>bestScore){
            bestScore = m3;
            bestMatch = Jesper.getNavn() + " og " + Stian.getNavn();
        }
        svar.add(m1);
        svar.add(m2);
        svar.add(m3);

        double BMScore = max(svar);
        System.out.println("Den beste matchen var " + bestMatch + " med en score på: " + BMScore);


    }

         static double match(Person a, Person b) {
            int felles = 0;

            for(String h :a.getHobby()){
                if(b.getHobby().contains(h)){
                    felles++;
                }
            }
            int total = a.getHobby().size() + b.getHobby().size()-felles;
            return (double)felles/total;
         }

}
