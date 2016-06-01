package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPDT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PDT {
    @Getter
    @XmlAttribute(name="v")
    private int pdt;

    public PDT() {}

    public PDT(int pdt) {
        this.pdt = pdt;
    }
}