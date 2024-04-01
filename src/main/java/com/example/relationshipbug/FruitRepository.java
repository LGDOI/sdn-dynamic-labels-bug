package com.example.relationshipbug;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FruitRepository extends Neo4jRepository<Fruit, String> {
}
