package com.backend.backend.Repository;

import com.backend.backend.entity.ClassData; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassDataRepository extends JpaRepository<ClassData, Long> {
}