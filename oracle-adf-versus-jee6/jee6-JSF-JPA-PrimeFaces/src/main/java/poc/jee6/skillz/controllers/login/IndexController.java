package poc.jee6.skillz.controllers.login;

import poc.jee6.skillz.services.CollaborateurService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Statefull session bean.
 *
 * @author snichele
 */
@Named("indexController")
@SessionScoped
@Slf4j
@Getter
@Setter
public class IndexController implements Serializable {

    @Inject
    transient CollaborateurService service;
    private String searchTerm;

    public List<String> complete(String query) {
        List<String> results = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            results.add(query + i);
        }

        return results;
    }
}
