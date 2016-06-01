package com.kdn.ecsi.epengine.domain.oxm;

import com.kdn.ecsi.epengine.domain.oxm.request.body.*;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@XmlType( name="EvcomRequest", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomRequest {

    @Getter
    @XmlElement(name = "hd")
    private EvcomRequestHead hd;

    @Getter
    @XmlElements(
    {
        @XmlElement(name = "bd", type=GET01.class),
        @XmlElement(name = "bd", type=GET02.class),
        @XmlElement(name = "bd", type=GET03.class),
        @XmlElement(name = "bd", type=POS01.class),
        @XmlElement(name = "bd", type=POS02.class),
        @XmlElement(name = "bd", type=POS03.class),
        @XmlElement(name = "bd", type=POS04.class),
        @XmlElement(name = "bd", type=POS05.class),
        @XmlElement(name = "bd", type=POS06.class),
        @XmlElement(name = "bd", type=POS07.class),
        @XmlElement(name = "bd", type=POS08.class),
        @XmlElement(name = "bd", type=POS09.class),
        @XmlElement(name = "bd", type=POS10.class),
        @XmlElement(name = "bd", type=POS11.class),
        @XmlElement(name = "bd", type=POS12.class),
        @XmlElement(name = "bd", type=POS13.class)
    })
    protected Object bd;

    public EvcomRequest() {

    }

    public EvcomRequest(EvcomRequestHead hd, Object bd) {
        this.hd = hd;
        this.bd = bd;
    }

}
