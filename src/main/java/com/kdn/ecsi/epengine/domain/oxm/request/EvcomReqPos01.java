package com.kdn.ecsi.epengine.domain.oxm.request;

import com.kdn.ecsi.epengine.domain.oxm.Evcom;
import com.kdn.ecsi.epengine.domain.oxm.EvcomRequestHead;
import com.kdn.ecsi.epengine.domain.oxm.request.body.POS01;
import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( name="RequestPOS01", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomReqPos01 {

	@Getter
    @XmlElement(name = "hd")
    private EvcomRequestHead hd;

	@Getter
    @XmlElement(name = "bd")
    protected POS01 bd;

    public EvcomReqPos01() {

    }

    public EvcomReqPos01(EvcomRequestHead hd, POS01 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
