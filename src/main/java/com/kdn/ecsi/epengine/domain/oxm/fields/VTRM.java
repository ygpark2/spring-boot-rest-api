package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldVTRM")
@XmlAccessorType(XmlAccessType.FIELD)
public final class VTRM {
    @Getter
    @XmlAttribute(name="v")
    private int vtrm;

    public VTRM() {}

    public VTRM(int vtrm) {
        this.vtrm = vtrm;
    }
}