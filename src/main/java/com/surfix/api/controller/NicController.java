package com.surfix.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surfix.api.models.Nic;
import com.surfix.api.service.NicService;

import jakarta.validation.constraints.Null;

@RestController
@RequestMapping("/api/nic")
public class NicController {
  @Autowired
  private NicService nicService;

  @PostMapping("/{machineId}")
  public ResponseEntity<Null> addNic(@PathVariable Long machineId, @RequestBody Nic req) {

    nicService.create(machineId, req);

    return ResponseEntity.status(HttpStatus.CREATED).body(null);

  }

  @DeleteMapping("/{nicId}")
  public ResponseEntity<Null> removeNic(@PathVariable Long nicId) {

    nicService.remove(nicId);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

  }
}
