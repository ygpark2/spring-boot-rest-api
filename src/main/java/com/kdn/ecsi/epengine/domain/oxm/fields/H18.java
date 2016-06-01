package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH18")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H18 {
    @Getter
    @XmlAttribute(name="v")
    private int h18;

    public H18() {}

    public H18(int h18) {
        this.h18 = h18;
    }
}