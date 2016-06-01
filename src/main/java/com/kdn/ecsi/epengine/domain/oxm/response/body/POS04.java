package com.kdn.ecsi.epengine.domain.oxm.response.body;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.kdn.ecsi.epengine.domain.oxm.EvcomBody;
import com.kdn.ecsi.epengine.domain.oxm.fields.CNO;
import com.kdn.ecsi.epengine.domain.oxm.fields.PYN;

/**
 * Created by ygpark2 on 15. 10. 27.
 */
@XmlType( name="ResponseBodyPOS04", propOrder = { "cno", "pyn"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS04 { // implements EvcomBody {
    private CNO cno;
    private PYN pyn;

    public POS04() {}

    public POS04(String cno, int pyn) {
        this.cno = new CNO(cno);
        this.pyn = new PYN(pyn);
    }

    public int getPyn() {
        return this.pyn.getPyn();
    }

    public String getCno() {
        return this.cno.getCno();
    }
}
