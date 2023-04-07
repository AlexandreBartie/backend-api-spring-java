package br.com.bartie.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 100)
    public String firstName;

    @Column(nullable = false, length = 100)
    public String lastName;
    
    @Column(nullable = false, length = 100)
    public String address;
    
    @Column(nullable = false, length = 10)
    public String gender;
    
}
