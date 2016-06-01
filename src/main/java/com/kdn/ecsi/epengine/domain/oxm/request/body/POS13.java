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
@XmlType( name="RequestBodyPOS13", propOrder = { "ctp", "ver"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS13 { // implements EvcomBody {
    private CTP 	ctp;
    private VER 	ver;
    
    public POS13() {}

    public POS13(int ctp, String ver) {
        this.ctp   	= new CTP(ctp);
        this.ver   	= new VER(ver);
    }

    public int getCtp() { return this.ctp.getCtp(); }

    public String getVer() {
        return this.ver.getVer();
    }
}