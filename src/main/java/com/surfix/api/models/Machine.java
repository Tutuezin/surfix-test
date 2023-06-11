package com.surfix.api.models;

import java.util.ArrayList;
import java.util.List;

import com.surfix.api.dto.MachineDTO;
import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "machine")
@Data
@Entity
@NoArgsConstructor

public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer memory;

    private Integer vcpu;

    private Boolean state;

    @OneToMany(mappedBy = "machine")
    private List<Disk> disks = new ArrayList<>();

    @OneToMany(mappedBy = "machine")
    private List<Nic> nics = new ArrayList<>();

    public Machine(MachineDTO req) {
        this.name = req.getName();
        this.memory = req.getMemory();
        this.vcpu = req.getVcpu();
        this.state = req.getState();
        this.disks = req.getDisks();
        this.nics = req.getNics();

    }

    public void addDisk(Disk disk){
        disks.add(disk);
    }

    public void addNic(Nic nic){
        nics.add(nic);
    }

}
