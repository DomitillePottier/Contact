package contactlist.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class AdresseMail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*
    @NotNull
    private String name;

    @OneToOne
    @NotNull
    private Contact proprietaire;
    */
}
