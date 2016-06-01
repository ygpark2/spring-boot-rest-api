package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldFR")
@XmlAccessorType(XmlAccessType.FIELD)
public final class FR {
    @Getter
    @XmlAttribute(name="v")
    private String fr;

    public FR() {}

    public FR(String fr) {
        this.fr = fr;
    }
}