package com.kdn.ecsi.epengine.domain.oxm;

import com.kdn.ecsi.epengine.domain.oxm.fields.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.xml.bind.annotation.*;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@XmlType( propOrder = { "stm", "sid", "cid", "sts", "tid" } )
@XmlAccessorType(XmlAccessType.FIELD)
public class EvcomRequestHead { // extends EvcomHead {

    @XmlElement(name = "stm", required = true, nillable = false)
    private STM stm;
    @XmlElement(name = "sid", required = true, nillable = false)
    private SID sid;
    @XmlElement(name = "cid", required = true, nillable = false)
    private CID cid;
    @XmlElement(name = "sts", required = true, nillable = false)
    private STS sts;
    @XmlElement(name = "tid", required = true, nillable = false)
    private TID tid;

    public EvcomRequestHead() {}

    public EvcomRequestHead(long stm, int sid, String cid, int sts, int tid) {
        this.stm = new STM(stm);
        this.sid = new SID(sid);
        this.cid = new CID(cid);
        this.sts = new STS(sts);
        this.tid = new TID(tid);
    }

    public long getStm() {
        return this.stm.getStm();
    }

    public int getSid() {
        return this.sid.getSid();
    }

    public String getCid() {
        return (String) this.cid.getCid();
    }

    public int getSts() {
        return this.sts.getSts();
    }

    public int getTid() {
        return this.tid.getTid();
    }
}
