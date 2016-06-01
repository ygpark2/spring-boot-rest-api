package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldBMS")
@XmlAccessorType(XmlAccessType.FIELD)
public final class BMS {
    @Getter
    @XmlAttribute(name="v")
    private String bms;

    public BMS() {}

    public BMS(String bms) {
        this.bms = bms;
    }
}
