package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPTM")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PTM {
    @Getter
    @XmlAttribute(name="v")
    private int ptm;

    public PTM() {}

    public PTM(int ptm) {
        this.ptm = ptm;
    }
}