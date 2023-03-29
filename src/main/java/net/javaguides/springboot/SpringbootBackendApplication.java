package net.javaguides.springboot;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public SpringbootBackendApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Employee employee = new Employee();
        employee.setFirstName("Shashi");
        employee.setLastName("Mittewad");
        employee.setEmailId("shashikant.softelevation@gmail.com");
        employeeRepository.save(employee);
    }
}
