package org.novitzkee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PERSON")
@NoArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

}
