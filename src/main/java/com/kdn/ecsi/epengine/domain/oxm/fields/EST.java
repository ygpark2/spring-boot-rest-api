package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldEST")
@XmlAccessorType(XmlAccessType.FIELD)
public final class EST {
    @Getter
    @XmlAttribute(name="v")
    private int est;

    public EST() {}

    public EST(int est) {
        this.est = est;
    }
}