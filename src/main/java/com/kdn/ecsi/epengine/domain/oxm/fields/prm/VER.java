package com.kdn.ecsi.epengine.domain.oxm.fields.prm;

import lombok.Getter;

import javax.xml.bind.annotation.*;

@XmlType(name="RequestBodyFieldVER")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement( name = "ver" )
public final class VER extends PRM {
    @Getter
    @XmlAttribute(name="v")
    private String ver;

    public VER() {}

    public VER(String ver) {
        this.ver = ver;
    }
}