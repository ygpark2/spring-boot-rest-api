package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldMDN")
@XmlAccessorType(XmlAccessType.FIELD)
public final class MDN {
    @Getter
    @XmlAttribute(name="v")
    private String mdn;

    public MDN() {}

    public MDN(String mdn) {
        this.mdn = mdn;
    }
}