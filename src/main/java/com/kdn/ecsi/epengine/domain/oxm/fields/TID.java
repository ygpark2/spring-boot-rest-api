package com.kdn.ecsi.epengine.domain.oxm.fields;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by ygpark2 on 15. 11. 12.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public final class TID {
    @Getter
    @XmlAttribute(name="v")
    private int tid;

    public TID() {}

    public TID(int tid) {
        this.tid = tid;
    }
}