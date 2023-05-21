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
@Table(name = "GNL_TP")
public class GnlTp extends BaseEntity {

    @Id
    @SequenceGenerator(name = "gnlTpSeq", sequenceName = "GNL_TP_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gnlTpSeq")
    @Column(name = "GNL_TP_ID")
    private Long gnlTpId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @Column(name = "ENT_CODE_NAME")
    private String entCodeName;

    @Column(name = "ENT_NAME")
    private String entName;

    @Column(name = "IS_ACTV")
    private int isActv;

}
