package com.alexquazar.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexquazar.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
