package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
