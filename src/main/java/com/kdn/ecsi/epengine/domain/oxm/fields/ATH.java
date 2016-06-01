package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldATH")
@XmlAccessorType(XmlAccessType.FIELD)
public final class ATH {
    @Getter
    @XmlAttribute(name="v")
    private int ath;

    public ATH() {}

    public ATH(int ath) {
        this.ath = ath;
    }
}