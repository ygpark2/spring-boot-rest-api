package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import javax.xml.bind.annotation.*;

import lombok.Getter;

@XmlType(name="RequestBodyFieldSTRM")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "strm" )
public final class STRM extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private int strm;

    public STRM() {}

    public STRM(int strm) {
        this.strm = strm;
    }
}
