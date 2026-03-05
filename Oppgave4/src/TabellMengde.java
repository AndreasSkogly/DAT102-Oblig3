import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabellMengde<T> implements MengdeADT<T> {

    private T[] mengde;
    private int antall= 0;


    @Override
    public boolean erTom() {
        return List.of(mengde).isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return List.of(mengde).contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        return List.of(mengde).contains(annenMengde);
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return List.of(mengde).equals(annenMengde);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        return !List.of(mengde).contains(annenMengde);
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new TabellMengde<>();

        for(T element : mengde){
            if(annenMengde.inneholder(element)){
                resultat.leggTil(element);
            }
        }
        return resultat;
    }


    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        TabellMengde <T> resultat = new TabellMengde<>();

        for (T element : mengde){
            resultat.leggTil(element);

            }
        for (T i = 0; i >= annenMengde.antallElementer(); i++){
            if(!annenMengde.inneholder(i)) {
                resultat.leggTil(i);
            }

            return resultat;
            }
        }



    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public void leggTil(T element) {
        if (antall >= mengde.length) {

            mengde = Arrays.copyOf(mengde, mengde.length * 2);
        }
        mengde[antall] = element;
        antall++;

    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        List.of(mengde).addAll(List.of((T) annenMengde));

    }


    @Override
    public T fjern(T element) {
        if (erTom()) { //Tom
            return null;
        }
        T temp = mengde[antall-1];
        mengde[antall-1] = null;
        antall--;
        return temp;

    }

    @Override
    public T[] tilTabell() {
        return new T[0];
    }

    @Override
    public int antallElementer() {
        return antall;
    }
}
