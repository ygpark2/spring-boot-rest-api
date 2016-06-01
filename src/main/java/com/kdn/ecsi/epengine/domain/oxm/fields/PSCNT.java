package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPSCNT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PSCNT {
    @Getter
    @XmlAttribute(name="v")
    private int pscnt;

    public PSCNT() {}

    public PSCNT(int pscnt) {
        this.pscnt = pscnt;
    }
}