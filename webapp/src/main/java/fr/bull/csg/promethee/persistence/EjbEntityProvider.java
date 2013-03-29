package fr.bull.csg.promethee.persistence;

import com.vaadin.addon.jpacontainer.provider.MutableLocalEntityProvider;

import javax.annotation.PostConstruct;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Surcharge l'entity provider par défaut pour utiliser le moniteur transactionnel du conteneur EJB
 * Par défaut l'entity provider inclut la gestion de la transaction ce qui ne permet pas d'utiliser
 * les ressources du serveur d'application
 * @author Thomas Gueze
 */
@TransactionManagement
public abstract class EjbEntityProvider<T> extends MutableLocalEntityProvider<T> {

    @PersistenceContext
    private EntityManager em;

    protected EjbEntityProvider(Class entityClass) {
        super(entityClass);
    }

    @PostConstruct
    public void init() {
        // On spécife bien que la gsetion de la transaction est faite par un élement externe
        setTransactionsHandledByProvider(false);
        setEntityManager(em);
    }

    // Methode utilisé pour exécuter l'operation dans une transaction
    // Le moniteur transactionnel EJB étant utilisé,
    // il faut spécifier l'annotation TransactionAttribute pour que le conteneur EJB l'execute dans une transaction
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    protected void runInTransaction(Runnable operation) {
        super.runInTransaction(operation);
    }
}
