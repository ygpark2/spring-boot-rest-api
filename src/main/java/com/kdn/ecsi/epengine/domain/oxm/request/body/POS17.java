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
@XmlType( name="RequestBodyPOS17", propOrder = { "dte", "cwh", "ccnt", "acnt", "camt", "pscnt", "pfcnt"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS17 { // implements EvcomBody {
    private DTE		dte;
    private CWH		cwh;
    private CCNT	ccnt;
    private ACNT	acnt;
    private CAMT	camt;
    private PSCNT	pscnt;
    private PFCNT	pfcnt;
    
    public POS17() {}

    public POS17(int dte, int cwh, int ccnt, int acnt, int camt, int pscnt, int pfcnt) {
        this.dte     	= new DTE(dte);
        this.cwh  	    = new CWH(cwh);
        this.ccnt  	    = new CCNT(ccnt);
        this.acnt  	    = new ACNT(acnt);
        this.camt  	    = new CAMT(camt);
        this.pscnt      = new PSCNT(pscnt);
        this.pfcnt      = new PFCNT(pfcnt);
    }

    public int getDte() {
        return this.dte.getDte();
    }

    public int getCwh() {
        return this.cwh.getCwh();
    }

    public int getCcnt() {
        return this.ccnt.getCcnt();
    }

    public int getAcnt() {
        return this.acnt.getAcnt();
    }

    public int getCamt() {
        return this.camt.getCamt();
    }

    public int getPscnt() {
        return this.pscnt.getPscnt();
    }

    public int getPfcnt() {
        return this.pfcnt.getPfcnt();
    }
}