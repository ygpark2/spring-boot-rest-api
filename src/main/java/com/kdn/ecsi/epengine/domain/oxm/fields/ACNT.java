package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldACNT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class ACNT {
    @Getter
    @XmlAttribute(name="v")
    private int acnt;

    public ACNT() {}

    public ACNT(int acnt) {
        this.acnt = acnt;
    }
}