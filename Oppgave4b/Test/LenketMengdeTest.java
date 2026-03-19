import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LenketMengdeTest {
    @Test
    public void testErTom() {
        LenketMengde<Integer> m = new LenketMengde<>();
        assertTrue(m.erTom());

        m.leggTil(1);
        assertFalse(m.erTom());
    }

    @Test
    public void testLeggTilOgInneholder() {
        LenketMengde<String> m = new LenketMengde<>();

        m.leggTil("A");
        m.leggTil("B");

        assertTrue(m.inneholder("A"));
        assertTrue(m.inneholder("B"));
        assertFalse(m.inneholder("C"));
    }

    @Test
    public void testIngenDuplikater() {
        LenketMengde<Integer> m = new LenketMengde<>();

        m.leggTil(1);
        m.leggTil(1);

        assertEquals(1, m.antallElementer());
    }

    @Test
    public void testFjern() {
        LenketMengde<Integer> m = new LenketMengde<>();

        m.leggTil(1);
        m.leggTil(2);

        assertEquals(1, m.fjern(1));
        assertFalse(m.inneholder(1));
        assertEquals(1, m.antallElementer());

        assertNull(m.fjern(99)); // finnes ikke
    }

    @Test
    public void testErDelmengdeAv() {
        LenketMengde<Integer> a = new LenketMengde<>();
        LenketMengde<Integer> b = new LenketMengde<>();

        a.leggTil(1);
        a.leggTil(2);

        b.leggTil(1);
        b.leggTil(2);
        b.leggTil(3);

        assertTrue(a.erDelmengdeAv(b));
        assertFalse(b.erDelmengdeAv(a));
    }

    @Test
    public void testErLik() {
        LenketMengde<Integer> a = new LenketMengde<>();
        LenketMengde<Integer> b = new LenketMengde<>();

        a.leggTil(1);
        a.leggTil(2);

        b.leggTil(2);
        b.leggTil(1);

        assertTrue(a.erLik(b));

        b.leggTil(3);
        assertFalse(a.erLik(b));
    }

    @Test
    public void testErDisjunkt() {
        LenketMengde<Integer> a = new LenketMengde<>();
        LenketMengde<Integer> b = new LenketMengde<>();

        a.leggTil(1);
        a.leggTil(2);

        b.leggTil(3);
        b.leggTil(4);

        assertTrue(a.erDisjunkt(b));

        b.leggTil(2);
        assertFalse(a.erDisjunkt(b));
    }

    @Test
    public void testSnitt() {
        LenketMengde<Integer> a = new LenketMengde<>();
        LenketMengde<Integer> b = new LenketMengde<>();

        a.leggTil(1);
        a.leggTil(2);
        a.leggTil(3);

        b.leggTil(2);
        b.leggTil(3);
        b.leggTil(4);

        MengdeADT2<Integer> snitt = a.snitt(b);

        assertTrue(snitt.inneholder(2));
        assertTrue(snitt.inneholder(3));
        assertFalse(snitt.inneholder(1));
    }

    @Test
    public void testUnion() {
        LenketMengde<Integer> a = new LenketMengde<>();
        LenketMengde<Integer> b = new LenketMengde<>();

        a.leggTil(1);
        a.leggTil(2);

        b.leggTil(2);
        b.leggTil(3);

        MengdeADT2<Integer> union = a.union(b);

        assertTrue(union.inneholder(1));
        assertTrue(union.inneholder(2));
        assertTrue(union.inneholder(3));
        assertEquals(3, union.antallElementer());
    }

    @Test
    public void testMinus() {
        LenketMengde<Integer> a = new LenketMengde<>();
        LenketMengde<Integer> b = new LenketMengde<>();

        a.leggTil(1);
        a.leggTil(2);
        a.leggTil(3);

        b.leggTil(2);

        MengdeADT2<Integer> resultat = a.minus(b);

        assertTrue(resultat.inneholder(1));
        assertTrue(resultat.inneholder(3));
        assertFalse(resultat.inneholder(2));
    }

    @Test
    public void testTilTabell() {
        LenketMengde<Integer> m = new LenketMengde<>();

        m.leggTil(1);
        m.leggTil(2);

        Integer[] tabell = m.tilTabell();

        assertEquals(2, tabell.length);
    }

    @Test
    public void testLeggTilAlleFra() {
        LenketMengde<Integer> a = new LenketMengde<>();
        LenketMengde<Integer> b = new LenketMengde<>();

        a.leggTil(1);
        b.leggTil(2);
        b.leggTil(3);

        a.leggTilAlleFra(b);

        assertTrue(a.inneholder(1));
        assertTrue(a.inneholder(2));
        assertTrue(a.inneholder(3));
    }
}
