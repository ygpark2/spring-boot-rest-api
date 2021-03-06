package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldBCAPA")
@XmlAccessorType(XmlAccessType.FIELD)
public final class BCAPA {
    @Getter
    @XmlAttribute(name="v")
    private int bcapa;

    public BCAPA() {}

    public BCAPA(int bcapa) {
        this.bcapa = bcapa;
    }
}