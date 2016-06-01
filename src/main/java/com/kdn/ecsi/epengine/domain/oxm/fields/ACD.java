package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldACD")
@XmlAccessorType(XmlAccessType.FIELD)
public final class ACD {
    @Getter
    @XmlAttribute(name="v")
    private String acd;

    public ACD() {}

    public ACD(String acd) {
        this.acd = acd;
    }
}
