package com.alexquazar.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexquazar.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
    
}
