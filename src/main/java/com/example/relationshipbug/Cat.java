package com.example.relationshipbug;

import org.springframework.data.neo4j.core.schema.Node;

@Node(primaryLabel = "TheCat")
public class Cat extends AbstractCat {
}
