package com.kdn.ecsi.epengine.domain.oxm;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomResponse {

    @XmlElement(name = "hd")
    private EvcomResponseHead hd;

    @XmlElement(name = "bd")
    protected EvcomResponseBody bd;

    public EvcomResponse() {

    }

    public EvcomResponse(EvcomResponseHead hd, EvcomResponseBody bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
