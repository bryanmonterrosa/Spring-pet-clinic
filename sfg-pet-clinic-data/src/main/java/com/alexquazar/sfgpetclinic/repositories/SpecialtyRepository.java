package com.alexquazar.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexquazar.sfgpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
    
}
