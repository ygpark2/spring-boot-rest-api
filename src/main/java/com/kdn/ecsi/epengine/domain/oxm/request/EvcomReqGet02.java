package com.kdn.ecsi.epengine.domain.oxm.request;

import com.kdn.ecsi.epengine.domain.oxm.Evcom;
import com.kdn.ecsi.epengine.domain.oxm.EvcomRequestHead;
import com.kdn.ecsi.epengine.domain.oxm.EvcomResponseBody;
import com.kdn.ecsi.epengine.domain.oxm.request.body.GET02;
import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( name="RequestGET02", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomReqGet02 {

    @Getter
    @XmlElement(name = "hd")
    private EvcomRequestHead hd;

    @Getter
    @XmlElement(name = "bd")
    protected GET02 bd;

    public EvcomReqGet02() {

    }

    public EvcomReqGet02(EvcomRequestHead hd, GET02 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
