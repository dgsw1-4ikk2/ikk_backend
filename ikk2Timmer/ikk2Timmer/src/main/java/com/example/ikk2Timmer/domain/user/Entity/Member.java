package com.example.ikk2Timmer.domain.user.Entity;

import com.example.ikk2Timmer.domain.record.Entity.Record;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Set;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public void addUserAuthority() {
        this.role = Role.USER;
    }

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<Record> records;

    public void addRecord(Record record) {
        record.setMember(this);
        records.add(record);
    }

    public void removeRecord(Record record) {
        record.setMember(null);
        records.remove(record);
    }


}