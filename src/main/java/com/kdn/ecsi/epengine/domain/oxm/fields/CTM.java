package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCTM")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CTM {
    @Getter
    @XmlAttribute(name="v")
    private int ctm;

    public CTM() {}

    public CTM(int ctm) {
        this.ctm = ctm;
    }
}