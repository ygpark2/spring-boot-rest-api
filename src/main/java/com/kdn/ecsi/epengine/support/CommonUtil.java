package com.kdn.ecsi.epengine.support;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kdn.ecsi.epengine.domain.CsInfo;
import com.kdn.ecsi.epengine.domain.EquipInfo;
import com.kdn.ecsi.epengine.domain.QCsInfo;
import com.kdn.ecsi.epengine.domain.QEquipInfo;
import com.kdn.ecsi.epengine.repositories.CsInfoRepository;
import com.kdn.ecsi.epengine.repositories.EquipInfoRepository;

public class CommonUtil {

    /**
     * 현재 시간(yyyyMMddHHmss)을 구한다.
     * 
     * @author jeongmin
     * @since 2015-11-17
     * @param
     * @return ecrdt
     */
	public long getNowDate(){

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat d_format = new SimpleDateFormat("yyyyMMddHHmmss");
        String erdt = d_format.format(cal.getTime());
        long ecrdt =Long.parseLong(erdt);
        
        return ecrdt;
	}
	
	/**
	 * long 타입형을 Date 타입형으로 변환 한다.
	 * 
	 * @author jeongmin
	 * @since 2015-11-17
	 * @param lupdatetime
	 * @return dupdatetime
	 */
	public Date dateTime(long lupdatetime){
		
	    String supdatetime = String.valueOf(lupdatetime);
	    String y = supdatetime.substring(0, 4);
	    String m = supdatetime.substring(4, 6);
	    String d = supdatetime.substring(6, 8);
	    String h = supdatetime.substring(8, 10);
	    String mi = supdatetime.substring(10, 12);
	    String s = supdatetime.substring(12, 14);
	    String supdatetime2 = y+"-"+m+"-"+d+" "+h+":"+mi+":"+s;
	    Date dupdatetime = null;
		try {
			dupdatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(supdatetime2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    return dupdatetime;
	}
	
	/**
	 * 장치번호를 구한다.
	 * 
	 * @author jeongmin
	 * @since 2015-11-17
	 * @param sid
	 * @param cid
	 * @param equipInfoRepository
	 * @return ei.getEqpNum();
	 */
	public int getEqpNum(int sid, String cid, EquipInfoRepository equipInfoRepository){
		
		QEquipInfo qei = QEquipInfo.equipInfo;
		EquipInfo ei = null;
		ei = equipInfoRepository.findOne(qei.csInfo.csId.eq(String.valueOf(sid))
				.and(qei.eqpId.eq(cid)).and(qei.protocolInfo.protocolType.eq(2)));
		
		return ei.getEqpNum();
	}
	
	/**
	 * 충전완료 남은 시간으로 충전완료일 계산
	 * 
	 * @author jeongmin
	 * @since 2015-11-17
	 * @param rmnsec
	 * @return endDate
	 */
	public String sumChrgingEndDate(int rmnsec){
		String endDate = null;
		Calendar cal = new GregorianCalendar(Locale.KOREA);
		cal.add(Calendar.SECOND, rmnsec);
		SimpleDateFormat sDformat = new SimpleDateFormat("yyyyMMdd");
		endDate = sDformat.format(cal.getTime());
		return endDate;
	}

	/**
	 * 충전완료 남은 시간으로 충전완료시간 계산
	 * 
	 * @author jeongmin
	 * @since 2015-11-17
	 * @param rmnsec
	 * @return endTime
	 */
	public String sumChrgingEndTime(int rmnsec){
		String endTime = null;
		Calendar cal = new GregorianCalendar(Locale.KOREA);
		cal.add(Calendar.SECOND, rmnsec);
		SimpleDateFormat sDformat = new SimpleDateFormat("HHmmss");
		endTime = sDformat.format(cal.getTime());
		return endTime;
	}
	
	/**
	 * 6자리 String 타입으로 시간 맞추기
	 * 
	 * @author jeongmin
	 * @since 2015-11-19
	 * @param time
	 * @return sixTime
	 */
	public String timeChack(int time){
		String sixTime = String.valueOf(time);
		for (int i = 0; i < 7; i++) {
			if(sixTime.length()<6){
				sixTime = "0"+sixTime;
			}else{
				break;
			}
		}
		return sixTime;
	}
	
	/**
	 * 총용량과 현재 충전량으로 작업진행률을 구한다
	 * 
	 * @author jeongmin
	 * @since 2015-11-19
	 * @param chogi
	 * @param chong
	 * @return rate
	 */
	public BigDecimal chargingRate(int chogi, BigDecimal chong){
		float f1 = chogi;
		float f2 = f1/Float.valueOf(String.valueOf(chong));
		float f3 = f2 * 100;
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
		String d1 = df.format(f3);
		double d2 = Double.valueOf(d1);
		BigDecimal rate = BigDecimal.valueOf(d2);
		return rate;
	}
	
	/**
	 * 에러 체크 60초 이상 차이나면 false리턴
	 * 
	 * @author jeongmin
	 * @since 2015-11-20
	 * @param stm
	 * @return result
	 */
	public boolean checkTime(long stm){
		boolean result = false;

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat d_format = new SimpleDateFormat("yyyyMMddHHmmss");
        String erdt = d_format.format(cal.getTime());
        long ecrdt =Long.parseLong(erdt);
        long m;
        if(ecrdt > stm){
        	m = ecrdt - stm;
        }else{
        	m = stm - ecrdt;
        }
        if(m < 60){
        	result = true;
        } 
		return result;
	}
	
	/**
	 * 충전소 확인
	 * 
	 * @author jeongmin
	 * @since 2015-11-20
	 * @param urlSid
	 * @param hSid
	 * @param csInfoRepository
	 * @return result
	 */
	public boolean ckeckSid(int urlSid, int hSid, CsInfoRepository csInfoRepository){
		boolean result = false;
		boolean result1 = true;
		QCsInfo qci = QCsInfo.csInfo;
		CsInfo ci = null;
		Iterable<CsInfo> cia = csInfoRepository.findAll(qci.delYn.isNull());
		cia.forEach(c -> {
			c.setDelYn("N");
		});
		csInfoRepository.save(cia);
		
		if((urlSid != hSid)){
			result1 = false;
		}
		ci = csInfoRepository.findOne(qci.csId.eq(String.valueOf(urlSid)).and(qci.delYn.eq("N")));
		if(ci != null && result1){
			result = true;
		}
		return result;
	}
	/**
	 * 충전소 확인(URL에 충전소아이디 없을경우)
	 * 
	 * @author jeongmin
	 * @since 2015-11-23
	 * @param hSid
	 * @param csInfoRepository
	 * @param cid
	 * @param equipInfoRepository
	 * @return result
	 */
	public boolean ckeckSid(int hSid, CsInfoRepository csInfoRepository){
		boolean result = false;
		QCsInfo qci = QCsInfo.csInfo;
		CsInfo ci = null;
		Iterable<CsInfo> cia = csInfoRepository.findAll(qci.delYn.isNull());
		cia.forEach(c -> {
			c.setDelYn("N");
		});
		csInfoRepository.save(cia);
		ci = csInfoRepository.findOne(qci.csId.eq(String.valueOf(hSid)).and(qci.delYn.eq("N")));
		if(ci != null){
			result = true;
		}
		return result;
	}
	
	/**
	 * 충전기 확인
	 * 
	 * @author jeongmin
	 * @since 2015-11-20
	 * @param urlCid
	 * @param hcid
	 * @param equipInfoRepository
	 * @return result
	 */
	public boolean ckeckCid(String urlCid, String hcid, EquipInfoRepository equipInfoRepository){
		boolean result = false;
		boolean result1 = false;
		QEquipInfo qei = QEquipInfo.equipInfo;

		if(urlCid.equals(hcid)){
			result1 = true;
		}
		EquipInfo ei = null;
		Iterable<EquipInfo> eia = equipInfoRepository.findAll(qei.delYn.isNull());
		eia.forEach(c -> {
			c.setDelYn("N");
		});
		equipInfoRepository.save(eia);
		ei = equipInfoRepository.findOne(qei.eqpId.eq(String.valueOf(urlCid)).and(qei.delYn.eq("N")));
		if(ei != null && result1){
			result = true;
		}
		return result;
	}
	/**
	 * 충전기 확인(URL에 충전기ID가 없을경우)
	 * @author jeongmin
	 * @param hcid
	 * @param equipInfoRepository
	 * @return result
	 */
	public boolean ckeckCid(String hcid, EquipInfoRepository equipInfoRepository){
		boolean result = false;
		QEquipInfo qei = QEquipInfo.equipInfo;
		EquipInfo ei = null;
		Iterable<EquipInfo> eia = equipInfoRepository.findAll(qei.delYn.isNull());
		eia.forEach(c -> {
			c.setDelYn("N");
		});
		equipInfoRepository.save(eia);
		ei = equipInfoRepository.findOne(qei.eqpId.eq(String.valueOf(hcid)).and(qei.delYn.eq("N")));
		if(ei != null){
			result = true;
		}
		return result;
	}
	/**
	 * 충전기 상태 확인
	 * 
	 * @author jeongmin
	 * @since 2015-11-20
	 * @param sts
	 * @return result
	 */
	public boolean checkSts(int sts){
		boolean result = true;
		String sSts = String.valueOf(sts);

		if (sSts.length()!=6) {
			result = false;
		} else {
			for (int i = 0; i < sSts.length(); i++) {
				// (i=0)운영 모드(0: 알수 없음, 1: 운영중, 2: 운영정지, 3: 점검중)
				// (i=1)충전구 Door 상태(0: 알수 없음, 1: Close, 2: Open)
				// (i=2)충전구 plug 상태(0: 알수 없음, 1: Unplug, 2:Plug)
				// (i=3)충전상태(0: 알수 없음, 1: 대기중, 2: 충전중)
				// (i=4)비상 버튼 상태(0: 알수 없음, 1: Off, 2: On)
				// (i=5)경보 상태(0: 알수 없음, 1: 정상, 2: 발생(일반), 3: 발생(긴급))
				int cnt = Integer.parseInt(sSts.substring(i,i+1));
				if (cnt < 0){
					result = false;
					break;
				}
				if (i==0||i==5){
					if (cnt > 4) {
						result = false;
						break;
					}
				} else {
					if (cnt > 3) {
						result = false;
						break;
					}
				}
			}
		}
		return result;
	}
	/**
	 * 충전소와 충전기의 상관관계 확인
	 * 
	 * @author jeongmin
	 * @since 2015-11-26
	 * @param sid
	 * @param cid
	 * @param equipInfoRepository
	 * @return
	 */
	public boolean checkSidCid(int sid, String cid, EquipInfoRepository equipInfoRepository){
		boolean result = false;
		QEquipInfo qei = QEquipInfo.equipInfo;
		EquipInfo ei = null;
		ei = equipInfoRepository.findOne(qei.eqpId.eq(cid).and(qei.csInfo.csId.eq(String.valueOf(sid))).and(qei.protocolInfo.protocolType.eq(2)));
		if(ei != null){
			result = true;
		}
		return result;
	}
	
	
	
	/**
	 * 정규식 (한글추출)
	 * 
	 * @author Lee Jeong-il
	 * @since 2015-11-26
	 * @param line
	 * @return
	 */
    
    public static String getLanguage(String line){
    	if (line != null && line.length() !=0) {
			String tmpStr = line;
			StringBuffer sb = new StringBuffer();
			if (tmpStr.length() != 0) {
				Pattern p = Pattern.compile("[^가-힣]");
				Matcher m = p.matcher(line);
				
				while (m.find()) {
					m.appendReplacement(sb, "");
				}
				m.appendTail(sb);
			}
			return sb.toString();
		} else {
			return "";
		}
    }
	
	/**
	 * 정규식 (숫자추출)
	 * 
	 * @author Lee Jeong-il
	 * @since 2015-11-26
	 * @param line
	 * @return
	 */
    public static String getNumber(String line){
    	if (line != null && line.length() !=0) {
			String tmpStr = line;
			StringBuffer sb = new StringBuffer();
			if (tmpStr.length() != 0) {
				Pattern p = Pattern.compile("[^\\d]");
				Matcher m = p.matcher(line);
				
				while (m.find()) {
					m.appendReplacement(sb, "");
				}
				m.appendTail(sb);
			}
			return sb.toString();
		} else {
			return "";
		}
    }
	
	
}
