package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldEPT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class EPT {
    @Getter
    @XmlAttribute(name="v")
    private String ept;

    public EPT() {}

    public EPT(String ept) {
        this.ept = ept;
    }
}