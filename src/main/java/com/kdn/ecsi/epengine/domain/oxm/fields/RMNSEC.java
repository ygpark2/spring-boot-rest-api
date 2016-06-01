package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldRMNSEC")
@XmlAccessorType(XmlAccessType.FIELD)
public final class RMNSEC {
    @Getter
    @XmlAttribute(name="v")
    private int rmnsec;

    public RMNSEC() {}

    public RMNSEC(int rmnsec) {
        this.rmnsec = rmnsec;
    }
}