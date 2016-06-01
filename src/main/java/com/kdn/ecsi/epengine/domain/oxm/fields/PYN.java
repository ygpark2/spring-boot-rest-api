package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldPYN")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PYN {
    @Getter
    @XmlAttribute(name="v")
    private int pyn;

    public PYN() {}

    public PYN(int pyn) {
        this.pyn = pyn;
    }
}