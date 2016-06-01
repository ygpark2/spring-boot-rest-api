package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH16")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H16 {
    @Getter
    @XmlAttribute(name="v")
    private int h16;

    public H16() {}

    public H16(int h16) {
        this.h16 = h16;
    }
}