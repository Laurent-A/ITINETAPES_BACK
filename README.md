# ITINETAPES_BACK
PROJET EN JAVA SPRING BOOT / MYSQL

## GIT COMMANDE :

- voir les branches :" `git branch`"
- passer sur une branche : "`git checkout nomDeBranche`"
- Savoir sur quelle branche on est : "`git status`"

-------------------------
GIT INSTALLATION :
- Recupérer le git : "`git clone urlDuFichier`"

-------------------------
ENVOYER SON CODE SUR GIT :
- ajouter le fichier : "`git add .`"
- commit : "`git commit -m "titreDeMonCommit"`"
- push : "`git push`"
----------------------
LES BRANCHES EXISTANTES ACTUELLEMENT (on les modifiera si besoin)

  - BACK_FRED
  - BACK_LAURENT
  - BACK_SEYNABOU
  - master

## MISE EN PLACE ENVIRONNEMENT

- Cloner le git
- importer le projet dans maven
- Lancer le maven update

- Dans le fichier src/main/resources/application.properties, ajouter le code suivant :

`server.port 9090

spring.datasource.url = jdbc:mysql://localhost:3306/randonnee?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username = root
spring.datasource.password = root

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

spring.jpa.hibernate.ddl-auto = none
`

puis lancer l'application en tant que spring boot app

## SWAGGER

Pour voir la documentation API : (lancer le serveur avant)
http://localhost:9090/swagger-ui.html#/