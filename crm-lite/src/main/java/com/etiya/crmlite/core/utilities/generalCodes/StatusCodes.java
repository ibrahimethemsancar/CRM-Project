package com.etiya.crmlite.core.utilities.generalCodes;

public class StatusCodes {
    public static final int ACTV = 1;
    public static final int PASS = 0;
    //Customer Order
    public static final Long CUST_ORD_WAIT = 51L;
    public static final Long CUST_ORD_MIDLWARE = 52L;
    public static final Long CUST_ORD_FINISHED = 53L;
    public static final Long CUST_ORD_REJECTED = 54L;

    //Customer Account Product Involvement
    public static final Long CUST_ACCT_PROD_INVL_CNCL = 9001L;
    public static final Long CUST_ACCT_PROD_INVL_PNDG = 9004L;
    public static final Long CUST_ACCT_PROD_INVL_DEL = 9009L;
    public static final Long CUST_ACCT_PROD_INVL_ACTV = 9010L;
    public static final Long CUST_ACCT_PROD_INVL_SPND = 10620L;

    //Product
    public static final Long PROD_PDNG = 1500L;
    public static final Long PROD_QUOTE_DEL = 75690L;
    public static final Long PROD_ACTV = 116L;
    public static final Long PROD_DEL = 115L;
    public static final Long PROD_SPND = 10600L;

    //Product Characteristic Value
    public static final Long PROD_CHAR_VAL_DEL = 123L;
    public static final Long PROD_CHAR_VAL_ACTV = 124L;

    //Resource Specification
    public static final Long RSRC_SPEC_PASS = 14L;
    public static final Long RSRC_SPEC_DEL = 11L;
    public static final Long RSRC_SPEC_ACTV = 12L;

    //Individual
    public static final Long IND_DEL = 156L;
    public static final Long IND_ACTV = 157L;
    public static final Long IND_PASS = 158L;

    //Customer Account
    public static final Long CUST_ACCT_ACTV = 164L;
    public static final Long CUST_ACCT_DEL = 170L;
    public static final Long CUST_ACCT_PASS = 171L;

    //Product Specification
    public static final Long PROD_SPEC_ACTV = 10L;
    public static final Long PROD_SPEC_PASS = 13L;
    public static final Long PROD_SPEC_DEL = 9L;

    //Product Specification Service Specification
    public static final Long PROD_SPEC_SRVC_SPEC_ACTV = 239L;
    public static final Long PROD_SPEC_SRVC_SPEC_DEL = 240L;

    //Party
    public static final Long PARTY_DEL = 16L;
    public static final Long PARTY_ACTV = 17L;
    public static final Long PARTY_PASS = 18L;

    //Party Role
    public static final Long PARTY_ROLE_DEL = 79L;
    public static final Long PARTY_ROLE_ACTV = 80L;
    public static final Long PARTY_ROLE_PASS = 81L;

    //Product Specification Resource Specification
    public static final Long PROD_SPEC_RSRC_SPEC_ACTV = 19L;
    public static final Long PROD_SPEC_RSRC_SPEC_PASS = 20L;
    public static final Long PROD_SPEC_RSRC_SPEC_DEL = 21L;

    //Service Specification
    public static final Long SRVC_SPEC_ACTV = 22L;
    public static final Long SRVC_SPEC_DEL = 23L;

    //Product Catalog
    public static final Long PROD_CATAL_DEL = 33L;
    public static final Long PROD_CATAL_ACTV = 34L;
    public static final Long PROD_CATAL_PASS = 35L;

    //Product Offer
    public static final Long PROD_OFFER_ACTV = 70L;
    public static final Long PROD_OFFER_DEL = 71L;
    public static final Long PROD_OFFER_PASS = 72L;

    //Product Catalog Product Offer
    public static final Long PROD_CATAL_PROD_OFFER_ACTV = 177L;
    public static final Long PROD_CATAL_PROD_OFFER_DEL = 178L;
    public static final Long PROD_CATAL_PROD_OFFER_PASS = 179L;

    //Customer
    public static final Long CUST_CNCL = 82L;
    public static final Long CUST_ACTV = 83L;
    public static final Long CUST_PASS = 84L;

    //Contact Medium
    public static final Long CNTC_MEDIUM_DEL = 109L;
    public static final Long CNTC_MEDIUM_ACTV = 110L;
    public static final Long CNTC_MEDIUM_PASS = 111L;

    //Business Interaction
    public static final Long BSN_INTER_STATUS_FINISHED = 2L;
    public static final Long BSN_INTER_STATUS_UPDATE = 1L;
    public static final Long BSN_INTER_STATUS_CANCELED = 3L;
    public static final Long BSN_INTER_STATUS_DEL = 4L;
    public static final Long BSN_INTER_STATUS_WAIT = 21L;
}
