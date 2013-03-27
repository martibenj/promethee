package fr.bull.csg.promethee.helpers;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextHelper
{
   /** Application Context Spring. */
   private ApplicationContext context;

   /**
    * Constructeur affectant l'AC Spring.
    * @param servletContext Servlet d'origine
    */
   public SpringContextHelper(ServletContext servletContext)
   {
      context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
   }

   /**
    * Utilitaire permettant de récupérer à la demande un Bean.
    * @param beanRef Nom du bean à récupérer dans Spring
    * @return Le bean instancié
    * @deprecated Utilise de préférence l'autowire par déclaration dans les classes
    */
   public Object getBean(final String beanRef)
   {
      return context.getBean(beanRef);
   }
}