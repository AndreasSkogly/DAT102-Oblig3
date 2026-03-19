import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TabellMengdeTest {


    private TabellMengde<Integer> mengde;
    private TabellMengde<Integer> mengde2;
    private TabellMengde<Integer> mengde3;


    @BeforeEach
    public void setUp() {
        mengde = new TabellMengde<>(3);
        mengde2 = new TabellMengde<>(5);
        mengde3 = new TabellMengde<>(3);

        mengde.leggTil(1);
        mengde.leggTil(2);
        mengde.leggTil(3);

        mengde2.leggTil(1);
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        mengde2.leggTil(4);
        mengde2.leggTil(5);

        mengde3.leggTil(7);
        mengde3.leggTil(8);
        mengde3.leggTil(9);
    }

    @Test
    void erTom() {
        assertFalse(mengde.erTom());
        assertFalse(mengde2.erTom());
    }

    @Test
    void inneholder() {
        assertTrue(mengde.inneholder(2));
        assertTrue(mengde2.inneholder(5));
    }

    @Test
    void erDelmengdeAv() {
        assertFalse(mengde2.erDelmengdeAv(mengde));
        assertTrue(mengde.erDelmengdeAv(mengde2));
    }

    @Test
    void erLik() {
        assertFalse(mengde.erLik(mengde2));
        assertFalse(mengde2.erLik(mengde));
        assertFalse(mengde3.erLik(mengde2));
    }

    @Test
    void erDisjunkt() {
        assertFalse(mengde.erDisjunkt(mengde2));
        assertFalse(mengde2.erDisjunkt(mengde));
        assertTrue(mengde.erDisjunkt(mengde3));
    }

    @Test
    void snitt() {
        Object[] resultat = mengde2.snitt(mengde).tilTabell();
        Arrays.sort(resultat);
        assertArrayEquals(new Integer[]{1,2,3}, resultat);
    }

    @Test
    void union() {
        Object [] resultat = mengde2.union(mengde).tilTabell();
        Arrays.sort(resultat);
        assertArrayEquals(new Integer[]{1,2,3,4,5}, resultat);
    }

    @Test
    void minus() {
       Object[] resultat = mengde2.minus(mengde).tilTabell();
       Arrays.sort(resultat);
       Object[] resultat1 = mengde.minus(mengde3).tilTabell();
       Arrays.sort(resultat1);
       assertArrayEquals(new Integer[]{4,5},resultat);
       assertArrayEquals(new Integer[]{1,2,3},resultat1);
    }

    @Test
    void leggTil() {
        mengde.leggTil(10);
        assertTrue(mengde.inneholder(10));
    }

    @Test
    void leggTilAlleFra() {
        mengde.leggTilAlleFra(mengde3);
        assertArrayEquals(new Integer[]{1,2,3,7,8,9}, mengde.tilTabell());
    }

    @Test
    void fjern() {
        mengde.fjern(2);
        assertFalse(mengde.erTom());
        mengde.fjern(1);
        mengde.fjern(3);
        assertTrue(mengde.erTom());
    }

    @Test
    void tilTabell() {
        assertArrayEquals(new Integer[]{1,2,3},mengde.tilTabell());
        assertArrayEquals(new Integer[]{7,8,9},mengde3.tilTabell());
        assertArrayEquals(new Integer[]{1,2,3,4,5},mengde2.tilTabell());
    }

    @Test
    void antallElementer() {
        assertEquals(3, mengde.antallElementer());
        assertEquals(5, mengde2.antallElementer());
    }
}
