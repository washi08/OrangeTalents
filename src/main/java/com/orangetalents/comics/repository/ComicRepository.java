package com.orangetalents.comics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents.comics.datasource.model.Comic;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long>{
}
