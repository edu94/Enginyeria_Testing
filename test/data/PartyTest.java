package data;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartyTest {

    static Party party;

    static {
        try {
            party = new Party("Podemos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void NameTest() throws Exception {
        Party C = new Party ("Ciudadanos");
        Party P = new Party ("Podemos");

        assertNotEquals(party.getName(), "Ciudadanos");
        assertEquals(party.getName(), "Podemos");
        assertEquals(party.equals(P),true);
        assertEquals(party.equals(C),false);
        assertEquals(party.equals(null),false);
        assertEquals(party.equals("c"),false);
        assertEquals(party.equals(""),false);

    }

    @Test
    public void HashCodeTest() throws Exception {
        Party P = new Party ("Podemos");
        assertTrue(party.hashCode()==P.hashCode());
    }

    @Test
    public void ToStringTest() throws Exception{
        assertEquals(party.toString(),"Party{name='Podemos'}");
    }

}