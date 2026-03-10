public class LenketMengde <T> implements MengdeADT2<T> {
    private Node<T>start;
    private int antall;

    private static class Node<T>{
        T element;
        Node <T> neste;
        Node (T element){
            this.element= element;
            this.neste=null;

        }
    }


     public LenketMengde(){
         start= null;
         antall =0;
     }

     public boolean erTom(){
        return antall== 0;

     }

    public boolean inneholder(T element) {
        Node<T> temp = start;

        while (temp != null) {
            if (temp.element.equals(element)) {
                return true;
            }
            temp = temp.neste;
        }

        return false;
    }
    @Override
    public boolean erDelmengdeAv(MengdeADT2<T> annenMengde) {

        Node<T> temp = start;

        while (temp != null) {
            if (!annenMengde.inneholder(temp.element)) {
                return false;
            }
            temp = temp.neste;
        }

        return true;
    }
    public boolean erLik(MengdeADT2<T> annenmengde){
        if(antall!=annenmengde.antallElementer()){
            return false;

        }
        return erDelmengdeAv(annenmengde);

    }
    public  boolean erDisjunkt(MengdeADT2<T> annenmengde){
        Node<T> temp = start;
        while (temp!=null ){
            if(annenmengde.inneholder(temp.element)){
                return false;

            }
            temp= temp.neste;

        }
        return true;

    }
    public MengdeADT2<T> snitt(MengdeADT2<T> annenmengde){
        MengdeADT2<T> resultat= new LenketMengde<>();
        Node<T>temp=start;
        while(temp != null ){
            if(annenmengde.inneholder(temp.element)){
                resultat.leggTil(temp.element);

            }
            temp = temp.neste;

        }
        return resultat;


    }
    public MengdeADT2<T> union(MengdeADT2<T> annenMengde) {

        MengdeADT2<T> resultat = new LenketMengde<>();

        Node<T> temp = start;

        while (temp != null) {
            resultat.leggTil(temp.element);
            temp = temp.neste;
        }

        T[] andre = annenMengde.tilTabell();

        for (T e : andre) {
            resultat.leggTil(e);
        }

        return resultat;
    }

    public MengdeADT2<T> minus(MengdeADT2<T> annenMengde) {
        MengdeADT2<T> resultat = new LenketMengde<>();
        Node<T> temp = start;

        while (temp != null) {

            if (!annenMengde.inneholder(temp.element)) {
                resultat.leggTil(temp.element);
            }
            temp = temp.neste;
        }

        return resultat;
    }

    public void leggTil(T element) {
        if(!inneholder(element)){
            Node<T> ny = new Node<>(element);
            ny.neste = start;
            start= ny;
            antall++;
        }

    }
    public void leggTilAlleFra(MengdeADT2<T> annenMengde){
        T[]tabell= annenMengde.tilTabell();
        for( T e : tabell){
            leggTil(e);
        }
    }
    public T fjern(T element) {

        Node<T> temp = start;
        Node<T> forrige = null;

        while (temp != null) {

            if (temp.element.equals(element)) {

                if (forrige == null) {
                    start = temp.neste;
                } else {
                    forrige.neste = temp.neste;
                }

                antall--;
                return temp.element;
            }

            forrige = temp;
            temp = temp.neste;
        }

        return null;
    }
    public T[] tilTabell() {
        T[] tabell = (T[]) new Object[antall];
        Node<T> temp = start;
        int i = 0;

        while (temp != null) {
            tabell[i] = temp.element;
            i++;
            temp = temp.neste;
        }

        return tabell;
    }

    public int antallElementer() {
        return antall;
    }

}





