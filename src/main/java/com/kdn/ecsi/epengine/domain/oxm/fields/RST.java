package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldRST")
@XmlAccessorType(XmlAccessType.FIELD)
public final class RST {
    @Getter
    @XmlAttribute(name="v")
    private int rst;

    public RST() {}

    public RST(int rst) {
        this.rst = rst;
    }
}