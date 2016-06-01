package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH13")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H13 {
    @Getter
    @XmlAttribute(name="v")
    private int h13;

    public H13() {}

    public H13(int h13) {
        this.h13 = h13;
    }
}