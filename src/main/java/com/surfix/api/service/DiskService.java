package com.surfix.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surfix.api.dto.DiskDTODecrement;
import com.surfix.api.dto.DiskDTOIncrement;
import com.surfix.api.models.Disk;
import com.surfix.api.models.Machine;
import com.surfix.api.repository.DiskRepository;
import com.surfix.api.repository.MachineRepository;

@Service
public class DiskService {
  @Autowired
  private MachineRepository machineRepository;
  @Autowired
  private DiskRepository diskRepository;

  public void create(Long machineId, Disk req) {

    /* Optional<Machine> */
    Machine machine = machineRepository.findById(machineId).orElseThrow();

    req.setMachine(machine);
    diskRepository.save(req);
    machine.addDisk(req);
    machineRepository.save(machine);

  }

  public void remove(Long diskId) {
    diskRepository.deleteById(diskId);
  }

  public void increment(Long diskId, DiskDTOIncrement req) {

    Disk disk = diskRepository.findById(diskId).orElseThrow();

    disk.incrementDisk(req.incrementSize());
    diskRepository.save(disk);

  }

  public void decrement(Long diskId, DiskDTODecrement req) {

    Disk disk = diskRepository.findById(diskId).orElseThrow();

    disk.decrementDisk(req.decrementSize());
    diskRepository.save(disk);

  }

}
