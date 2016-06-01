package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldTTM")
@XmlAccessorType(XmlAccessType.FIELD)
public final class TTM {
    @Getter
    @XmlAttribute(name="v")
    private int ttm;

    public TTM() {}

    public TTM(int ttm) {
        this.ttm = ttm;
    }
}