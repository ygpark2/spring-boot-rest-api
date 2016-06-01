package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldELPSEC")
@XmlAccessorType(XmlAccessType.FIELD)
public final class ELPSEC {
    @Getter
    @XmlAttribute(name="v")
    private int elpsec;

    public ELPSEC() {}

    public ELPSEC(int elpsec) {
        this.elpsec = elpsec;
    }
}