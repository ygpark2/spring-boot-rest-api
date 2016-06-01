package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH6")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H6 {
    @Getter
    @XmlAttribute(name="v")
    private int h6;

    public H6() {}

    public H6(int h6) {
        this.h6 = h6;
    }
}