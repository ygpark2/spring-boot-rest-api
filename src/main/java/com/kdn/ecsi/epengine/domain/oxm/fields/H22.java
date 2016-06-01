package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH22")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H22 {
    @Getter
    @XmlAttribute(name="v")
    private int h22;

    public H22() {}

    public H22(int h22) {
        this.h22 = h22;
    }
}