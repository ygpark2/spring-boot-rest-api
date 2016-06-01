package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldRWH")
@XmlAccessorType(XmlAccessType.FIELD)
public final class RWH {
    @Getter
    @XmlAttribute(name="v")
    private int rwh;

    public RWH() {}

    public RWH(int rwh) {
        this.rwh = rwh;
    }
}