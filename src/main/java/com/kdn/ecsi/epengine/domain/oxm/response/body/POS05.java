package com.kdn.ecsi.epengine.domain.oxm.response.body;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.kdn.ecsi.epengine.domain.oxm.EvcomBody;
import com.kdn.ecsi.epengine.domain.oxm.fields.PYN;
import com.kdn.ecsi.epengine.domain.oxm.fields.UNO;

/**
 * Created by ygpark2 on 15. 10. 27.
 */
@XmlType( name="ResponseBodyPOS05", propOrder = { "uno", "pyn"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS05 { // implements EvcomBody {
    private UNO uno;
    private PYN pyn;

    public POS05() {}

    public POS05(String uno, int pyn) {
        this.uno = new UNO(uno);
        this.pyn = new PYN(pyn);
    }

    public int getPyn() {
        return this.pyn.getPyn();
    }

    public String getCno() {
        return this.uno.getUno();
    }
}
