package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCAMT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CAMT {
    @Getter
    @XmlAttribute(name="v")
    private int camt;

    public CAMT() {}

    public CAMT(int camt) {
        this.camt = camt;
    }
}