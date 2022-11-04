package com.example.ikk2Timmer.Domain;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@ToString
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Record> records;

    public void addRecord(Record record) {
        record.setUser(this);
        records.add(record);
    }

    public void removeRecord(Record record) {
        record.setUser(null);
        records.remove(record);
    }
}