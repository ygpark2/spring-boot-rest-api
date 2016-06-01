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
@XmlType( name="RequestBodyPOS03", propOrder = { "sts", "acd", "tdt", "ttm", "cdt", "ctm", "lvl"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS03 { // implements EvcomBody {
    private STS sts;
    private ACD acd;
    private TDT tdt;
    private TTM ttm;
    private CDT cdt;
    private CTM ctm;
    private LVL lvl;

    public POS03() {}

    public POS03(int sts, String acd, int tdt, int ttm, int cdt, int ctm, int lvl) {
        this.sts = new STS(sts);
        this.acd = new ACD(acd);
        this.tdt = new TDT(tdt);
        this.ttm = new TTM(ttm);
        this.cdt = new CDT(cdt);
        this.ctm = new CTM(ctm);  
        this.lvl = new LVL(lvl);  
    }

}