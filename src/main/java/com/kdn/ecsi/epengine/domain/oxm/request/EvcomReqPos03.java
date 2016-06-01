package com.kdn.ecsi.epengine.domain.oxm.request;

import com.kdn.ecsi.epengine.domain.oxm.Evcom;
import com.kdn.ecsi.epengine.domain.oxm.EvcomRequestHead;
import com.kdn.ecsi.epengine.domain.oxm.request.body.POS03;
import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( name="RequestPOS03", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomReqPos03 {

    @Getter
    @XmlElement(name = "hd")
    private EvcomRequestHead hd;

    @Getter
    @XmlElement(name = "bd")
    private POS03 bd;

    public EvcomReqPos03() {

    }

    public EvcomReqPos03(EvcomRequestHead hd, POS03 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
