package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldBWH")
@XmlAccessorType(XmlAccessType.FIELD)
public final class BWH {
    @Getter
    @XmlAttribute(name="v")
    private int bwh;

    public BWH() {}

    public BWH(int bwh) {
        this.bwh = bwh;
    }
}