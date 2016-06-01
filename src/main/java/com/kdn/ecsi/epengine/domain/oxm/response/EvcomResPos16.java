package com.kdn.ecsi.epengine.domain.oxm.response;

import com.kdn.ecsi.epengine.domain.oxm.EvcomResponseHead;
import com.kdn.ecsi.epengine.domain.oxm.response.body.POS16;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( name="ResponsePOS16", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomResPos16 {

    @Getter
    @XmlElement(name = "hd")
    private EvcomResponseHead hd;

    @Getter
    @XmlElement(name = "bd")
    private POS16 bd;

    public EvcomResPos16() {

    }

    public EvcomResPos16(EvcomResponseHead hd, POS16 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
