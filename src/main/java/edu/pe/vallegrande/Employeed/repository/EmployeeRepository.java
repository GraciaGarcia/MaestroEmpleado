package edu.pe.vallegrande.Employeed.repository;

import edu.pe.vallegrande.Employeed.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByStatus(String status);

    @Modifying
    @Query("UPDATE Employee e SET e.status = 'A' WHERE e.id = :id")
    void restoreById(int id);

    @Modifying
    @Query("UPDATE Employee e SET e.status = 'I' WHERE e.id = :id")
    void softDeleteById(int id);
}