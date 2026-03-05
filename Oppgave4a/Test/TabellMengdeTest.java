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

        mengde3.leggTil(2);
        mengde3.leggTil(3);
        mengde3.leggTil(1);

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
        assertTrue(mengde.erLik(mengde3));
        assertFalse(mengde2.erLik(mengde));
        assertFalse(mengde3.erLik(mengde2));
    }

    @Test
    void erDisjunkt() {
    }

    @Test
    void snitt() {
    assertEquals((3),(mengde.snitt(mengde2)));
    }

    @Test
    void union() {
        Object [] resultat = mengde2.union(mengde).tilTabell();
        Arrays.sort(resultat);
        assertArrayEquals(new Integer[]{1,2,3,4,5}, resultat);
    }

    @Test
    void minus() {
    }

    @Test
    void leggTil() {
    }

    @Test
    void leggTilAlleFra() {
    }

    @Test
    void fjern() {
    }

    @Test
    void tilTabell() {
    }

    @Test
    void antallElementer() {
    }
}
