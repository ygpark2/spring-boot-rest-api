package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCTP")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CTP {
    @Getter
    @XmlAttribute(name="v")
    private int ctp;

    public CTP() {}

    public CTP(int ctp) {
        this.ctp = ctp;
    }
}