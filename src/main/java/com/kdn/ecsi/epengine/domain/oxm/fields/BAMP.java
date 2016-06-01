package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldBAMP")
@XmlAccessorType(XmlAccessType.FIELD)
public final class BAMP {
    @Getter
    @XmlAttribute(name="v")
    private int bamp;

    public BAMP() {}

    public BAMP(int bamp) {
        this.bamp = bamp;
    }
}
