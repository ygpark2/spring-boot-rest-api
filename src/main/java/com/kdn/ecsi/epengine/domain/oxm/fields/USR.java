package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldUSR")
@XmlAccessorType(XmlAccessType.FIELD)
public final class USR {
    @Getter
    @XmlAttribute(name="v")
    private String usr;

    public USR() {}

    public USR(String usr) {
        this.usr = usr;
    }
}