package com.example.relationshipbug;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Cat extends Animal<Catnip> {
}
