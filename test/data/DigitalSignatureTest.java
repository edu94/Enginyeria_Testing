package data;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DigitalSignatureTest {

    private DigitalSignature firma;
    private DigitalSignature repetir_firma;

    @Before
    public void initDigitalSignature() throws Exception {
        firma =new DigitalSignature("FIRMADIGITAL");
        repetir_firma = new DigitalSignature("FIRMADIGITAL");
    }

    @Test
    public void TestToString(){
        String expected = "DigitalSignature{digitalsignature='FIRMADIGITAL'}";
        assertEquals(expected, firma.toString());
    }

    @Test
    public void TestEquals(){
        assertTrue(firma.equals(firma));
        assertTrue(firma.equals(repetir_firma));

    }

    @Test
    public void TestHashCode(){
        assertTrue(firma.hashCode()== repetir_firma.hashCode());
    }


}