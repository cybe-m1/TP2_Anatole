package tp2.anatole.personneweb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String name, firstname;

    @Override
    public String toString() {
        return this.name + " " + this.firstname + " (" + this.id + ")\n";
    }
}
