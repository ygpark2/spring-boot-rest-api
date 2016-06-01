package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPFCNT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PFCNT {
    @Getter
    @XmlAttribute(name="v")
    private int pfcnt;

    public PFCNT() {}

    public PFCNT(int pfcnt) {
        this.pfcnt = pfcnt;
    }
}