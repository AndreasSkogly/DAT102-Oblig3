import org.w3c.dom.Node;

import java.util.Arrays;
public class LenketMengde <T> implements MengdeADT<T> {
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
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {

        Node<T> temp = start;

        while (temp != null) {
            if (!annenMengde.inneholder(temp.element)) {
                return false;
            }
            temp = temp.neste;
        }

        return true;
    }
    public boolean erLik(MengdeADT<T>annenmengde){
        if(antall!=annenmengde.antallElementer()){
            return false;

        }
        return erDelmengdeAv(annenmengde);

    }
    public  boolean erDisjunkt(MengdeADT<T>annenmengde){
        Node<T> temp = start;
        while (temp!=null ){
            if(annenmengde.inneholder(temp.element)){
                return false;

            }
            temp= temp.neste;

        }
        return true;

    }
    public MengdeADT<T>snitt(MengdeADT<T>annenmengde){
        MengdeADT<T> resultat= new LenketMengde<>();
        Node<T>temp=start;
        while(temp != null ){
            if(annenmengde.inneholder(temp.element)){
                resultat.leggTil(temp.element);

            }
            temp = temp.neste;

        }
        return resultat;


    }
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {

        MengdeADT<T> resultat = new LenketMengde<>();

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

    public boolean MengdeADT<T> minus (MengdeADT<T> annenMengde) {
        MengdeADT<T> resultat = new LenketMengde<>();
        Node<T> temp = start;

        while (temp != null) {

            if (!annenMengde.inneholder(temp.element)) {
                resultat.leggTil(temp.element);
            }
            temp = temp.neste;
        }

        return resultat;
    }


}
