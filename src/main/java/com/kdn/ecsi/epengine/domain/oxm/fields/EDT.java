package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldEDT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class EDT {
    @Getter
    @XmlAttribute(name="v")
    private int edt;

    public EDT() {}

    public EDT(int edt) {
        this.edt = edt;
    }
}
