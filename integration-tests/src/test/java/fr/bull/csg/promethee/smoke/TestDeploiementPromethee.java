// -----------------------------------------------------------------------------
// Projet : Phebus
// Client : Pole Emploi
// Auteur : Bull S.A.S.
// Id SVN : $Id$
// -----------------------------------------------------------------------------
package fr.bull.csg.promethee.smoke;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Thomas Gueze
 */
public class TestDeploiementPromethee
{
   private String prometheeURL;

   @Before
   public void initialisationEnvironnement()
   {
      String host = System.getProperty("http.host");
      String port = System.getProperty("http.port");

      this.prometheeURL = "http://" + host + ':' + port + "/promethee-1.0-SNAPSHOT";
   }
   
   @Test
   public void deploiementWebAppPrometheeOk() throws URISyntaxException, IOException
   {
      URLConnection urlConnection = new URL(prometheeURL).openConnection();

      Assert.assertEquals(200, ((HttpURLConnection) urlConnection).getResponseCode());
   }
}
