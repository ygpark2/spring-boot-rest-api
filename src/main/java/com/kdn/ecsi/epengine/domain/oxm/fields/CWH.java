package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCWH")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CWH {
    @Getter
    @XmlAttribute(name="v")
    private int cwh;

    public CWH() {}

    public CWH(int cwh) {
        this.cwh = cwh;
    }
}