package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import lombok.Getter;

import javax.xml.bind.annotation.*;

@XmlType(name="RequestBodyFieldEIP")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "eip" )
public final class EIP extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private String eip;

    public EIP() {}

    public EIP(String eip) {
        this.eip = eip;
    }
}