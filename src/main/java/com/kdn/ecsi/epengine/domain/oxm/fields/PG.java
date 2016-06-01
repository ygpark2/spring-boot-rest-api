package com.kdn.ecsi.epengine.domain.oxm.fields;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="RequestBodyFieldPG")
@XmlAccessorType(XmlAccessType.FIELD)
public final class PG {
    @Getter
    private PG_KND pg_knd;

    @Getter
    private VER ver;

    public PG() {}

    public PG(String pg_knd, String ver) {
        this.pg_knd = new PG_KND(pg_knd);
        this.ver   	= new VER(ver);
    }
}