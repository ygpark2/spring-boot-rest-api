package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPMD")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PMD {
    @Getter
    @XmlAttribute(name="v")
    private String pmd;

    public PMD() {}

    public PMD(String pmd) {
        this.pmd = pmd;
    }
}
