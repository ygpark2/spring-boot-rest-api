package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import javax.xml.bind.annotation.*;

import lombok.Getter;

@XmlType(name="RequestBodyFieldVTRM")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "vtrm" )
public final class VTRM extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private int vtrm;

    public VTRM() {}

    public VTRM(int vtrm) {
        this.vtrm = vtrm;
    }
}