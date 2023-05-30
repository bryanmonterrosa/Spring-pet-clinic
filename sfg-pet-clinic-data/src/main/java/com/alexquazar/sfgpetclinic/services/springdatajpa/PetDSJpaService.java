package com.alexquazar.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import com.alexquazar.sfgpetclinic.model.Pet;
import com.alexquazar.sfgpetclinic.repositories.PetRepository;
import com.alexquazar.sfgpetclinic.services.PetService;

public class PetDSJpaService implements PetService {
    private final PetRepository petRepository;

    public PetDSJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

}
