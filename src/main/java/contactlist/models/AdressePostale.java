package contactlist.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class AdressePostale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*
    private String name;

    @ManyToMany
    @JoinTable(name = "habiter")
    private List<Contact> proprietaires;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getProprietaires() {
        return proprietaires;
    }

    public void setProprietaires(List<Contact> proprietaires) {
        this.proprietaires = proprietaires;
    }

     */
}
