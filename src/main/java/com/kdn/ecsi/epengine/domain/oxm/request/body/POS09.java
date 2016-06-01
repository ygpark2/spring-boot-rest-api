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
@XmlType( name="RequestBodyPOS09", propOrder = { "pdt", "ptm", "cwh",  "eiwh",  "prc",  "camt",  "prst",  "bwh",  "elpsec",  "est"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS09 { // implements EvcomBody {
    private PDT 	pdt;
    private PTM 	ptm;
    private CWH 	cwh;
    private EIWH	eiwh;
    private PRC		prc;
    private CAMT	camt;
    private PRST	prst;
    private BWH		bwh;
    private ELPSEC	elpsec;
    private EST		est;
    
    public POS09() {}

    public POS09(int pdt, int ptm, int cwh, int eiwh, int prc, int camt, int prst, int bwh, int elpsec, int est) {
        this.pdt   	= new PDT(ptm);
        this.ptm   	= new PTM(ptm);
        this.cwh  	= new CWH(cwh);
        this.eiwh  	= new EIWH(eiwh);
        this.prc  	= new PRC(prc);
        this.camt   = new CAMT(camt);
        this.prst  	= new PRST(prst);
        this.bwh  	= new BWH(bwh);
        this.elpsec = new ELPSEC(elpsec);
        this.est  	= new EST(est);
    }

    public int getPdt() {
        return this.pdt.getPdt();
    }

    public int getPtm() {
        return this.ptm.getPtm();
    }

    public int getCwh() {
        return this.cwh.getCwh();
    }

    public int getEiwh() {
        return this.eiwh.getEiwh();
    }

    public int getPrc() {
        return this.prc.getPrc();
    }

    public int getCamt() {
        return this.camt.getCamt();
    }

    public int getPrst() {
        return this.prst.getPrst();
    }

    public int getBwh() {
        return this.bwh.getBwh();
    }

    public int getElpsec() {
        return this.elpsec.getElpsec();
    }

    public int getEst() {
        return this.est.getEst();
    }
}