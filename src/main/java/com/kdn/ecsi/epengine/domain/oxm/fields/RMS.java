package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldRMS")
@XmlAccessorType(XmlAccessType.FIELD)
public final class RMS {
    @Getter
    @XmlAttribute(name="v")
    private String rms;

    public RMS() {}

    public RMS(String rms) {
        this.rms = rms;
    }
}