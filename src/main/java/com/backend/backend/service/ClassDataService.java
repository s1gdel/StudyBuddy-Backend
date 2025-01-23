package com.backend.backend.service;

import com.backend.backend.Repository.ClassDataRepository;
import com.backend.backend.entity.ClassData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class ClassDataService {

    @Autowired
    private ClassDataRepository classDataRepository;

    public ClassData saveClassData(ClassData classData) {
        return classDataRepository.save(classData);
    }

    public List<ClassData> getAllClassData() {
        LocalDateTime fiveSecondsAgo = LocalDateTime.now(ZoneOffset.UTC).minusHours(3);
                                                                                         
        return classDataRepository.findByCreatedAtAfter(fiveSecondsAgo);
    }

    public ClassData updateClassData(Long id, ClassData updatedClassData) {
        return classDataRepository.findById(id)
                .map(existingClassData -> {
                    existingClassData.setPersonName(updatedClassData.getPersonName());
                    existingClassData.setClassName(updatedClassData.getClassName());
                    existingClassData.setProfName(updatedClassData.getProfName());
                    existingClassData.setDescription(updatedClassData.getDescription());
                    existingClassData.setLatitude(updatedClassData.getLatitude());
                    existingClassData.setLongitude(updatedClassData.getLongitude());
                    return classDataRepository.save(existingClassData);
                })
                .orElseThrow(() -> new RuntimeException("ClassData not found with id: " + id));
    }

    public void deleteClassData(Long id) {
        classDataRepository.deleteById(id);
    }
}
