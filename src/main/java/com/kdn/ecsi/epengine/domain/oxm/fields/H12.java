package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH12")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H12 {
    @Getter
    @XmlAttribute(name="v")
    private int h12;

    public H12() {}

    public H12(int h12) {
        this.h12 = h12;
    }
}