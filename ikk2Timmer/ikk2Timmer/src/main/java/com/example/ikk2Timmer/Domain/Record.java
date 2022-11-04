package com.example.ikk2Timmer.Domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "h")
    private Integer h;

    @Column(name = "m")
    private Integer m;

    @Column(name = "regDate")
    @CreationTimestamp
    private LocalDate regDate;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Builder
    public Record(Long id, Integer h, Integer m, User user, LocalDate regDate) {
        this.id = id;
        this.h = h;
        this.m = m;
        this.user = user;
        this.regDate = regDate;
    }

    public Record() {

    }
}
