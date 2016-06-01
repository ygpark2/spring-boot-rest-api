package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPRC")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PRC {
    @Getter
    @XmlAttribute(name="v")
    private int prc;

    public PRC() {}

    public PRC(int prc) {
        this.prc = prc;
    }
}
