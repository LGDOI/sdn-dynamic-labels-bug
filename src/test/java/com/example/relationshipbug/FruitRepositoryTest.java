package com.example.relationshipbug;

import java.util.List;
import java.util.Set;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FruitRepositoryTest {
  private final FruitRepository fruitRepository;

  @Autowired FruitRepositoryTest(FruitRepository fruitRepository) {
    this.fruitRepository = fruitRepository;
  }

  @BeforeEach
  void setup() {
    fruitRepository.deleteAll();
  }

  @Test
  void findFruits() {
    Apple apple = new Apple();
    apple.setVolume(1.0);
    apple.setColor("Red");
    apple.setLabels(Set.of("Apple_1"));

    Apple apple2 = new Apple();
    apple2.setVolume(5.0);
    apple2.setColor("Blue");

    Orange orange = new Orange();
    orange.setVolume(2.0);
    orange.setColor("Yellow");
    orange.setLabels(Set.of("Orange_2"));

    Orange orange2 = new Orange();
    orange2.setVolume(2.0);
    orange2.setColor("Pink");

    fruitRepository.saveAll(List.of(apple, apple2, orange, orange2));

    var fruits = fruitRepository.findAll();

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(fruits.stream().filter(Apple.class::isInstance)).hasSize(2);
    softly.assertThat(fruits.stream().filter(Orange.class::isInstance)).hasSize(2);
    softly.assertAll();
  }
}

