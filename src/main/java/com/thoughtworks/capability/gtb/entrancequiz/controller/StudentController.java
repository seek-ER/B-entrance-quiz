package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:1234")
public class StudentController {
    //TODO GTB-知识点: - StudentController.java:14 推荐使用构造器注入
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    //TODO GTB-知识点: - StudentController.java:19 如果不是有自定义返回的需求，ResponseEntity一般可省略
    public ResponseEntity<Map<Integer, String>> getOrders() {
        final Map<Integer, String> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/grouping")
    public ResponseEntity<List<Map<Integer, String>>> grouping() {
        final List<Map<Integer, String>> lists = studentService.grouping();
        return ResponseEntity.ok(lists);
    }

    @PostMapping("/student")
    //TODO GTB-知识点: - StudentController.java:32 了解下@ResponseStatus
    //TODO GTB-综合: * 如果使用Map来进行student数据的传输，何不进一步，将这个Map抽象成一个对象
    public ResponseEntity<Void> addAllOrder(@RequestBody Map inputStudent) {
        //TODO GTB-工程实践: - StudentController.java:35 如果不沟通，前端不会知道这里需要"inputStudent"作为key，可读性太低
        //TODO GTB-工程实践: - StudentController.java:36 仅仅从代码的角度来讲， 类似"inputStudent"出现了多次的代码，需要抽取变量
        System.out.println(inputStudent.get("inputStudent"));
        studentService.addStudent(String.valueOf(inputStudent.get("inputStudent")));
        return ResponseEntity.created(null).build();
    }

    //TODO GTB-完成度: * 缺少查看已经分组的api
}
