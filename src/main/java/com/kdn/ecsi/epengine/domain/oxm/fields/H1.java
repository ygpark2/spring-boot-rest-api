package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH1")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H1 {
    @Getter
    @XmlAttribute(name="v")
    private int h1;

    public H1() {}

    public H1(int h1) {
        this.h1 = h1;
    }
}