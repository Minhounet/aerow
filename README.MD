# aerow_dev_training

Le projet comme support de formation pour s'améliorer au développement par trois axes : 
- le tdd (Test Driven Development) : ou comment aller au cinéma voir son algorithme se dessiner
- la programmation fonction : ou comment changer de paradigme
- la clean architecture : ou comment être un petit chef et laisser les autres s'adapter à toi

## Prérequis

- Avoir installé [java 24](https://jdk.java.net/24/)
- Posséder un IDE par exemple [Intellij](https://www.jetbrains.com/idea/download). Il est recommandé de prendre un IDE
que vous maîtrisez
- Avoir des bases en Java (c'est plus sympa pour apprendre)
- Posséder git pour cloner le projet

## Pour compiler

```bash
# cloner ce projet
git clone https://github.com/Minhounet/aerow.git
# Compiler le 
./gradlew clean build # sans "clean" est possible aussi si on veut gagner en rapidité
```

## Pour tester à tout moment

Bien que vous puissiez utiliser la commande **Gradle** ci-dessus, vous pouvez tout simplement utiliser votre éditeur pour
notamment exécuter les tests unitaires très rapidement.

![tu.png](documentation/images/tu.png)

## Les exercices

### TDD

Voir les classes ci-dessous :
- [Problem0.java](src/main/java/com/aerow/training/day1/Problem0.java)
- [Problem1.java](src/main/java/com/aerow/training/day1/Problem1.java)
- [Problem2.java](src/main/java/com/aerow/training/day1/Problem2.java)
- [Problem3Legacy.java](src/main/java/com/aerow/training/day1/Problem3Legacy.java)

### Programmation fonctionnelle

Voir les classes ci-dessous :
- [Problem4.java](src/main/java/com/aerow/training/day1/Problem4.java)
- [Problem5.java](src/main/java/com/aerow/training/day1/Problem5.java)
- [Problem6.java](src/main/java/com/aerow/training/day1/Problem6.java)
- [Problem7.java](src/main/java/com/aerow/training/day1/Problem7.java)

### vavr

La super bibliothèque fonctionnelle, voir [Problem8.java](src/main/java/com/aerow/training/day1/Problem8.java)

### Clean Architecture

Voir le package [example](src/main/java/com/aerow/training/day2/example) qui montre le usecase vu en
formation.

Il y a actuellement une seule implémentation [InMemoryPDFRequestRepository.java](src/main/java/com/aerow/training/day2/example/infra/inmemory/InMemoryPDFRequestRepository.java)
pour [PDFRequestRepository.java](src/main/java/com/aerow/training/day2/example/core/usecase/repository/PDFRequestRepository.java).

Mais vous constatez dans [DefaultSubmitDocumentForPDFGenerationUseCase.java](src/main/java/com/aerow/training/day2/example/core/usecase/DefaultSubmitDocumentForPDFGenerationUseCase.java)
qu'on a déjà notre cas métier codé sans avoir de réelles implémentations.

### Votre vrai projet

Voir Voir [day2and3](src/main/java/com/aerow/training/day2and3)

Vous devez implémenter deux choses :

#### Accepter un mot

Voir [IngestWordUseCase.java](src/main/java/com/aerow/training/day2and3/core/usecase/IngestWordUseCase.java) : 
- Vous devez stocker le mot dans une base avec, un identifiant unique, le mot lui-même et sa taille.
- Vous devez renvoyer l'identifiant

#### Récupérer tous les mots

Voir [GetAllWordsUseCase.java](src/main/java/com/aerow/training/day2and3/core/usecase/GetAllWordsUseCase.java)
- Vous devez renvoyer tous les mots de la base avec identifiant,le mot et sa taille

#### Pour lancer le projet
[Application.java](src/main/java/com/aerow/training/day2and3/configuration/spring/Application.java)

Ou sinon en ligne de commande
```bash
./gradlew bootRun
```

Et aller sur http://localhost:8080/swagger-ui/index.html pour tester vos webservices, mais n'oubliez pas que vous n'avez
théoriquement pas besoin de les lancer pour coder vos cas métiers qui peuvent être testés unitairement et avec des mocks !

#### Bonus

Si vous avez le temps, mettez du H2 (base de données), rajouter une fonctionnalité de feature flag
pour activer ou pas l'action de créer un mot

### Pour voir les solutions

Il y a un moyen d'accéder à certaines solutions mais cela sera incrémental:

```bash
git switch Problem1 # permet d'accéder à la solution du problème 1
git switch Problem2 # permet d'accéder à la solution du problème 2 et du problème 1 etc...

git branch -av # voir toutes les branches (et ainsi toutes les solutions)

git switch solution # pour tout avoir, cette branche bouge régulièrement, ne soyez pas surpris
```

## Auteur

Quang-Minh TRAN (Aerow)
