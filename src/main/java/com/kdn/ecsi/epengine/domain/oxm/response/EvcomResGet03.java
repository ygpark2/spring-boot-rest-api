package com.kdn.ecsi.epengine.domain.oxm.response;

import com.kdn.ecsi.epengine.domain.oxm.EvcomResponseHead;
import com.kdn.ecsi.epengine.domain.oxm.response.body.GET03;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 29.
 */
@XmlType( name="ResponseGET03", propOrder = { "hd", "bd" } )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "evcom")
public class EvcomResGet03 {

    @Getter
    @XmlElement(name = "hd")
    private EvcomResponseHead hd;

    @Getter
    @XmlElement(name = "bd")
    protected byte[] bd;

    public EvcomResGet03() {

    }

	public EvcomResGet03(EvcomResponseHead hd, byte[] bd) {
        this.hd = hd;
        this.bd = bd;
	}

}
