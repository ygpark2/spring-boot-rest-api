package com.kdn.ecsi.epengine.domain.oxm.response.body;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.kdn.ecsi.epengine.domain.oxm.EvcomBody;
import com.kdn.ecsi.epengine.domain.oxm.response.*;
import com.kdn.ecsi.epengine.domain.oxm.fields.*;

/**
 * Created by ygpark2 on 15. 10. 27.
 */
@XmlType( name="ResponseBodyGET02",
          propOrder = { "ctp", "ver", "h0", "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10",
						"h11", "h12", "h13", "h14", "h15", "h16", "h17", "h18", "h19", "h20", "h21", "h22", "h23"} )
@XmlAccessorType(XmlAccessType.FIELD)
public class GET02 { // extends EvcomBody {
    private CTP ctp;
    private VER ver;
    private H0  h0;
    private H1  h1;
    private H2  h2;
    private H3  h3;
    private H4  h4;
    private H5  h5;
    private H6  h6;
    private H7  h7;
    private H8  h8;
    private H9  h9;
    private H10 h10;
    private H11 h11;
    private H12 h12;
    private H13 h13;
    private H14 h14;
    private H15 h15;
    private H16 h16;
    private H17 h17;
    private H18 h18;
    private H19 h19;
    private H20 h20;
    private H21 h21;
    private H22 h22;
    private H23 h23;

    public GET02() {}

    public GET02(int ctp, String ver, int h0, int h1, int h2, int h3, int h4, int h5, int h6, int h7, int h8, int h9, 
    		     int h10, int h11, int h12, int h13, int h14, int h15, int h16, int h17, int h18, int h19, int h20, int h21, int h22, int h23) {
        this.ctp = new CTP(ctp);
        this.ver = new VER(ver);
        this.h0  = new H0(h0);
        this.h1  = new H1(h1);
        this.h2  = new H2(h2);
        this.h3  = new H3(h3);
        this.h4  = new H4(h4);
        this.h5  = new H5(h5);
        this.h6  = new H6(h6);
        this.h7  = new H7(h7);
        this.h8  = new H8(h8);
        this.h9  = new H9(h9);
        this.h10 = new H10(h10);
        this.h11 = new H11(h11);
        this.h12 = new H12(h12);
        this.h13 = new H13(h13);
        this.h14 = new H14(h14);
        this.h15 = new H15(h15);
        this.h16 = new H16(h16);
        this.h17 = new H17(h17);
        this.h18 = new H18(h18);
        this.h19 = new H19(h19);
        this.h20 = new H20(h20);
        this.h21 = new H21(h21);
        this.h22 = new H22(h22);
        this.h23 = new H23(h23);
    }

    public int getCtp() {
        return this.ctp.getCtp();
    }

    public String getVer() {
        return this.ver.getVer();
    }

    public int getH0() {
        return this.h0.getH0();
    }

    public int getH1() {
        return this.h1.getH1();
    }

    public int getH2() {
        return this.h2.getH2();
    }

    public int getH3() {
        return this.h3.getH3();
    }

    public int getH4() {
        return this.h4.getH4();
    }

    public int getH5() {
        return this.h5.getH5();
    }

    public int getH6() {
        return this.h6.getH6();
    }

    public int getH7() {
        return this.h7.getH7();
    }

    public int getH8() {
        return this.h8.getH8();
    }

    public int getH9() {
        return this.h9.getH9();
    }

    public int getH10() {
        return this.h10.getH10();
    }

    public int getH11() {
        return this.h11.getH11();
    }

    public int getH12() {
        return this.h12.getH12();
    }

    public int getH13() {
        return this.h13.getH13();
    }

    public int getH14() {
        return this.h14.getH14();
    }

    public int getH15() {
        return this.h15.getH15();
    }

    public int getH16() {
        return this.h16.getH16();
    }

    public int getH17() {
        return this.h17.getH17();
    }

    public int getH18() {
        return this.h18.getH18();
    }

    public int getH19() {
        return this.h19.getH19();
    }

    public int getH20() {
        return this.h20.getH20();
    }

    public int getH21() {
        return this.h21.getH21();
    }

    public int getH22() {
        return this.h22.getH22();
    }

    public int getH23() {
        return this.h23.getH23();
    }
}

