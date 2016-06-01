package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCDT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CDT {
    @Getter
    @XmlAttribute(name="v")
    private int cdt;

    public CDT() {}

    public CDT(int cdt) {
        this.cdt = cdt;
    }
}