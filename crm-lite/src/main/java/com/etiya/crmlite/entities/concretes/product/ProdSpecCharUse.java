package com.etiya.crmlite.entities.concretes.product;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.common.GnlChar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROD_SPEC_CHAR_USE")
public class ProdSpecCharUse extends BaseEntity {

    @Id
    @SequenceGenerator(name = "prodSpecCharUseSeq", sequenceName = "PROD_SPEC_CHAR_USE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodSpecCharUseSeq")
    @Column(name = "PROD_SPEC_CHAR_USE_ID")
    private Long prodSpecCharUseId;

    @ManyToOne
    @JoinColumn(name = "PROD_SPEC_ID")
    private ProdSpec prodSpec;

    @ManyToOne
    @JoinColumn(name = "CHAR_ID")
    private GnlChar gnlChar;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "IS_ACTV")
    private int isActv;
}
