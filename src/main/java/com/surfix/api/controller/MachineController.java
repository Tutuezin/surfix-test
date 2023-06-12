package com.surfix.api.controller;

import com.surfix.api.dto.MachineDTO;
import com.surfix.api.models.Machine;
import com.surfix.api.service.MachineService;

import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/machine")

public class MachineController {
   @Autowired
   private MachineService machineService;

   @GetMapping
   public List<Machine> getAll() {

      return machineService.getAll();
   }

   @PostMapping
   public ResponseEntity<Object> create(@RequestBody MachineDTO req) {

      Machine machineData = machineService.create(new Machine(req));

      return ResponseEntity.status(HttpStatus.CREATED).body(machineData);

   }

   @PutMapping("/{machineId}")
   public ResponseEntity<Null> updateMachine(@PathVariable Long machineId) {

      machineService.updateMachine(machineId);

      return ResponseEntity.status(HttpStatus.OK).body(null);
   }

}
