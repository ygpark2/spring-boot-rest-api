package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCOT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class COT {
    @Getter
    @XmlAttribute(name="v")
    private int cot;

    public COT() {}

    public COT(int cot) {
        this.cot = cot;
    }
}