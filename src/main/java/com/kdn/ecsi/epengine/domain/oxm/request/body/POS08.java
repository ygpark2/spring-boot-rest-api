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
@XmlType( name="RequestBodyPOS08", propOrder = { "pdt", "ptm", "iiwh", "cwh", "camt", "bsts", "bwh", "bvolt", "bamp", "btemp", "rmnsec"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS08 { // implements EvcomBody {
    private PDT 	pdt;
    private PTM 	ptm;
    private IIWH 	iiwh;
    private CWH 	cwh;
    private CAMT 	camt;
    private BSTS	bsts;
    private BWH 	bwh;
    private BVOLT 	bvolt;
    private BAMP 	bamp;
    private BTEMP 	btemp;
    private RMNSEC 	rmnsec;
    
    public POS08() {}

    public POS08(int pdt, int ptm, int iiwh, int cwh, int camt, int bsts, int bwh, int bvolt, int bamp, Float btemp, int rmnsec) {
        this.pdt   	= new PDT(ptm);
        this.ptm   	= new PTM(ptm);
        this.iiwh  	= new IIWH(iiwh);
        this.cwh   	= new CWH(cwh);
        this.camt  	= new CAMT(camt);
        this.bsts   = new BSTS(bsts);
        this.bwh   	= new BWH(bwh);
        this.bvolt  = new BVOLT(bvolt);
        this.bamp 	= new BAMP(bamp);
        this.btemp  = new BTEMP(btemp);
        this.rmnsec	= new RMNSEC(rmnsec);
    }

    public int getPdt() {
        return this.pdt.getPdt();
    }

    public int getPtm() {
        return this.ptm.getPtm();
    }

    public int getIiwh() {
        return this.iiwh.getIiwh();
    }

    public int getCwh() {
        return this.cwh.getCwh();
    }

    public int getCamt() {
        return this.camt.getCamt();
    }

    public int getBsts() {
        return this.bsts.getBsts();
    }

    public int getBwh() {
        return this.bwh.getBwh();
    }

    public int getBvolt() {
        return this.bvolt.getBvolt();
    }

    public int getBamp() {
        return this.bamp.getBamp();
    }

    public Float getBtemp() {
        return this.btemp.getBtemp();
    }

    public int getRmnsec() {
        return this.rmnsec.getRmnsec();
    }
}
