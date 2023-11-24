package com.kefas.TaskBackend.repository;

import com.kefas.TaskBackend.entity.Sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorsRepository extends JpaRepository<Sectors, Long> {
}
