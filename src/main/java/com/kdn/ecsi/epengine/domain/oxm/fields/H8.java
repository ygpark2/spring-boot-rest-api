package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH8")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H8 {
    @Getter
    @XmlAttribute(name="v")
    private int h8;

    public H8() {}

    public H8(int h8) {
        this.h8 = h8;
    }
}