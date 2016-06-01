package com.kdn.ecsi.epengine.domain.oxm.request.body;

import javax.xml.bind.annotation.*;

import com.kdn.ecsi.epengine.domain.oxm.EvcomBody;
import com.kdn.ecsi.epengine.domain.oxm.fields.PG;

import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * Created by ygpark2 on 15. 10. 27.
 */
@Data
@XmlType( name="RequestBodyPOS14" )
@XmlAccessorType(XmlAccessType.FIELD)
public class POS14 { // implements EvcomBody {

    @XmlElements({
            @XmlElement(name="pg", type=PG.class)
    })
    private List<PG> pgs;

    public POS14() {}

}
