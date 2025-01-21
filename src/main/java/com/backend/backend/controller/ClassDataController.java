package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.backend.entity.ClassData;
import com.backend.backend.service.ClassDataService;
import java.util.List;

@RestController
@RequestMapping("/api/class-data")
public class ClassDataController {

    @Autowired
    private ClassDataService classDataService;

    @PostMapping
    public ClassData createClassData(@RequestBody ClassData classData) {
        return classDataService.saveClassData(classData);
    }

    @GetMapping
    public List<ClassData> getAllClassData() {
        return classDataService.getAllClassData();
    }

    @PutMapping("/{id}")
    public ClassData updateClassData(@PathVariable Long id, @RequestBody ClassData updatedClassData) {
        return classDataService.updateClassData(id, updatedClassData);
    }

    @DeleteMapping("/{id}")
    public void deleteClassData(@PathVariable Long id) {
        classDataService.deleteClassData(id);
    }
}