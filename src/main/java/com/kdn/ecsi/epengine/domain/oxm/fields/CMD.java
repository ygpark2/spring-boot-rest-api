package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCMD")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CMD {
    @Getter
    @XmlAttribute(name="v")
    private String cmd;

    public CMD() {}

    public CMD(String cmd) {
        this.cmd = cmd;
    }
}