package com.alexquazar.sfgpetclinic.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.alexquazar.sfgpetclinic.model.PetType;
import com.alexquazar.sfgpetclinic.services.PetTypeService;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();
        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }
}
