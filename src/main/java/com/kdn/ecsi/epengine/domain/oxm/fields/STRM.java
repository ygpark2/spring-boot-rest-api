package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldSTRM")
@XmlAccessorType(XmlAccessType.FIELD)
public final class STRM {
    @Getter
    @XmlAttribute(name="v")
    private int strm;

    public STRM() {}

    public STRM(int strm) {
        this.strm = strm;
    }
}
