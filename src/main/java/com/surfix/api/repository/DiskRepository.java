package com.surfix.api.repository;

import com.surfix.api.models.Disk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiskRepository extends JpaRepository<Disk, Long> {
}
