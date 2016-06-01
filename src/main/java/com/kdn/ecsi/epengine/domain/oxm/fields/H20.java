package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH20")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H20 {
    @Getter
    @XmlAttribute(name="v")
    private int h20;

    public H20() {}

    public H20(int h20) {
        this.h20 = h20;
    }
}