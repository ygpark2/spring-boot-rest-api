package com.kdn.ecsi.epengine.domain.oxm.request;

import com.kdn.ecsi.epengine.domain.oxm.EvcomRequestHead;
import com.kdn.ecsi.epengine.domain.oxm.request.body.POS15;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( name="RequestPOS15", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomReqPos15 {

    @Getter
    @XmlElement(name = "hd")
    private EvcomRequestHead hd;

    @Getter
    @XmlElement(name = "bd")
    private POS15 bd;

    public EvcomReqPos15() {

    }

    public EvcomReqPos15(EvcomRequestHead hd, POS15 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
