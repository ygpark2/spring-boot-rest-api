package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldUIWH")
@XmlAccessorType(XmlAccessType.FIELD)
public final class UIWH {
    @Getter
    @XmlAttribute(name="v")
    private int uiwh;

    public UIWH() {}

    public UIWH(int uiwh) {
        this.uiwh = uiwh;
    }
}