package com.example.api.controllers;


import com.example.api.models.Candidat;
import com.example.api.repositories.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api/candidats")
public class CandidatController {

    @Autowired
    private CandidatRepository candidatRepository;

    @GetMapping(value= "/")
    List<Candidat> all() {
        return candidatRepository.findAll();
    }

    @GetMapping(value="/{candidat}")
    Candidat getOne(@PathVariable(name= "candidat", required = false) Candidat candidat)  {
            if (candidat == null) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Candidat introuvable"
                );
            }
            else {
                return candidat;
            }
    }

    @PostMapping(value= "/")
    public ResponseEntity<Candidat> saveCandidat(@Valid @RequestBody Candidat candidat, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
        }
        else {
            candidatRepository.save(candidat);
            return new ResponseEntity<Candidat>(candidat, HttpStatus.CREATED);
        }
    }
    @PutMapping(value= "/{candidat}")
    public ResponseEntity<Candidat> update(@PathVariable(name= "candidat", required = true) Candidat candidat,
                                           @Valid @RequestBody Candidat candidatUpdate, BindingResult bindingResult ) {

        if (candidat == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Candidat introuvable"
            );
        }
        else {
            if (bindingResult.hasErrors()){
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Candidat introuvable"
                );
            } else {
                candidatUpdate.setId(candidat.getId());
                candidatRepository.save(candidatUpdate);
                return new ResponseEntity<Candidat>(candidat, HttpStatus.OK);
            }

        }
    }

    @DeleteMapping(value="/{candidat}")
    public void deleteOne(@PathVariable(name= "candidat", required = true) Candidat candidat) {
        if (candidat == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Candidat introuvable"
            );
        }
        else {
            candidatRepository.delete(candidat);
        }
    }

}
