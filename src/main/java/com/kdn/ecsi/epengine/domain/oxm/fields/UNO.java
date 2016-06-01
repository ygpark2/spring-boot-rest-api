package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldUNO")
@XmlAccessorType(XmlAccessType.FIELD)
public final class UNO {
    @Getter
    @XmlAttribute(name="v")
    private String uno;

    public UNO() {}

    public UNO(String uno) {
        this.uno = uno;
    }
}
