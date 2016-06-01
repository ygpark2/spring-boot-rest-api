package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPG_KND")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PG_KND {
    @Getter
    @XmlAttribute(name="v")
    private String pg_knd;

    public PG_KND() {}

    public PG_KND(String pg_knd) {
        this.pg_knd = pg_knd;
    }
}