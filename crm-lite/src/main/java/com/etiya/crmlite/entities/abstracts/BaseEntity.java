package com.etiya.crmlite.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "CDATE")
    private LocalDateTime cDate;

    @Column(name = "CUSER")
    private Long cUser;

    @Column(name = "UDATE")
    private LocalDateTime uDate;

    @Column(name = "UUSER")
    private Long uUser;
    @PrePersist
    public void onCreate() {
        this.cUser = 4L;
        this.cDate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.uUser = 4L;
        this.uDate = LocalDateTime.now();
    }
}
