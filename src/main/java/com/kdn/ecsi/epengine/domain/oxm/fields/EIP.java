package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldEIP")
@XmlAccessorType(XmlAccessType.FIELD)
public final class EIP {
    @Getter
    @XmlAttribute(name="v")
    private String eip;

    public EIP() {}

    public EIP(String eip) {
        this.eip = eip;
    }
}