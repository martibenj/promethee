package fr.bull.csg.promethee;

import com.vaadin.server.*;
import fr.bull.csg.promethee.persistence.MantisEntityProvider;
import fr.bull.csg.promethee.ui.MantisUIProvider;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * @author Thomas Gueze
 */
public class PrometheeServlet extends VaadinServlet {

    /**
     * Injection de l'ejb stateless servant à faire les requêtes sur la table mantis
     */
    @EJB
    private MantisEntityProvider mantisEntityProvider;

    @SuppressWarnings("serial")
    private final SessionInitListener sessionInitListener = new SessionInitListener() {

        @Override
        public void sessionInit(SessionInitEvent event) throws ServiceException {

            @SuppressWarnings("unused")
            VaadinService service = event.getService();
            final VaadinSession session = event.getSession();

            UIProvider uiProvider = new MantisUIProvider(mantisEntityProvider);
            session.addUIProvider(uiProvider);
        }
    };

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        getService().addSessionInitListener(sessionInitListener);
    }
}
