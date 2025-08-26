# aerow_dev_training

Le projet pour s'améliorer au développement par trois axes : 
- le tdd (Test Driven Development) : ou comment aller au cinéma voir son algorithme se dessiner
- la programmation fonction : ou comment changer de paradigme
- la clean architecture : ou comment être un petit chef et laisser les autres s'adapter à toi

## Prérequis

- Avoir installé [java 24](https://jdk.java.net/24/)
- Posséder un IDE par exemple [Intellij](https://www.jetbrains.com/idea/download). Il est recommandé de prendre un IDE
que vous maîtrisez
- Avoir des bases en Java (c'est plus sympa pour apprendre)

## Pour compiler

```bash
./gradlew clean build # sans "clean" est possible aussi si on veut gagner en rapidité
```

## Pour tester à tout moment

Bien que vous puissiez utiliser la commande **Gradle** ci-dessus, vous pouvez tout simplement utiliser votre éditeur pour
notamment exécuter les tests unitaires très rapidement.

![tu.png](documentation/images/tu.png)

## Pour voir la solution

Il y a un moyen d'accéder à certaines solutions mais cela sera incrémental:

```bash
git switch Problem1 # permet d'accéder à la solution du problème 1
git switch Problem2 # permet d'accéder à la solution du problème 2 et du problème 1 etc...

git branch -av # voir toutes les branches (et ainsi toutes les solutions)

git switch solution # pour tout avoir, cette branche bouge régulièrement, ne soyez pas surpris
```

## Auteur

Quang-Minh TRAN (Aerow)
