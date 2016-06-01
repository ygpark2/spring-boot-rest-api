package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import javax.xml.bind.annotation.*;

import lombok.Getter;

@XmlType(name="RequestBodyFieldCTRM")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "ctrm" )
public final class CTRM extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private int ctrm;

    public CTRM() {}

    public CTRM(int ctrm) {
        this.ctrm = ctrm;
    }
}