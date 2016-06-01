package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH21")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H21 {
    @Getter
    @XmlAttribute(name="v")
    private int h21;

    public H21() {}

    public H21(int h21) {
        this.h21 = h21;
    }
}