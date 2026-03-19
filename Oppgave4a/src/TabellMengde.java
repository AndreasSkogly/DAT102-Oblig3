import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T> {

    private T[] mengde;
    private int antall = 0;

    public TabellMengde(int kapasitet) {
        this.mengde = (T[]) new Object[kapasitet];
        this.antall = 0;
    }

    public TabellMengde(T[] mengde, int antall) {
        if (mengde == null) {
            this.mengde = (T[]) new Object[10];
            this.antall = 0;
        } else {
            this.mengde = mengde;
            this.antall = antall;
        }
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {

        for(int i = 0; i<antall; i++){
            if(mengde[i]!= null && mengde[i].equals(element)){ //la til en null sjekk i tilfelle den blir null
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for(int i = 0; i< antall; i++){
            T element = mengde[i];
            if(!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(mengde[i])) return false;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new TabellMengde<>(this.antallElementer());
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(mengde[i])) {
                resultat.leggTil(mengde[i]);
            }
        }
        return resultat;
    }


    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        TabellMengde<T> unionMengde = new TabellMengde<>(this.antallElementer() + annenMengde.antallElementer());

        for (int i = 0; i < antall; i++) {
            unionMengde.leggTil(mengde[i]);
        }

        for (T element : annenMengde.tilTabell()) {
            unionMengde.leggTil(element);
        }

        return unionMengde;
    }



    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat_m = new TabellMengde<>(10);
        for(int i=0; i< antall;i++){
            T element = mengde[i];
            if(!annenMengde.inneholder(element)){
                resultat_m.leggTil(element);
            }
        }

        return resultat_m;
    }

    @Override
    public void leggTil(T element) {
        if (element == null) return;
        if (inneholder(element)) return;

        if (antall >= mengde.length) {
            mengde = Arrays.copyOf(mengde, mengde.length * 2);
        }
        mengde[antall++] = element;
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        for (T element : annenMengde.tilTabell()) {
            leggTil(element);
        }

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
        return Arrays.copyOf(mengde, antall);
    }

    @Override
    public int antallElementer() {
       return antall;
    }
}
