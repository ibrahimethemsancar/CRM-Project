package com.etiya.crmlite.entities.concretes.common;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.product.ProdSpecRsrcSpec;
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
@Table(name = "RSRC_SPEC")
public class RsrcSpec extends BaseEntity {

    @Id
    @SequenceGenerator(name = "rsrcSpecSeq", sequenceName = "RSRC_SPEC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rsrcSpecSeq")
    @Column(name = "RSRC_SPEC_ID")
    private Long rsrcSpecId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "ST_ID")
    private Long stId;

    @OneToMany(mappedBy = "rsrcSpec")
    private List<ProdSpecRsrcSpec> prodSpecRsrcSpecs;

}
