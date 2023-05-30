package com.alexquazar.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexquazar.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
