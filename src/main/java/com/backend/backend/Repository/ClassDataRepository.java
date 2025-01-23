package com.backend.backend.Repository;

import com.backend.backend.entity.ClassData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ClassDataRepository extends JpaRepository<ClassData, Long> {
    List<ClassData> findByCreatedAtAfter(LocalDateTime createdAt);
}
