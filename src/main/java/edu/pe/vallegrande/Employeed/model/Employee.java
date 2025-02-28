package edu.pe.vallegrande.Employeed.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false, length = 40)
    private String name;

    @Column(name = "LASTNAME", nullable = false, length = 40)
    private String lastname;

    @Column(name = "DOCUMENT_TYPE", nullable = false, length = 3)
    private String documentType;

    @Column(name = "DOCUMENT_NUMBER", nullable = false, unique = true, length = 12)
    private String documentNumber;

    @Column(name = "REGISTRATION_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Column(name = "CELLPHONE", length = 9)
    private String cellphone;

    @Column(name = "EMAIL", length = 25)
    private String email;

    @Column(name = "STATUS", length = 1)
    private String status;
}
