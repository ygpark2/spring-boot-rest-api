package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import lombok.Getter;

import javax.xml.bind.annotation.*;

@XmlType(name="RequestBodyFieldMOD")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "mod" )
public final class MOD extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private int mod;

    public MOD() {}

    public MOD(int mod) {
        this.mod = mod;
    }
}