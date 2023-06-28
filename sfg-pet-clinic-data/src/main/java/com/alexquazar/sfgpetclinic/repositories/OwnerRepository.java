package com.alexquazar.sfgpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alexquazar.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
    Owner findByLastName(String lastName);

    List<Owner> findByLastNameContainingIgnoreCase(String lastName);
}
