import java.util.*;
import java.util.HashSet;

public class JavaSetToMengde<T> implements MengdeADT3<T> {

    private Set<T> mengde;
    private int antall = 0;

    public JavaSetToMengde() {
       mengde = new HashSet<>();
    }


    @Override
    public boolean erTom() {
        return mengde.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return mengde.contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT3<T> annenMengde) {
        for (T element : mengde) {
            if (!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT3<T> annenMengde) {
        return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
    }

    @Override
    public boolean erDisjunkt(MengdeADT3<T> annenMengde) {
        for (T element : mengde) {
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT3<T> snitt(MengdeADT3<T> annenMengde) {
        MengdeADT3<T> resultat = new JavaSetToMengde<>();
        for (T element : mengde) {
            if (annenMengde.inneholder(element)) {
                resultat.leggTil(element);
            }
        }

        return resultat;
    }


    @Override
    public MengdeADT3<T> union(MengdeADT3<T> annenMengde) {
        MengdeADT3<T> resultat = new JavaSetToMengde<>();

        for (T element : mengde) {
            resultat.leggTil(element);
        }

        for (T element : annenMengde.tilTabell()) {
            resultat.leggTil(element);
        }

        return resultat;
    }



    @Override
    public MengdeADT3<T> minus(MengdeADT3<T> annenMengde) {

        MengdeADT3<T> resultat = new JavaSetToMengde<>();
        for (T element : mengde) {
            if (!annenMengde.inneholder(element)) {
                resultat.leggTil(element);
            }
        }
        return resultat;
    }

    @Override
    public void leggTil(T element) {
        if (element != null) {
            mengde.add(element);
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT3<T> annenMengde) {
        for (T element : annenMengde.tilTabell()) {
            mengde.add(element);
        }
    }


    @Override
    public T fjern(T element) {
        if (mengde.remove(element)) {
            return element;
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        return (T[]) mengde.toArray(new Object[0]);
    }

    @Override
    public int antallElementer() {
        return mengde.size();
    }
}
