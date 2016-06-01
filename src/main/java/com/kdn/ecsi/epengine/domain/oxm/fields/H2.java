package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH2")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H2 {
    @Getter
    @XmlAttribute(name="v")
    private int h2;

    public H2() {}

    public H2(int h2) {
        this.h2 = h2;
    }
}