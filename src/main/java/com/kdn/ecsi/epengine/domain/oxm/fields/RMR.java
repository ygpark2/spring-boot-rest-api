package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldRMR")
@XmlAccessorType(XmlAccessType.FIELD)
public final class RMR {
    @Getter
    @XmlAttribute(name="v")
    private String rmr;

    public RMR() {}

    public RMR(String rmr) {
        this.rmr = rmr;
    }
}