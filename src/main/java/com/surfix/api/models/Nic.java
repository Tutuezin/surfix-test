package com.surfix.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "nic")
@Data
@Entity
@NoArgsConstructor

public class Nic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String ip;
  private String macAddress;
  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "machineId")
  private Machine machine;

}
