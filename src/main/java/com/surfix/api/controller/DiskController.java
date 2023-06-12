package com.surfix.api.controller;

import com.surfix.api.models.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.surfix.api.dto.DiskDTODecrement;
import com.surfix.api.dto.DiskDTOIncrement;
import com.surfix.api.models.Disk;
import com.surfix.api.service.DiskService;

import jakarta.validation.constraints.Null;
@CrossOrigin
@RestController
@RequestMapping("/api/disk")

public class DiskController {
  @Autowired
  private DiskService diskService;
  @PostMapping("/{machineId}")
  public ResponseEntity<Object> addDisk(@PathVariable Long machineId, @RequestBody Disk req) {

    diskService.create(machineId, req);

    return ResponseEntity.status(HttpStatus.CREATED).body(req);

  }

  @DeleteMapping("/{diskId}")
  public ResponseEntity<Null> removeDisk(@PathVariable Long diskId) {

    diskService.remove(diskId);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

  }

  @PutMapping("/{diskId}/increment")
  public ResponseEntity<Object> updateDisk(@PathVariable Long diskId, @RequestBody DiskDTOIncrement req) {

    diskService.increment(diskId, req);

    return ResponseEntity.status(HttpStatus.OK).body(req);

  }

  @PutMapping("/{diskId}/decrement")
  public ResponseEntity<Null> updateDisk(@PathVariable Long diskId, @RequestBody DiskDTODecrement req) {

    diskService.decrement(diskId, req);

    return ResponseEntity.status(HttpStatus.OK).body(null);

  }
}
