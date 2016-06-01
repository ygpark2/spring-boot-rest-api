package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH14")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H14 {
    @Getter
    @XmlAttribute(name="v")
    private int h14;

    public H14() {}

    public H14(int h14) {
        this.h14 = h14;
    }
}