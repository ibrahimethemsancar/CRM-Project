package com.etiya.crmlite.entities.concretes.common;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GNL_ST")
public class GnlSt extends BaseEntity {

    @Id
    @SequenceGenerator(name = "gnlStSeq", sequenceName = "GNL_ST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gnlStSeq")
    @Column(name = "GNL_ST_ID")
    private Long gnlStId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @Column(name = "IS_ACTV")
    private int isActv;

    @Column(name = "ENT_CODE_NAME")
    private String entCodeName;

    @Column(name = "ENT_NAME")
    private String entName;
}
