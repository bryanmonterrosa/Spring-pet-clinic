package com.alexquazar.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexquazar.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
    
}
