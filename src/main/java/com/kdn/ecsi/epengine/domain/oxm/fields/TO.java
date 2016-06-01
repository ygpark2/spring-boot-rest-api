package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldTO")
@XmlAccessorType(XmlAccessType.FIELD)
public final class TO {
    @Getter
    @XmlAttribute(name="v")
    private String to;

    public TO() {}

    public TO(String to) {
        this.to = to;
    }
}