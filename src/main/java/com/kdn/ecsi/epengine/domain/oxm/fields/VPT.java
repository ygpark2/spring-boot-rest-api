package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldVPT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class VPT {
    @Getter
    @XmlAttribute(name="v")
    private String vpt;

    public VPT() {}

    public VPT(String vpt) {
        this.vpt = vpt;
    }
}