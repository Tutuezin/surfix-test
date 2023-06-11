package com.surfix.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surfix.api.dto.DiskDTODecrement;
import com.surfix.api.dto.DiskDTOIncrement;
import com.surfix.api.models.Disk;
import com.surfix.api.service.DiskService;

import jakarta.validation.constraints.Null;

@RestController
@RequestMapping("/api/disk")

public class DiskController {
  @Autowired
  private DiskService diskService;

  @PostMapping("/{machineId}")
  public ResponseEntity<Null> addDisk(@PathVariable Long machineId, @RequestBody Disk req) {

    diskService.create(machineId, req);

    return ResponseEntity.status(HttpStatus.CREATED).body(null);

  }

  @DeleteMapping("/{diskId}")
  public ResponseEntity<Null> removeDisk(@PathVariable Long diskId) {

    diskService.remove(diskId);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

  }

  @PutMapping("/{diskId}/increment")
  public ResponseEntity<Null> updateDisk(@PathVariable Long diskId, @RequestBody DiskDTOIncrement req) {

    diskService.increment(diskId, req);

    return ResponseEntity.status(HttpStatus.OK).body(null);

  }

  @PutMapping("/{diskId}/decrement")
  public ResponseEntity<Null> updateDisk(@PathVariable Long diskId, @RequestBody DiskDTODecrement req) {

    diskService.decrement(diskId, req);

    return ResponseEntity.status(HttpStatus.OK).body(null);

  }
}
