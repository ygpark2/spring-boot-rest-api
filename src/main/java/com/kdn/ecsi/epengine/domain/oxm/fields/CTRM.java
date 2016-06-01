package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCTRM")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CTRM {
    @Getter
    @XmlAttribute(name="v")
    private int ctrm;

    public CTRM() {}

    public CTRM(int ctrm) {
        this.ctrm = ctrm;
    }
}