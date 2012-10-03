package poc.jee6.skillz.services;

import java.util.Collection;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import poc.jee6.skillz.model.Collaborateur;

@Singleton
@Named("collaborateurService")
public class CollaborateurService {

    @PersistenceContext
    EntityManager em;

    public Collection<Collaborateur> getCollaborateurs() {
        return em.createQuery("select c from Collaborateur c").getResultList();
    }
}
