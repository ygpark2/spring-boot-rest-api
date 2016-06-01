package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import lombok.Getter;

import javax.xml.bind.annotation.*;

@XmlType(name="RequestBodyFieldTO")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "to" )
public final class TO extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private String to;

    public TO() {}

    public TO(String to) {
        this.to = to;
    }
}