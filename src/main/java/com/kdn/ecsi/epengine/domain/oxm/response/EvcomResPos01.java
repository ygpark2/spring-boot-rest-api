package com.kdn.ecsi.epengine.domain.oxm.response;

import com.kdn.ecsi.epengine.domain.oxm.Evcom;
import com.kdn.ecsi.epengine.domain.oxm.EvcomResponseHead;
import com.kdn.ecsi.epengine.domain.oxm.response.body.POS01;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( name="ResponsePOS01", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomResPos01 extends Evcom {

    @XmlElement(name = "hd")
    private EvcomResponseHead hd;

    @XmlElement(name = "bd")
    protected POS01 bd;

    public EvcomResPos01() {

    }

    public EvcomResPos01(EvcomResponseHead hd, POS01 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
