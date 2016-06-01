package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldRAMT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class RAMT {
    @Getter
    @XmlAttribute(name="v")
    private int ramt;

    public RAMT() {}

    public RAMT(int ramt) {
        this.ramt = ramt;
    }
}