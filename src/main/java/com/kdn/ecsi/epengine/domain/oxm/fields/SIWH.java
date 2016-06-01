package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldSIWH")
@XmlAccessorType(XmlAccessType.FIELD)
public final class SIWH {
    @Getter
    @XmlAttribute(name="v")
    private int siwh;

    public SIWH() {}

    public SIWH(int siwh) {
        this.siwh = siwh;
    }
}