package com.etiya.crmlite.entities.concretes.product;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROD_OFR")
public class ProdOfr extends BaseEntity {

    @Id
    @SequenceGenerator(name = "prodOfrSeq", sequenceName = "PROD_OFR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodOfrSeq")
    @Column(name = "PROD_OFR_ID")
    private Long prodOfrId;

    @ManyToOne
    @JoinColumn(name = "PROD_SPEC_ID")
    private ProdSpec prodSpec;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "PRNT_OFR_ID")
    private Long prntOfrId;

    @Column(name = "ST_ID")
    private Long stId;

    @Column(name = "PROD_OFR_TOTAL_PRC")
    private Long prodOfrTotalPrc;

    @OneToMany(mappedBy = "prodOfr")
    private List<CmpgProdOfr> cmpgProdOfrs;

    @OneToMany(mappedBy = "prodOfr")
    private List<Prod> prods;

    @OneToMany(mappedBy = "prodOfr")
    private List<ProdCatalProdOfr> prodCatalProdOfrs;

}
