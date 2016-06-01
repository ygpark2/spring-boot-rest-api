package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPRM")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PRM {
    @Getter
    @XmlAttribute(name="v")
    private String prm;

    public PRM() {}

    public PRM(String prm) {
        this.prm = prm;
    }
}
