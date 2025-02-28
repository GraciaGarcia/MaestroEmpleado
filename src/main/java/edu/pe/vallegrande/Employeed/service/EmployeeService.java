package edu.pe.vallegrande.Employeed.service;


import edu.pe.vallegrande.Employeed.model.Employee;
import edu.pe.vallegrande.Employeed.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public List<Employee> getActiveEmployees() {
        return repository.findByStatus("A");
    }

    public Employee crearEmpleado(Employee employee) {
        return repository.save(employee);
    }

    public Employee editarEmpleado(int id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = repository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setLastname(updatedEmployee.getLastname());
            employee.setDocumentType(updatedEmployee.getDocumentType());
            employee.setDocumentNumber(updatedEmployee.getDocumentNumber());
            employee.setRegistrationDate(updatedEmployee.getRegistrationDate());
            employee.setCellphone(updatedEmployee.getCellphone());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setStatus(updatedEmployee.getStatus());
            return repository.save(employee);
        }
        return null;
    }

    @Transactional
    public void restoreEmployee(int id) {
        repository.restoreById(id);
    }

    @Transactional
    public void softDeleteEmployee(int id) {
        repository.softDeleteById(id);
    }
}