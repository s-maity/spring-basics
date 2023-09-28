package org.example.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/check-if-admission-open")
    public boolean checkIfAdmissionOpen() {
        return studentService.checkIfAdmissionOpen();
    }
}
