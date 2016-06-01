package com.kdn.ecsi.epengine.domain.oxm.response;

import com.kdn.ecsi.epengine.domain.oxm.EvcomResponseHead;
import com.kdn.ecsi.epengine.domain.oxm.response.body.POS12;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( name="ResponsePOS12", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomResPos12 {

    @Getter
    @XmlElement(name = "hd")
    private EvcomResponseHead hd;

    @Getter
    @XmlElement(name = "bd")
    private POS12 bd;

    public EvcomResPos12() {

    }

    public EvcomResPos12(EvcomResponseHead hd, POS12 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
