package com.example.exemplo_data_rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "testes", collectionResourceRel = "testes")
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
