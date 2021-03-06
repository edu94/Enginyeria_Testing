package data;

final public class Party {

    private final String name;

    public Party(String name) throws Exception {
        if(name == null){
            throw new Exception("Name invalid");
        }
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party1 = (Party) o;
        return name.equals(party1.name);
    }

    @Override
    public int hashCode() { return name.hashCode(); }

    @Override
    public String toString() {
        return "Party{" + "name='" + name + '\'' + '}';
    }

}
