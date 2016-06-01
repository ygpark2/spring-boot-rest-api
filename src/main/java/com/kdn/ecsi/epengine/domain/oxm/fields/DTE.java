package com.kdn.ecsi.epengine.domain.oxm.fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;

@XmlType(name="RequestBodyFieldDTE")
@XmlAccessorType(XmlAccessType.FIELD)
public final class DTE {
    @Getter
    @XmlAttribute(name="v")
    private int dte;

    public DTE() {}

    public DTE(int dte) {
        this.dte = dte;
    }
}
