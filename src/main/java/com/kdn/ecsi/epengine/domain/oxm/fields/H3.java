package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH3")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H3 {
    @Getter
    @XmlAttribute(name="v")
    private int h3;

    public H3() {}

    public H3(int h3) {
        this.h3 = h3;
    }
}