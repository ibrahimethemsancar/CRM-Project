package com.etiya.crmlite.entities.concretes.common;

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
@Table(name = "ETIYA_TYPE_VALUE")
public class EtiyaTypeValue {

    @Id
    @SequenceGenerator(name = "typeValueSeq", sequenceName = "TYPE_VALUE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeValueSeq")
    @Column(name = "TYPE_VALUE_ID")
    private Long typeValueId;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "FIELD_NAME")
    private Long fieldName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "USING_MODULE_NAME")
    private String usingModuleName;

}
