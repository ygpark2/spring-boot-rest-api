package com.kdn.ecsi.epengine.domain.oxm.response;

import com.kdn.ecsi.epengine.domain.oxm.EvcomResponseHead;
import com.kdn.ecsi.epengine.domain.oxm.response.body.GET02;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 29.
 */
@XmlType( name="ResponseGET02", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomResGet02 {

    @Getter
    @XmlElement(name = "hd")
    private EvcomResponseHead hd;

    @Getter
    @XmlElement(name = "bd")
    protected GET02 bd;

    public EvcomResGet02() {

    }

    public EvcomResGet02(EvcomResponseHead hd, GET02 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}