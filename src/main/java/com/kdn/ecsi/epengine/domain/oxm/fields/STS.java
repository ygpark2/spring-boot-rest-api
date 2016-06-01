package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldSTS")
@XmlAccessorType(XmlAccessType.FIELD)
public final class STS {
    @Getter
    @XmlAttribute(name="v")
    private int sts;

    public STS() {}

    public STS(int sts) {
        this.sts = sts;
    }
}