import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
    private String navn;


    public Person(String navn, Set<String> hobby) {
        this.navn = navn;
        this.hobby = new HashSet<>();

        for (String h : hobby) {
            this.hobby.add(h.toLowerCase()); // basically ignorecase
        }
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Set<String> getHobby() {
        return hobby;
    }

    public void setHobby(Set<String> hobby) {
        this.hobby = hobby;
    }

    private Set<String> hobby = new HashSet<>();
}
