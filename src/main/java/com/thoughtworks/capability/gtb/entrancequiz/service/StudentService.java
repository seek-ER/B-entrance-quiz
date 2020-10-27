package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dao.StudentDao;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 */
@Service
public class StudentService {
    StudentDao studentDao = new StudentDao();

    public Map<Integer, String> getAllStudents() {
        return studentDao.getAllStudent();
    }
}
