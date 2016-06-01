package com.kdn.ecsi.epengine.domain.oxm.request;

import com.kdn.ecsi.epengine.domain.oxm.Evcom;
import com.kdn.ecsi.epengine.domain.oxm.EvcomRequestHead;
import com.kdn.ecsi.epengine.domain.oxm.request.body.GET03;
import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( name="RequestGET03", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomReqGet03 {

    @Getter
    @XmlElement(name = "hd")
    private EvcomRequestHead hd;

    @Getter
    @XmlElement(name = "bd")
    protected GET03 bd;

    public EvcomReqGet03() {

    }

    public EvcomReqGet03(EvcomRequestHead hd, GET03 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
