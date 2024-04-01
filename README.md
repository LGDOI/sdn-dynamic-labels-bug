# sdn-dynamic-labels-bug

[SDN](https://github.com/spring-projects/spring-data-neo4j) is unable to instantiate nodes with multiple levels of
inheritance and a non-empty `@DynamicLabels` field.

For example, say you have a super class

    @Getter
    @Node
    public abstract class Fruit {
      @DynamicLabels
      private Set<String> labels = Set.of();
    }

A sub class

    @Node
    public class MagicalFruit extends Fruit {
    }

And a sub class of the sub class

    @Node
    public class Apple extends MagicalFruit {
    }

You can query for instances of the `Apple` sub class only if they do not have a dynamic label


    Apple apple1 = new Apple();
    fruitRepository.save(apple1);

    Apple apple2 = new Apple();
    fruitRepository.save(apple2);
    apple2.setLabels(Set.of("Delicious_1));
    fruitRepository.save(apple2);

    var fruits = fruitRepository.findAll();
    
    // This assertion fails because apple2 becomes a MagicalFruit instance.
    assertThat(fruits.stream().filter(Apple.class::isInstance)).hasSize(2);

The same test pass if the `MagicalFruit` sub class is an abstract class.


## Requirements

Don't forget to set database credentials in [application.properties](src/main/resources/application.properties).

## Tests

Run [tests](src/test/java/com/example/relationshipbug/FruitRepositoryTest.java) via `mvn clean install` or via an IDE.

