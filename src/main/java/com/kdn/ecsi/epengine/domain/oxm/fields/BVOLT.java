package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldBVOLT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class BVOLT {
    @Getter
    @XmlAttribute(name="v")
    private int bvolt;

    public BVOLT() {}

    public BVOLT(int bvolt) {
        this.bvolt = bvolt;
    }
}

