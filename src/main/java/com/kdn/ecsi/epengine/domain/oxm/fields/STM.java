package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldSTM")
@XmlAccessorType(XmlAccessType.FIELD)
public final class STM {
    @Getter
    @XmlAttribute(name="v")
    private long stm;

    public STM() {}

    public STM(long stm) {
        this.stm = stm;
    }
}
