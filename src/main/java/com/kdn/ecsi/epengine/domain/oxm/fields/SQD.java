package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldSQD")
@XmlAccessorType(XmlAccessType.FIELD)
public final class SQD {
    @Getter
    @XmlAttribute(name="v")
    private int sqd;

    public SQD() {}

    public SQD(int sqd) {
        this.sqd = sqd;
    }
}