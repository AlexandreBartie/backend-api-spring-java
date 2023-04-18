package br.com.bartie.data.model;

import java.util.Date;

import br.com.bartie.app.core.ModelEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
@ToString
@Entity
@Table(name = "books")
public class Book extends ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Date launchDate;

    @Column(nullable = false, length = 100)
    private String address;
    
    @Column(nullable = false, length = 10)
    private String gender;

}
