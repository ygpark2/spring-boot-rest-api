package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPRST")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PRST {
    @Getter
    @XmlAttribute(name="v")
    private int prst;

    public PRST() {}

    public PRST(int prst) {
        this.prst = prst;
    }
}
