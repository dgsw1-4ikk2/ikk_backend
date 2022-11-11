package com.example.ikk2Timmer.domain.record.Entity;

import com.example.ikk2Timmer.domain.user.Entity.Member;
import com.example.ikk2Timmer.domain.user.Entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

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
    private Member member;
    @Builder
    public Record(Long id, Integer h, Integer m, Member member, LocalDate regDate) {
        this.id = id;
        this.h = h;
        this.m = m;
        this.member = member;
        this.regDate = regDate;
    }

    public Record() {

    }
}
