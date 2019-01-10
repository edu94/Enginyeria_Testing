package data;

final public class MailAddress {
    private final String mail;
    public MailAddress(String mail) throws Exception {
        if(mail == null){
            throw new Exception("MailAdress invalid");
        }
        this.mail = mail;
    }

    public String getMail() { return mail; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAddress mail1 = (MailAddress) o;
        return mail.equals(mail1.mail);
    }

    @Override
    public int hashCode() { return mail.hashCode(); }

    @Override
    public String toString() {
        return "MailAddress{" + "mail='" + mail + '\'' + '}';
    }

}
