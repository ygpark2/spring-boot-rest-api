package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCWY")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CWY {
    @Getter
    @XmlAttribute(name="v")
    private int cwy;

    public CWY() {}

    public CWY(int cwy) {
        this.cwy = cwy;
    }
}
