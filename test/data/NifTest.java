package data;

import org.junit.Test;

import static org.junit.Assert.*;

public class NifTest {

    @Test
    public void TestEquals() throws Exception {
        Nif edu1 = new Nif ("48051879A");
        Nif edu2 = new Nif ("48051879A");
        Nif joan = new Nif ("47980451J");

        assertFalse(edu1.equals(joan));
        assertTrue(edu1.equals(edu1));
        assertTrue(edu1.equals(edu2));
    }

    @Test
    public void TestHashCode() throws Exception{
        Nif edu1 = new Nif("48051879A");
        Nif edu2 = new Nif("48051879A");
        assertTrue(edu1.hashCode()==edu2.hashCode());

    }

    @Test
    public void TestToString() throws Exception{
        Nif joan = new Nif ("47980451J");
        String expected="Nif{nif='" +joan.getNif()+ "'}";
        assertEquals(expected,joan.toString());
    }

}