package com.kdn.ecsi.epengine.domain.oxm;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ygpark2 on 15. 10. 26.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@XmlType( propOrder = { "stm", "sid", "cid", "rcd", "rms", "tid" } )
@XmlAccessorType(XmlAccessType.FIELD)
public class EvcomResponseBody { // implements EvcomBody {

	private int stm;
    private int sid;
    private String cid;
    private int rcd;
    private String rms;
    private int tid;

}
