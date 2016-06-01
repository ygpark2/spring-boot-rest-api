package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="ResponseBodyFieldCNO")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CNO {
    @Getter
    @XmlAttribute(name="v")
    private String cno;

    public CNO() {}

    public CNO(String cno) {
        this.cno = cno;
    }
}
