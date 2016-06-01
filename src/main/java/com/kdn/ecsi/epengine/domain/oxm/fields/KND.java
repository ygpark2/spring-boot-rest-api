package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldKND")
@XmlAccessorType(XmlAccessType.FIELD)
public final class KND {
    @Getter
    @XmlAttribute(name="v")
    private String knd;

    public KND() {}

    public KND(String knd) {
        this.knd = knd;
    }
}
