package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dao.StudentDao;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 */
@Service
public class StudentService {
    StudentDao studentDao = new StudentDao();

    public Map<Integer, String> getAllStudents() {
        return studentDao.getAllStudent();
    }

    public List<Map<Integer, String>> grouping() {
        final Map<Integer, String> allStudent = studentDao.getAllStudent();
        final Map<Integer, String> allStudent2 = new HashMap<>(allStudent);
        final int size = allStudent.size();
        final ArrayList<Map<Integer, String>> maps = new ArrayList<>();
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
        System.out.println(maps);
        return maps;
    }
}
