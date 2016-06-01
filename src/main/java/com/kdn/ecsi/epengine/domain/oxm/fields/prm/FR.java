package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import lombok.Getter;

import javax.xml.bind.annotation.*;

@XmlType(name="RequestBodyFieldFR")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "fr" )
public final class FR extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private String fr;

    public FR() {}

    public FR(String fr) {
        this.fr = fr;
    }
}