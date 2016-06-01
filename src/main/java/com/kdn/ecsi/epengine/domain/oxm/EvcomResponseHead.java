package com.kdn.ecsi.epengine.domain.oxm;

import com.kdn.ecsi.epengine.domain.oxm.EvcomHead;
import com.kdn.ecsi.epengine.domain.oxm.fields.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@XmlType( propOrder = { "stm", "sid", "cid", "rcd", "rms", "tid" } )
@XmlAccessorType(XmlAccessType.FIELD)
public class EvcomResponseHead { // extends EvcomHead {
    private STM stm;
    private SID sid;
    private CID cid;
    private RCD rcd;
    private RMS rms;
    private TID tid;

    public EvcomResponseHead() {}

    public EvcomResponseHead(long stm, int sid, String cid, int rcd, String rms, int tid) {
        this.stm = new STM(stm);
        this.sid = new SID(sid);
        this.cid = new CID(cid);
        this.rcd = new RCD(rcd);
        this.rms = new RMS(rms);
        this.tid = new TID(tid);
    }
}
