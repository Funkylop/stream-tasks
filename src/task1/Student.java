package task1;

import java.util.HashMap;
import java.util.Map;

class Student{

    Map<String, Integer> rating;
    String name;

    public Student(String name){
        rating = new HashMap<>();
        this.name = name;
    }

    public Student rate(String subject, Integer rate){
        rating.put(subject, rate);
        return this;
    }
}
