package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH15")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H15 {
    @Getter
    @XmlAttribute(name="v")
    private int h15;

    public H15() {}

    public H15(int h15) {
        this.h15 = h15;
    }
}