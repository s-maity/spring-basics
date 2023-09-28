package org.example.aop;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    @AfterLog
    public boolean checkIfAdmissionOpen() {
        System.out.println("checking if admission is open today:"+ LocalDateTime.now());
        return true;
    }
}
