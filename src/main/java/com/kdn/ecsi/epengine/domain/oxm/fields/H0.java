package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH0")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H0 {
    @Getter
    @XmlAttribute(name="v")
    private int h0;

    public H0() {}

    public H0(int h0) {
        this.h0 = h0;
    }
}