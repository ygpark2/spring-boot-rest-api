package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldSQN")
@XmlAccessorType(XmlAccessType.FIELD)
public final class SQN {
    @Getter
    @XmlAttribute(name="v")
    private int sqn;

    public SQN() {}

    public SQN(int sqn) {
        this.sqn = sqn;
    }
}