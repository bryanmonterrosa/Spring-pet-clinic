package com.alexquazar.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.alexquazar.sfgpetclinic.model.Specialty;
import com.alexquazar.sfgpetclinic.services.SpecialtiesService;

@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtiesService {

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }
   
    
}
