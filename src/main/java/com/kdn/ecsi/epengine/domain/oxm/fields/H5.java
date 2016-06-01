package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldH5")
@XmlAccessorType(XmlAccessType.FIELD)
public final class H5 {
    @Getter
    @XmlAttribute(name="v")
    private int h5;

    public H5() {}

    public H5(int h5) {
        this.h5 = h5;
    }
}