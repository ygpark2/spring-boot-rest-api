package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPMR")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PMR {
    @Getter
    @XmlAttribute(name="v")
    private String pmr;

    public PMR() {}

    public PMR(String pmr) {
        this.pmr = pmr;
    }
}
