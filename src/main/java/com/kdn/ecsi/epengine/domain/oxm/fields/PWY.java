package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldPWY")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PWY {
    @Getter
    @XmlAttribute(name="v")
    private int pwy;

    public PWY() {}

    public PWY(int pwy) {
        this.pwy = pwy;
    }
}
