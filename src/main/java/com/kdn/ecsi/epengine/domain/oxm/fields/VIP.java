package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldVIP")
@XmlAccessorType(XmlAccessType.FIELD)
public final class VIP {
    @Getter
    @XmlAttribute(name="v")
    private String vip;

    public VIP() {}

    public VIP(String vip) {
        this.vip = vip;
    }
}