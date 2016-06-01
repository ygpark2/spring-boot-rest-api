package com.kdn.ecsi.epengine.domain.oxm;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class Evcom {

    @XmlElement
    private EvcomHead hd;

    @XmlElement
    private EvcomBody bd;

    public Evcom() {

    }

    public Evcom(EvcomHead hd, EvcomBody bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
