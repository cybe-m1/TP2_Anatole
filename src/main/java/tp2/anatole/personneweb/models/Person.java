package tp2.anatole.personneweb.models;

public class Person {
    private int id;
    private String name, firstname;

    public Person(int id, String name, String firstname) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return this.name + " " + this.firstname + " (" + this.id + ")\n";
    }
}
