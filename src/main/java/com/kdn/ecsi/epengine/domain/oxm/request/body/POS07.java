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
@XmlType( name="RequestBodyPOS07", propOrder = { "pdt", "ptm", "siwh", "cwy", "ramt", "rwh", "pwy", "bsts", "bcapa", "bwh", "bvolt", "rmnsec", "bms"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS07 { // implements EvcomBody {
    private PDT 	pdt;
    private PTM 	ptm;
    private SIWH 	siwh;
    private CWY 	cwy;
    private RAMT 	ramt;
    private RWH 	rwh;
    private PWY 	pwy;
    private BSTS	bsts;
    private BCAPA	bcapa;
    private BWH 	bwh;
    private BVOLT 	bvolt;
    private RMNSEC 	rmnsec;
    private BMS	 	bms;
    
    public POS07() {}

    public POS07(int pdt, int ptm, int siwh, int cwy, int ramt, int rwh, int pwy, int bsts, int bcapa, int bwh, int bvolt, int rmnsec, String bms) {
        this.pdt   	= new PDT(ptm);
        this.ptm   	= new PTM(ptm);
        this.siwh  	= new SIWH(siwh);
        this.cwy   	= new CWY(cwy);
        this.ramt  	= new RAMT(ramt);
        this.rwh   	= new RWH(rwh);
        this.pwy   	= new PWY(pwy);
        this.bsts  	= new BSTS(bsts);
        this.bcapa 	= new BCAPA(bcapa);
        this.bwh   	= new BWH(bwh);
        this.bvolt 	= new BVOLT(bvolt);
        this.rmnsec	= new RMNSEC(rmnsec);
        this.bms   	= new BMS(bms);
    }

    public int getPdt() {
        return this.pdt.getPdt();
    }

    public int getPtm() {
        return this.ptm.getPtm();
    }

    public int getSiwh() {
        return this.siwh.getSiwh();
    }

    public int getCwy() {
        return this.cwy.getCwy();
    }

    public int getRamt() {
        return this.ramt.getRamt();
    }

    public int getRwh() {
        return this.rwh.getRwh();
    }

    public int getPwy() {
        return this.pwy.getPwy();
    }

    public int getBsts() {
        return this.bsts.getBsts();
    }

    public int getBcapa() {
        return this.bcapa.getBcapa();
    }

    public int getBwh() {
        return this.bwh.getBwh();
    }

    public int getBvolt() {
        return this.bvolt.getBvolt();
    }

    public int getRmnsec() {
        return this.rmnsec.getRmnsec();
    }

    public String getBms() {
        return this.bms.getBms();
    }
}
