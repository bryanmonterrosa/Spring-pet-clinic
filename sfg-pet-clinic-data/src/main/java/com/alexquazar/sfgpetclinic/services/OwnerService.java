package com.alexquazar.sfgpetclinic.services;

import com.alexquazar.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    
    Owner findByLastName(String lastName);

}
