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
@XmlType( name="RequestBodyPOS10", propOrder = { "pdt", "ptm", "uwh"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS10 { // implements EvcomBody {
    private PDT 	pdt;
    private PTM 	ptm;
    private UWH 	uwh;
   
    
    public POS10() {}

    public POS10(int pdt, int ptm, int uwh) {
        this.pdt   	= new PDT(ptm);
        this.ptm   	= new PTM(ptm);
        this.uwh  	= new UWH(uwh);
    }

    public int getPdt() {
        return this.pdt.getPdt();
    }

    public int getPtm() {
        return this.ptm.getPtm();
    }

    public int getUwh() {
        return this.uwh.getUwh();
    }
}