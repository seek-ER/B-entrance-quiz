package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:1234")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<Map<Integer, String>> getOrders() {
        final Map<Integer, String> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }
}
