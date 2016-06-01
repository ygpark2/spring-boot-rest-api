package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldUWH")
@XmlAccessorType(XmlAccessType.FIELD)
public final class UWH {
    @Getter
    @XmlAttribute(name="v")
    private int uwh;

    public UWH() {}

    public UWH(int uwh) {
        this.uwh = uwh;
    }
}