package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldTDT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class TDT {
    @Getter
    @XmlAttribute(name="v")
    private int tdt;

    public TDT() {}

    public TDT(int tdt) {
        this.tdt = tdt;
    }
}