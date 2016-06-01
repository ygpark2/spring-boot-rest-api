package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCCNT")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CCNT {
    @Getter
    @XmlAttribute(name="v")
    private int ccnt;

    public CCNT() {}

    public CCNT(int ccnt) {
        this.ccnt = ccnt;
    }
}
