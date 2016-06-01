package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldSDT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class SDT {
    @Getter
    @XmlAttribute(name="v")
    private int sdt;

    public SDT() {}

    public SDT(int sdt) {
        this.sdt = sdt;
    }
}