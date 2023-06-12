package com.surfix.api.service;

import com.surfix.api.models.Disk;
import com.surfix.api.models.Machine;
import com.surfix.api.models.Nic;
import com.surfix.api.repository.DiskRepository;
import com.surfix.api.repository.MachineRepository;
import com.surfix.api.repository.NicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private DiskRepository diskRepository;
    @Autowired
    private NicRepository nicRepository;

    public List<Machine> getAll() {
        return machineRepository.findAll();
    }

    public Machine create(Machine req) {

        Machine createMachine = new Machine();
        createMachine.setName(req.getName());
        createMachine.setMemory(req.getMemory());
        createMachine.setVcpu(req.getVcpu());
        createMachine.setState(req.getState());

        for (Disk disk : req.getDisks()){
            disk.setMachine(createMachine);
            Disk saveDisk = diskRepository.save(disk);
            createMachine.addDisk(saveDisk);
        }

        for (Nic nic : req.getNics()) {
            nic.setMachine(createMachine);
            Nic saveNic = nicRepository.save(nic);
            createMachine.addNic(saveNic);
        }

        return machineRepository.save(createMachine);
    }

    public void updateMachine(Long machineId) {
        Machine machine = machineRepository.findById(machineId).orElseThrow();

        machine.setState(!machine.getState());
        machineRepository.save(machine);
    }
}
