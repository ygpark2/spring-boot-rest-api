package com.kdn.ecsi.epengine.domain.oxm.request.body;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.kdn.ecsi.epengine.domain.oxm.fields.*;
import com.kdn.ecsi.epengine.domain.oxm.EvcomBody;
import lombok.Data;

/**
 * Created by ygpark2 on 15. 10. 27.
 */
@Data
@XmlType( name="RequestBodyPOS06", propOrder = { "ath", "usr", "pdt", "ptm", "piwh"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS06 { // implements EvcomBody {
    private ATH  ath;
    private USR  usr;
    private PDT  pdt;
    private PTM  ptm;
    private PIWH piwh;

    public POS06() {}

    public POS06(int ath, String usr, int pdt, int ptm, int piwh) {
        this.ath = new ATH(ath);
        this.usr = new USR(usr);
        this.pdt = new PDT(pdt);
        this.ptm = new PTM(ptm);
        this.piwh = new PIWH(piwh);
    }

    public int getAth() {
        return this.ath.getAth();
    }

    public String getUsr() {
        return this.usr.getUsr();
    }

    public int getPdt() {
        return this.pdt.getPdt();
    }

    public int getPtm() {
        return this.ptm.getPtm();
    }

    public int getPiwh() {
        return this.piwh.getPiwh();
    }
}