package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldMMR")
@XmlAccessorType(XmlAccessType.FIELD)
public final class MMR {
    @Getter
    @XmlAttribute(name="v")
    private String mmr;

    public MMR() {}

    public MMR(String mmr) {
        this.mmr = mmr;
    }
}
