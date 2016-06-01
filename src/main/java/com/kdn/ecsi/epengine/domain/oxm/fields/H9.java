package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH9")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H9 {
    @Getter
    @XmlAttribute(name="v")
    private int h9;

    public H9() {}

    public H9(int h9) {
        this.h9 = h9;
    }
}