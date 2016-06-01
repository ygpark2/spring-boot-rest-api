package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldETM")
@XmlAccessorType(XmlAccessType.FIELD)
public final class ETM {
    @Getter
    @XmlAttribute(name="v")
    private int etm;

    public ETM() {}

    public ETM(int etm) {
        this.etm = etm;
    }
}