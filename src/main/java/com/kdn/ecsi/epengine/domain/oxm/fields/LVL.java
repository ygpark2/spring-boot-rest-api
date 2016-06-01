package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldLVL")
@XmlAccessorType(XmlAccessType.FIELD)
public final class LVL {
    @Getter
    @XmlAttribute(name="v")
    private int lvl;

    public LVL() {}

    public LVL(int lvl) {
        this.lvl = lvl;
    }
}