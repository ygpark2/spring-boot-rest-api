package com.kdn.ecsi.epengine.domain.oxm.request;

import com.kdn.ecsi.epengine.domain.oxm.EvcomRequestHead;
import com.kdn.ecsi.epengine.domain.oxm.request.body.POS05;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( name="RequestPOS05", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomReqPos05 {

    @Getter
    @XmlElement(name = "hd")
    private EvcomRequestHead hd;

    @Getter
    @XmlElement(name = "bd")
    private POS05 bd;

    public EvcomReqPos05() {

    }

    public EvcomReqPos05(EvcomRequestHead hd, POS05 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
