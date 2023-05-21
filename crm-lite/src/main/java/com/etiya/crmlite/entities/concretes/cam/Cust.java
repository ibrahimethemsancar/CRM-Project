package com.etiya.crmlite.entities.concretes.cam;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CUST")
public class Cust extends BaseEntity {

    @Id
    @SequenceGenerator(name = "custSeq", sequenceName = "CUST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custSeq")
    @Column(name = "CUST_ID")
    private Long custId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARTY_ROLE_ID", referencedColumnName = "PARTY_ROLE_ID")
    private PartyRole partyRole;

    @Column(name = "ST_ID")
    private Long stId;

    @ManyToOne
    @JoinColumn(name = "CUST_TP_ID")
    private CustTp custTp;

    @OneToMany(mappedBy = "cust")
    private List<CustAcct> custAccts;
}
