package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import javax.xml.bind.annotation.*;

import lombok.Getter;

@XmlType(name="RequestBodyFieldVPT")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "vpt" )
public final class VPT extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private String vpt;

    public VPT() {}

    public VPT(String vpt) {
        this.vpt = vpt;
    }
}