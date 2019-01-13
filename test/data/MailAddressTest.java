package data;


import org.junit.Test;

import static org.junit.Assert.*;

public class MailAddressTest {
    static MailAddress mail;

    static {
        try {
            mail = new MailAddress("test@test.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void NameTest() throws Exception {
        MailAddress email = new MailAddress ("test@test.com");
        MailAddress new_email = new MailAddress ("new_email@test.com");

        assertNotEquals(mail.getMail(), "new_email@test.com");
        assertEquals(mail.getMail(), "test@test.com");
        assertEquals(mail.equals(email),true);
        assertEquals(mail.equals(new_email),false);
        assertEquals(mail.equals(null),false);
        assertEquals(mail.equals("ERC"),false);
        assertEquals(mail.equals(""),false);

    }

    @Test
    public void HashCodeTest() throws Exception {
        MailAddress email = new MailAddress ("test@test.com");
        assertTrue(mail.hashCode()==email.hashCode());
    }

    @Test
    public void ToStringTest() throws Exception {
        assertEquals(mail.toString(),"MailAddress{mail='test@test.com'}");
    }



}