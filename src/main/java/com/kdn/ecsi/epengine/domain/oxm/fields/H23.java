package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH23")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H23 {
    @Getter
    @XmlAttribute(name="v")
    private int h23;

    public H23() {}

    public H23(int h23) {
        this.h23 = h23;
    }
}