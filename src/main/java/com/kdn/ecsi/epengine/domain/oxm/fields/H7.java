package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH7")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H7 {
    @Getter
    @XmlAttribute(name="v")
    private int h7;

    public H7() {}

    public H7(int h7) {
        this.h7 = h7;
    }
}