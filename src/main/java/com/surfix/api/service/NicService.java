package com.surfix.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surfix.api.models.Machine;
import com.surfix.api.models.Nic;
import com.surfix.api.repository.MachineRepository;
import com.surfix.api.repository.NicRepository;

@Service
public class NicService {
  @Autowired
  private MachineRepository machineRepository;
  @Autowired
  private NicRepository nicRepository;

  public void create(Long machineId, Nic req) {

    /* Optional<Machine> */
    Machine machine = machineRepository.findById(machineId).orElseThrow();

    req.setMachine(machine);
    nicRepository.save(req);

    machine.addNic(req);
    machineRepository.save(machine);

  }

  public void remove(Long nicId) {
    nicRepository.deleteById(nicId);
  }

}
