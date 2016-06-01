package com.kdn.ecsi.epengine.domain.oxm.fields;

import lombok.Getter;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ygpark2 on 15. 11. 12.
 */
@XmlType(name="RequestBodyFieldCID")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CID {

    @Getter
    @XmlAnyAttribute
    private Map<QName, Object> cid = new HashMap<>();

    public CID() {}

    public CID(Object val) {
        cid.put(new QName("v"), val);
    }

    public Object getCid() {
        return cid.get(new QName("v"));
    }

}
