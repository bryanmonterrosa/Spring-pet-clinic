package com.alexquazar.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexquazar.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long>{
    
}
