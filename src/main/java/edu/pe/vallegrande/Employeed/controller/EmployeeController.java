package edu.pe.vallegrande.Employeed.controller;


import edu.pe.vallegrande.Employeed.model.Employee;
import edu.pe.vallegrande.Employeed.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/active")
    public List<Employee> getActiveEmployees() {
        return service.getActiveEmployees();
    }

    @PostMapping
    public ResponseEntity<Employee> crearEmpleado(@RequestBody Employee employee) {
        return ResponseEntity.ok(service.crearEmpleado(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> editarEmpleado(@PathVariable int id, @RequestBody Employee employee) {
        Employee updatedEmployee = service.editarEmpleado(id, employee);
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<Void> restoreEmployee(@PathVariable int id) {
        service.restoreEmployee(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> softDeleteEmployee(@PathVariable int id) {
        service.softDeleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
