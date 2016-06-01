package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH17")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H17 {
    @Getter
    @XmlAttribute(name="v")
    private int h17;

    public H17() {}

    public H17(int h17) {
        this.h17 = h17;
    }
}