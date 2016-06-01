package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import javax.xml.bind.annotation.*;

import lombok.Getter;

@XmlType(name="RequestBodyFieldRTRM")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "rtrm" )
public final class RTRM extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private int rtrm;

    public RTRM() {}

    public RTRM(int rtrm) {
        this.rtrm = rtrm;
    }
}
