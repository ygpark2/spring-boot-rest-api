package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import lombok.Getter;

import javax.xml.bind.annotation.*;

@XmlType(name="RequestBodyFieldEPT")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "ept" )
public final class EPT extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private String ept;

    public EPT() {}

    public EPT(String ept) {
        this.ept = ept;
    }
}