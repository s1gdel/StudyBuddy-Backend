package com.backend.backend.service;

import com.backend.backend.Repository.ClassDataRepository;
import com.backend.backend.entity.ClassData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClassDataService {

    @Autowired
    private ClassDataRepository classDataRepository;

    public ClassData saveClassData(ClassData classData) {
        return classDataRepository.save(classData);
    }

    public List<ClassData> getAllClassData() {
        return classDataRepository.findAll();
    }

    public ClassData updateClassData(Long id, ClassData updatedClassData) {
        Optional<ClassData> optionalClassData = classDataRepository.findById(id);
        if (optionalClassData.isPresent()) {
            ClassData existingClassData = optionalClassData.get();
            existingClassData.setPersonName(updatedClassData.getPersonName());
            existingClassData.setClassName(updatedClassData.getClassName());
            existingClassData.setProfName(updatedClassData.getProfName());
            existingClassData.setDescription(updatedClassData.getDescription());
            existingClassData.setLatitude(updatedClassData.getLatitude());
            existingClassData.setLongitude(updatedClassData.getLongitude());
            return classDataRepository.save(existingClassData);
        } else {
            throw new RuntimeException("ClassData not found with id: " + id);
        }
    }

    public void deleteClassData(Long id) {
        if (classDataRepository.existsById(id)) {
            classDataRepository.deleteById(id);
        } else {
            throw new RuntimeException("ClassData not found with id: " + id);
        }
    }
}