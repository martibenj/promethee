package fr.bull.csg.promethee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Un Mantis et ses informations.
 * @author Thomas Gueze
 */
@Entity
public class Mantis implements Serializable
{
   /** Serial UID. */
   private static final long serialVersionUID = 4578615519507781110L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   private Long mantis;

   private String type;

   private String description;

   private String chiffrage;

   private String consomme;

   private String etat;

   private String affecte;

   private String commentaire;

   public Integer getId()
   {
      return id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public Long getMantis()
   {
      return mantis;
   }

   public void setMantis(Long mantis)
   {
      this.mantis = mantis;
   }

   public String getType()
   {
      return type;
   }

   public void setType(String type)
   {
      this.type = type;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public String getChiffrage()
   {
      return chiffrage;
   }

   public void setChiffrage(String chiffrage)
   {
      this.chiffrage = chiffrage;
   }

   public String getConsomme()
   {
      return consomme;
   }

   public void setConsomme(String consomme)
   {
      this.consomme = consomme;
   }

   public String getEtat()
   {
      return etat;
   }

   public void setEtat(String etat)
   {
      this.etat = etat;
   }

   public String getAffecte()
   {
      return affecte;
   }

   public void setAffecte(String affecte)
   {
      this.affecte = affecte;
   }

   public String getCommentaire()
   {
      return commentaire;
   }

   public void setCommentaire(String commentaire)
   {
      this.commentaire = commentaire;
   }
}
