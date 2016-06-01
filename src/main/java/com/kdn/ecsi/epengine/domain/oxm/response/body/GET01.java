package com.kdn.ecsi.epengine.domain.oxm.response.body;

import javax.xml.bind.annotation.*;

import com.kdn.ecsi.epengine.domain.oxm.fields.CMD;
import com.kdn.ecsi.epengine.domain.oxm.fields.SQD;
import com.kdn.ecsi.epengine.domain.oxm.fields.SQN;
import com.kdn.ecsi.epengine.domain.oxm.fields.prm.*;

import java.util.List;

/**
 * Created by ygpark2 on 15. 10. 27.
 */
@XmlType( name="ResponseBodyGET01", propOrder = { "sqd", "sqn", "cmd", "prm"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class GET01 { // extends EvcomBody {

    private SQD sqd;
    private SQN sqn;
    private CMD cmd;

    @XmlElementWrapper(name = "prm")
    @XmlElements({
            @XmlElement(name="ctrm", type=CTRM.class),
            @XmlElement(name="eip",  type=EIP.class),
            @XmlElement(name="ept",  type=EPT.class),
            @XmlElement(name="fr",   type=FR.class),
            @XmlElement(name="knd",  type=KND.class),
            @XmlElement(name="mod",  type=MOD.class),
            @XmlElement(name="rtrm", type=RTRM.class),
            @XmlElement(name="strm", type=STRM.class),
            @XmlElement(name="to",   type=TO.class),
            @XmlElement(name="ver",  type=VER.class),
            @XmlElement(name="vip",  type=VIP.class),
            @XmlElement(name="vpt",  type=VPT.class),
            @XmlElement(name="vtrm", type=VTRM.class)
    })
    private List<PRM> prm;

    public GET01() {}

    public GET01(int sqd, int sqn, String cmd) {
        this.sqd = new SQD(sqd);
        this.sqn = new SQN(sqn);
        this.cmd = new CMD(cmd);
    }

    public void setPrm(List<PRM> prm) {
        this.prm = prm;
    }

    public int getSqd() {
        return this.sqd.getSqd();
    }

    public int getSqn() {
        return this.sqn.getSqn();
    }

    public String getCmd() {
        return this.cmd.getCmd();
    }
}
