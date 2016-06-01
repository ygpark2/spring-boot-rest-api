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
@XmlType( name="RequestBodyPOS16", propOrder = { "acd", "tdt", "ttm", "cdt", "ctm", "sts", "lvl"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS16 { // implements EvcomBody {
    private ACD		acd;
    private TDT		tdt;
    private TTM		ttm;
    private CDT		cdt;
    private CTM		ctm;
    private STS		sts;
    private LVL		lvl;
    
    public POS16() {}

    public POS16(String acd, int tdt, int ttm, int cdt, int ctm, int sts, int lvl) {
        this.acd      	= new ACD(acd);
        this.tdt   	    = new TDT(tdt);
        this.ttm   	    = new TTM(ttm);
        this.cdt   	    = new CDT(cdt);
        this.ctm   	    = new CTM(ctm);
        this.sts   	    = new STS(sts);
        this.lvl   	    = new LVL(lvl);
    }

    public String getAcd() {
        return this.acd.getAcd();
    }

    public int getTdt() {
        return this.tdt.getTdt();
    }

    public int getTtm() {
        return this.ttm.getTtm();
    }

    public int getCdt() {
        return this.cdt.getCdt();
    }

    public int getCtm() {
        return this.ctm.getCtm();
    }

    public int getSts() {
        return this.sts.getSts();
    }

    public int getLvl() {
        return this.lvl.getLvl();
    }
}