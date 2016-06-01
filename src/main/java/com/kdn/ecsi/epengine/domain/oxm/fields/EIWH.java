package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldEIWH")
@XmlAccessorType(XmlAccessType.FIELD)
public final class EIWH {
    @Getter
    @XmlAttribute(name="v")
    private int eiwh;

    public EIWH() {}

    public EIWH(int eiwh) {
        this.eiwh = eiwh;
    }
}