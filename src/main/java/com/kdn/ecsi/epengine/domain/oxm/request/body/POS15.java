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
@XmlType( name="RequestBodyPOS15", propOrder = { "loc", "ath", "usr", "pdt", "ptm", "piwh", "cwy", "ramt", "rwh", "sdt", "stm", "pwy", "cwh", "prc", "camt", "prst", "edt", "etm", "elpsec", "rst", "uiwh"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS15 { // implements EvcomBody {
    private LOC		loc;
    private ATH		ath;
    private USR		usr;
    private PDT		pdt;
    private PTM		ptm;
    private PIWH	piwh;
    private CWY		cwy;
    private RAMT	ramt;
    private RWH		rwh;
    private SDT		sdt;
    private STM		stm;
    private PWY		pwy;
    private CWH		cwh;
    private PRC		prc;
    private CAMT	camt;
    private PRST	prst;
    private EDT		edt;
    private ETM		etm;
    private ELPSEC	elpsec;
    private RST		rst;
    private UIWH	uiwh;
    
    public POS15() {}

    public POS15( int loc, int ath, String usr, int pdt, int ptm, int piwh, int cwy, int ramt, int rwh, 
    				int sdt, long stm, int pwy, int cwh, int prc, int camt, int prst, int edt, int etm, int elpsec, int rst, int uiwh) {
        this.loc      	= new LOC(loc);
        this.ath   	    = new ATH(ath);
        this.usr   	    = new USR(usr);
        this.pdt   	    = new PDT(pdt);
        this.ptm   	    = new PTM(ptm);
        this.piwh  	    = new PIWH(piwh);
        this.cwy   	    = new CWY(cwy);
        this.ramt  	    = new RAMT(ramt);
        this.rwh   	    = new RWH(rwh);
        this.sdt   	    = new SDT(sdt);
        this.stm   	    = new STM(stm);
        this.pwy   	    = new PWY(pwy);
        this.cwh   	    = new CWH(cwh);
        this.prc   	    = new PRC(prc);
        this.camt  	    = new CAMT(camt);
        this.prst  	    = new PRST(prst);
        this.edt   	    = new EDT(edt);
        this.etm   	    = new ETM(etm);
        this.elpsec	    = new ELPSEC(elpsec);
        this.rst   	    = new RST(rst);
        this.uiwh  	    = new UIWH(uiwh);
    }


    public int getLoc() {
        return this.loc.getLoc();
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

    public int getCwy() { return this.cwy.getCwy(); }

    public int getRamt() {
        return this.ramt.getRamt();
    }

    public int getRwh() {
        return this.rwh.getRwh();
    }

    public int getSdt() {
        return this.sdt.getSdt();
    }

    public long getStm() {
        return this.stm.getStm();
    }

    public int getPwy() {
        return this.pwy.getPwy();
    }

    public int getCwh() {
        return this.cwh.getCwh();
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

    public int getEdt() { 
    	return this.edt.getEdt(); 
    }

    public int getEtm() {
        return this.etm.getEtm();
    }

    public int getElpsec() {
        return this.elpsec.getElpsec();
    }

    public int getRst() {
        return this.rst.getRst();
    }

    public int getUiwh() {
        return this.uiwh.getUiwh();
    }
}