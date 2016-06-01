package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPIWH")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PIWH {
    @Getter
    @XmlAttribute(name="v")
    private int piwh;

    public PIWH() {}

    public PIWH(int piwh) {
        this.piwh = piwh;
    }
}