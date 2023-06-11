package com.surfix.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "disk")
@Data
@Entity
@NoArgsConstructor

public class Disk {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer size;
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JsonIgnore
  @JoinColumn(name = "machineId")
  private Machine machine;

  public Integer incrementDisk(Integer incrementSize) {
    size += incrementSize;
    return size;
  }

  public Integer decrementDisk(Integer decrementSize) {
    size -= decrementSize;
    return size;
  }

}
