package com.etiya.crmlite.entities.concretes.cam;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PARTY_ROLE")
public class PartyRole extends BaseEntity {

    @Id
    @SequenceGenerator(name = "partyRoleSeq", sequenceName = "PARTY_ROLE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partyRoleSeq")
    @Column(name = "PARTY_ROLE_ID")
    private Long partyRoleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARTY_ID")
    private Party party;

    @ManyToOne
    @JoinColumn(name = "PARTY_ROLE_TP_ID")
    private PartyRoleTp partyRoleTp;

    @Column(name = "ST_ID")
    private Long stId;

    @OneToOne(mappedBy = "partyRole", cascade = CascadeType.ALL)
    private Cust cust;
}
