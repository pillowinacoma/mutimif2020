# M1IF10 Automne 2020 - Groupe 17

Réalisation  d'un système d'affichage d'événements à partir d'informations tirées des réseaux sociaux.

## Auteurs

- Jonathan RAYBAUD--SERDA
- Abdelaziz SBAAI
- Djaloud ALI MROIVILI
- Vincent PHAM
- Victor BOGHOSSIAN
- Melisya TUTOGLU

## Construction du projet

Le code du projet est contenu dans la branche `master` de ce dépôt. Pour le construire, commencer par cloner le dépôt :

```shell
git clone https://forge.univ-lyon1.fr/p1807434/multimif2020.git
```

Pour la gestion des dépendances et de la compilation, le projet utilise `Maven`. À titre indicatif, les dépendances sont (le bloc `XML` de dépendance du fichier `pom.xml` est donné en fin de ce fichier):
- `junit`
- `javaee`
- `jstl`
- `json`
- `hibernate`
- `logback-classic`
- `jaxb-api`

Pour **compiler le projet**, se placer dans le répertoire racine et taper la commande (N.B. : une installation de `maven` doit être présente sur la machine):

```shell
mvn compile
```

**Avant de déployer** sur tomcat nous allons devoir mettre en place un serveur postgresql en local, disponible [sur le wiki](../../wikis/tutos/PostgreSQL)

Le déploiement sur un serveur `tomcat` local est possible, sous résevre qu'un tel serveur soit installé (des instructions sont disponibles [sur le wiki](../../wikis/tutos/tomcatLocal)):

```shell
mvn tomcat7:redeploy
```


## Machine virtuelle de démonstration

Le projet est accessible sur une machine de démonstration à l'adresse http://192.168.74.218:8080/v1/user

## Addendum 1 - Dépendances pour le `pom.xml`

```xml
<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.7.0-M1</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>javax</groupId>
    <artifactId>javaee-web-api</artifactId>
    <version>8.0.1</version>
    <scope>provided</scope>
  </dependency>
  <dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
  </dependency>
  <dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20200518</version>
  </dependency>
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.2.18</version>
  </dependency>
  <dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>5.2.2.Final</version>
  </dependency>
  <dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.1.2</version>
  </dependency>
  <dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.2.11</version>
  </dependency>
</dependencies>
```
