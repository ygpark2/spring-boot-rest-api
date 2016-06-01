package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldBTEMP")
@XmlAccessorType(XmlAccessType.FIELD)
public final class BTEMP {
    @Getter
    @XmlAttribute(name="v")
    private Float btemp;

    public BTEMP() {}

    public BTEMP(Float btemp) {
        this.btemp = btemp;
    }
}
