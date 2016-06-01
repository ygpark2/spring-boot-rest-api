package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldIIWH")
@XmlAccessorType(XmlAccessType.FIELD)
public final class IIWH {
    @Getter
    @XmlAttribute(name="v")
    private int iiwh;

    public IIWH() {}

    public IIWH(int iiwh) {
        this.iiwh = iiwh;
    }
}