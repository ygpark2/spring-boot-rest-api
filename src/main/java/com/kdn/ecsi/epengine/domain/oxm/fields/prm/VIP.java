package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import lombok.Getter;

import javax.xml.bind.annotation.*;

@XmlType(name="RequestBodyFieldVIP")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "vip" )
public final class VIP extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private String vip;

    public VIP() {}

    public VIP(String vip) {
        this.vip = vip;
    }
}