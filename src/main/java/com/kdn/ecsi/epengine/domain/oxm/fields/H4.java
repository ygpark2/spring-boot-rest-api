package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH4")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H4 {
    @Getter
    @XmlAttribute(name="v")
    private int h4;

    public H4() {}

    public H4(int h4) {
        this.h4 = h4;
    }
}