package com.kdn.ecsi.epengine.domain.oxm.response;

import com.kdn.ecsi.epengine.domain.oxm.EvcomResponseHead;
import com.kdn.ecsi.epengine.domain.oxm.response.body.GET01;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 29.
 */
@XmlType( name="ResponseGET01", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomResGet01 {

    @Getter
    @XmlElement(name = "hd")
    private EvcomResponseHead hd;

    @Getter
    @XmlElement(name = "bd")
    protected GET01 bd;

    public EvcomResGet01() {

    }

    public EvcomResGet01(EvcomResponseHead hd, GET01 bd) {
        this.hd = hd;
        this.bd = bd;
    }

}