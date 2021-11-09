package com.example.api.repositories;

import com.example.api.models.Candidat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatRepository extends CrudRepository<Candidat, Long> {
    @Override
    List<Candidat> findAll();
}
