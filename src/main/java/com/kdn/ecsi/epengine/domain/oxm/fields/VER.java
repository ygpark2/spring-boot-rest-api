package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldVER")
@XmlAccessorType(XmlAccessType.FIELD)
public final class VER {
    @Getter
    @XmlAttribute(name="v")
    private String ver;

    public VER() {}

    public VER(String ver) {
        this.ver = ver;
    }
}