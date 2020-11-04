package com.thoughtworks.capability.gtb.entrancequiz.dao;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class StudentDao {
    public final static Map<Integer,String> studentMap = new HashMap<>();

    static {
        studentMap.put(1, "成吉思汗");
        studentMap.put(2, "鲁班七号");
        studentMap.put(3, "太乙真人");
        studentMap.put(4, "钟无艳");
        studentMap.put(5, "花木兰");
        studentMap.put(6, "雅典娜");
        studentMap.put(7, "芈月");
        studentMap.put(8, "白起");
        studentMap.put(9, "刘禅");
        studentMap.put(10, "庄周");
        studentMap.put(11, "马超");
        studentMap.put(12, "刘备");
        studentMap.put(13, "哪吒");
        studentMap.put(14, "大乔");
        studentMap.put(15, "蔡文姬");
    }

    public Map<Integer, String> getAllStudent() {
        return studentMap;
    }

    public void addStudent(String inputStudent) {
        //TODO GTB-工程实践: - StudentDao.java:35 这种自增方式线程不安全，了解下AtomicInteger
        studentMap.put(studentMap.size() + 1, inputStudent);
    }
}
