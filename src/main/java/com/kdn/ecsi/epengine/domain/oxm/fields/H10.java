package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH10")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H10 {
    @Getter
    @XmlAttribute(name="v")
    private int h10;

    public H10() {}

    public H10(int h10) {
        this.h10 = h10;
    }
}