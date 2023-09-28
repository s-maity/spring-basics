package org.example.aop;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    public Employee getEmployeeById(int id) {
        return new Employee(id, "Sudipta Maity", "SG");
    }

    public void delete(int id) {
        if (id >= 100) throw new RuntimeException("Emp not found using id:" + id);
        System.out.println("Delete emp by id:" + id);
    }

    public Employee update(int id) {
        System.out.println("Update emp" + id);
        return new Employee(id, "Sudipta Maity", "SG");
    }

    // empty string logic is in aop to validate the name
    public boolean isValidName(String name) {
        System.out.println("Check if name is valid usign a remote call");
        return makeRemoteCall(name);
    }

    private boolean makeRemoteCall(String name) {
        System.out.println("Calling other system..");
        return true;
    }
}
