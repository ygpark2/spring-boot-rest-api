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
@XmlType( name="RequestBodyPOS11", propOrder = { "pmr", "pmd", "ctp", "cot", "mdn", "eip", "ept", "vip", "vpt", "mmr", "rmr", "strm", "rtrm", "ctrm", "vtrm"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS11 { // implements EvcomBody {
    private PMR 	pmr;
    private PMD 	pmd;
    private CTP 	ctp;
    private COT 	cot;
    private MDN 	mdn;
    private EIP 	eip;
    private EPT 	ept;
    private VIP 	vip;
    private VPT 	vpt;
    private MMR 	mmr;
    private RMR 	rmr;
    private STRM 	strm;
    private RTRM	rtrm;
    private CTRM	ctrm;
    private VTRM	vtrm;
    
    public POS11() {}

    public POS11(String pmr, String pmd, int ctp, int cot, String mdn, String eip, String ept, 
    			 String vip, String vpt, String mmr, String rmr, int strm, int rtrm, int ctrm, int vtrm) {
        this.pmr   	= new PMR(pmr);
        this.pmd   	= new PMD(pmd);
        this.ctp   	= new CTP(ctp);
        this.cot   	= new COT(cot);
        this.mdn   	= new MDN(mdn);
        this.eip   	= new EIP(eip);
        this.ept   	= new EPT(ept);
        this.vip   	= new VIP(vip);
        this.vpt   	= new VPT(vpt);
        this.mmr   	= new MMR(mmr);
        this.rmr   	= new RMR(rmr);
        this.strm  	= new STRM(strm);
        this.rtrm  	= new RTRM(rtrm);
        this.ctrm  	= new CTRM(ctrm);
        this.vtrm  	= new VTRM(vtrm);
        
    }

    public String getPmr() {
        return this.pmr.getPmr();
    }

    public String getPmd() {
        return this.pmd.getPmd();
    }

    public int getCtp() {
        return this.ctp.getCtp();
    }

    public int getCot() {
        return this.cot.getCot();
    }

    public String getMdn() {
        return this.mdn.getMdn();
    }

    public String getEip() {
        return this.eip.getEip();
    }

    public String getEpt() {
        return this.ept.getEpt();
    }

    public String getVip() {
        return this.vip.getVip();
    }

    public String getVpt() {
        return this.vpt.getVpt();
    }

    public String getMmr() {
        return this.mmr.getMmr();
    }

    public String getRmr() {
        return this.rmr.getRmr();
    }

    public int getStrm() {
        return this.strm.getStrm();
    }

    public int getRtrm() {
        return this.rtrm.getRtrm();
    }

    public int getCtrm() {
        return this.ctrm.getCtrm();
    }

    public int getVtrm() {
        return this.vtrm.getVtrm();
    }
}