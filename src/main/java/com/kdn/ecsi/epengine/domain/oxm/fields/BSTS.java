package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldBSTS")
@XmlAccessorType(XmlAccessType.FIELD)
public final class BSTS {
    @Getter
    @XmlAttribute(name="v")
    private int bsts;

    public BSTS() {}

    public BSTS(int bsts) {
        this.bsts = bsts;
    }
}