package com.alexquazar.sfgpetclinic.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alexquazar.sfgpetclinic.model.Owner;
import com.alexquazar.sfgpetclinic.model.Pet;
import com.alexquazar.sfgpetclinic.model.PetType;
import com.alexquazar.sfgpetclinic.services.OwnerService;
import com.alexquazar.sfgpetclinic.services.PetService;
import com.alexquazar.sfgpetclinic.services.PetTypeService;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {

    @Mock
    PetService petService;

    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    PetController petController;

    MockMvc mockMvc;

    Owner owner;
    Pet pet;
    Set<PetType> petTypes;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1l).build();
        pet = Pet.builder().id(1l).name("name").build();

        petTypes = new HashSet<>();
        petTypes.add(PetType.builder().id(1l).name("Dog").build());
        petTypes.add(PetType.builder().id(2l).name("Cat").build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(petController)
                .build();
    }

    @Test
    void initCreationForm() throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(get("/owners/1/pets/new"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("owner"))
            .andExpect(model().attributeExists("pet"))
            .andExpect(model().attributeExists("types"))
            .andExpect(view().name("pets/createOrUpdatePetForm"));

           

    }

    @Test
    void processCreationForm() throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/new"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(any());
    }

    @Test
    void initUpdateForm() throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(1l).build());

        mockMvc.perform(get("/owners/1/pets/2/edit"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("owner"))
            .andExpect(model().attributeExists("pet"))
            .andExpect(model().attributeExists("types"))
            .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processUpdateForm() throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(1l).name("name").build());

        mockMvc.perform(post("/owners/1/pets/2/edit").flashAttr("pet",pet))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(any());
    }
}
