package com.example.relationshipbug;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@NoArgsConstructor
@Node
//public abstract class MagicalFruit extends Fruit {
public abstract class MagicalFruit extends Fruit {
  @Property
  private double volume;

  @Property
  private String color;
}
