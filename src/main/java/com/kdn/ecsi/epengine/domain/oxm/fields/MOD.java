package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldMOD")
@XmlAccessorType(XmlAccessType.FIELD)
public final class MOD {
    @Getter
    @XmlAttribute(name="v")
    private int mod;

    public MOD() {}

    public MOD(int mod) {
        this.mod = mod;
    }
}