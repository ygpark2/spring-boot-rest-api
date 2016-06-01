package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH11")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H11 {
    @Getter
    @XmlAttribute(name="v")
    private int h11;

    public H11() {}

    public H11(int h11) {
        this.h11 = h11;
    }
}