Le projet est structuré de la façon suivante :

Parent :

 --> module web app : construit un war

    Pour la construction : mvn clean install
    Pour un déploiement rapide sur jetty : mvn jetty:run
     * Attention des fonctionnalités utilisant des modules JEE non disponible dans jetty peuvent bloquer le deploiement de l'application
     * Le deploiement nécessite alors d'être fait sur un serveur d'appli JEE comme jboss (voir integration-tests)

 --> module integration-tests

    Pour la construction et le passage de tests sur l'application déployée : mvn clean install
    1) Lance une base SQL H2
    2) Initialise le schéma de données de la base
    3) Configure un datasource sur jboss utilisant la base h2 précédement configuré (jboss est récupéré automatique par maven)
    4) Déploie la webapp sur jboss
