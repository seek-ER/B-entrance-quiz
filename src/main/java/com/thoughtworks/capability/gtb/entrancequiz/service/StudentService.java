package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dao.StudentDao;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 */
@Service
public class StudentService {
    //TODO GTB-知识点: - StudentService.java:13 如果StudentDao是作为持久层存在的，那么需要被注入，而非直接new
    StudentDao studentDao = new StudentDao();

    public Map<Integer, String> getAllStudents() {
        return studentDao.getAllStudent();
    }

    //TODO GTB-工程实践: - StudentService.java:19 长方法，需要抽取方法，进行重构
    public List<Map<Integer, String>> grouping() {
        //TODO GTB-工程实践: - StudentService.java:22 变量命名不表意，且太过随意
        final Map<Integer, String> allStudent = studentDao.getAllStudent();
        final Map<Integer, String> allStudent2 = new HashMap<>(allStudent);
        final int size = allStudent.size();
        final ArrayList<Map<Integer, String>> maps = new ArrayList<>();
        //TODO GTB-工程实践: - StudentService.java:24 Magic number 6
        for (int i = 0; i < 6; i++) {
            maps.add(new HashMap<>());
        }
        for (int i = 0; i < size; i++) {
            Integer[] keys = allStudent2.keySet().toArray(new Integer[0]);
            Random random = new Random();
            Integer randomKey = keys[random.nextInt(keys.length)];
            final String remove = allStudent2.remove(randomKey);
            maps.get(i % 6).put(randomKey, remove);
        }
        //TODO GTB-工程实践: - StudentService.java:38 调试代码，在正式提交前，需要被删除
        System.out.println(maps);
        return maps;
    }

    public void addStudent(String inputStudent) {
        studentDao.addStudent(inputStudent);
    }
}
