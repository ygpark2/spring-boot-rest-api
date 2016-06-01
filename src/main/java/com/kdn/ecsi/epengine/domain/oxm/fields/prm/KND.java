package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import lombok.Getter;

import javax.xml.bind.annotation.*;

@XmlType(name="RequestBodyFieldKND")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "knd" )
public final class KND extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private String knd;

    public KND() {}

    public KND(String knd) {
        this.knd = knd;
    }
}
