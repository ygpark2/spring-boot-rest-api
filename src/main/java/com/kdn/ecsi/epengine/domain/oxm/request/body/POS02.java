package com.kdn.ecsi.epengine.domain.oxm.request.body;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.kdn.ecsi.epengine.domain.oxm.EvcomBody;
import com.kdn.ecsi.epengine.domain.oxm.fields.*;
import lombok.Data;

/**
 * Created by ygpark2 on 15. 10. 27.
 */

@Data
@XmlType( name="RequestBodyPOS02", propOrder = { "sqd", "sqn", "cmd", "rst", "rms"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS02 { // implements EvcomBody {
    private SQD sqd;
    private SQN sqn;
    private CMD cmd;
    private RST rst;
    private RMS rms;

    public POS02() {}

    public POS02(int sqd, int sqn, String cmd, int rst, String rms) {
        this.sqd = new SQD(sqd);
        this.sqn = new SQN(sqn);
        this.cmd = new CMD(cmd);
        this.rst = new RST(rst);
        this.rms = new RMS(rms);
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

    public int getRst() {
        return this.rst.getRst();
    }

    public String getRms() {
        return this.rms.getRms();
    }
}