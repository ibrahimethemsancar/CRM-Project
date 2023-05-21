package com.etiya.crmlite.entities.concretes.order;

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
@Table(name = "CUST_ORD_ITEM")
public class CustOrdItem extends BaseEntity {

    @Id
    @SequenceGenerator(name = "custOrdItemSeq", sequenceName = "CUST_ORD_ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custOrdItemSeq")
    @Column(name = "CUST_ORD_ITEM_ID")
    private Long custOrdItemId;

    @ManyToOne
    @JoinColumn(name = "CUST_ORD_ID")
    private CustOrd custOrd;

    @Column(name = "CUST_ACCT_ID")
    private Long custAcctId;

    @Column(name = "NEW_CUST_ACCT_ID")
    private Long newCustAcctId;

    @Column(name = "PROD_ID")
    private Long prodId;

    @Column(name = "PROD_OFR_ID")
    private Long prodOfrId;

    @ManyToOne
    @JoinColumn(name = "BSN_INTER_ID")
    private BsnInter bsnInter;

    @Column(name = "CMPG_ID")
    private Long cmpgId;

    @Column(name = "IS_NEED_SHPMT")
    private Long isNeedShpmt;

    @Column(name = "OFR_NAME")
    private String ofrName;

    @Column(name = "PROD_NAME")
    private String prodName;

    @Column(name = "PROD_SPEC_ID")
    private Long prodSpecId;

    @Column(name = "CUST_ID")
    private Long custId;

    @Column(name = "NEW_CUST_ID")
    private Long newCustId;

    @Column(name = "CMPG_NAME")
    private String cmpgNameğ;


}
