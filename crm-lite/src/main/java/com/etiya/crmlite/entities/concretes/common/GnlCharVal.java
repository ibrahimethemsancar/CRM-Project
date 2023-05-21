package com.etiya.crmlite.entities.concretes.common;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.product.ProdCharVal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GNL_CHAR_VAL")
public class GnlCharVal extends BaseEntity {

    @Id
    @SequenceGenerator(name = "gnlCharValSeq", sequenceName = "GNL_CHAR_VAL_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gnlCharValSeq")
    @Column(name = "CHAR_VAL_ID")
    private Long charValId;

    @Column(name = "CHAR_ID")
    // relation
    private Long charId;

    @Column(name = "IS_DFLT")
    private int isDflt;

    @Column(name = "VAL")
    private String val;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @Column(name = "SDATE")
    private LocalDate sDate;

    @Column(name = "EDATE")
    private LocalDate eDate;

    @Column(name = "IS_ACTV")
    private int isActv;

    @OneToMany(mappedBy = "gnlCharVal")
    private List<ProdCharVal> prodCharVals;

}
