package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH19")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H19 {
    @Getter
    @XmlAttribute(name="v")
    private int h19;

    public H19() {}

    public H19(int h19) {
        this.h19 = h19;
    }
}