package com.example.relationshipbug;

import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.DynamicLabels;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
@NoArgsConstructor
@Node
public abstract class Fruit {

  @Id
  protected String id;

  @DynamicLabels
  protected Set<String> labels = Set.of();
}
