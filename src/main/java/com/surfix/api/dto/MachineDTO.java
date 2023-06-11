package com.surfix.api.dto;

import java.util.List;

import com.surfix.api.models.Disk;
import com.surfix.api.models.Nic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MachineDTO(String name, Integer memory, Integer vcpu, Boolean state, @NotNull @NotBlank List<Disk> disks,
    @NotNull @NotBlank List<Nic> nics) {
}

/* Outra forma de fazer o DTO sem record */
/*
 * @Data
 * public class MachineDTO {
 * private String name;
 * private Integer memory;
 * private Integer vcpu;
 * private Boolean state;
 * 
 * @NotNull
 * 
 * @NotBlank
 * private List<Disk> disks;
 * 
 * @NotNull
 * 
 * @NotBlank
 * private List<Nic> nics;
 * }
 */