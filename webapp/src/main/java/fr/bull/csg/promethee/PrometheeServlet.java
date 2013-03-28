package fr.bull.csg.promethee;

import com.vaadin.server.*;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * @author Thomas Gueze
 */
public class PrometheeServlet extends VaadinServlet {

    @EJB
    private MantisEntityProvider ep;

    @SuppressWarnings("serial")
    private final SessionInitListener sessionInitListener = new SessionInitListener() {

        @Override
        public void sessionInit(SessionInitEvent event) throws ServiceException {

            @SuppressWarnings("unused")
            VaadinService service = event.getService();
            final VaadinSession session = event.getSession();

            UIProvider uiProvider = new UIProvider(ep);
            session.addUIProvider(uiProvider);

        }
    };

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        getService().addSessionInitListener(sessionInitListener);
    }
}
