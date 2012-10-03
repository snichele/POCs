package poc.jee6.skillz.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import poc.jee6.skillz.utils.UIHint;

@Data
@Entity
public class Collaborateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    /**
     * Technical DB id.
     */
    private Long id;
    private String name;
    private String surname;
    /**
     * Titre du collaborateur.
     */
    @UIHint("saisie libre, auto-completion dans le UI")
    private String title;
}
