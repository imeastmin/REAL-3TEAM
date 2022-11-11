package peer.service.booking;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

public class Paying1Service {
/*
	@PostMapping
	public void confirmPay(@RequestParam("imp_uid")String imp_uid) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		JSONObject body = new JSONObject();
		
	private String getToken() {
		System.out.println("getToken");
		headers.setContentType(MediaType.APPLICATION_JSON);
		body.put("imp_key",imp_key);
		body.put("imp_secret", imp_secret);
		try {
			HttpEntity<JSONObject>entity = new HttpEntity<JSONObject>(body,headers);
			impTokenDto impTokenDto = restTemplate.postForObject(impGetTokenUrl, entity, impTokenDto.class);
			System.out.println(impTokenDto.toString() + "결제토큰");
			return impTokenDto.getResponse().getAsString("access_token");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getToken error");
			throw new RuntimeException("아임포트 토큰 발급에 실패했습니다.");
		}finally {
			headers.clear();
			body.clear();
		}
	}
	
	
	private JSONObject getBuyInfor(String token, String impId) {
		System.out.println("getBuyInfor");
		headers.add("Authorization", token);
		HttpEntity<JSONObject>entity = new HttpEntity<JSONObject>(headers);
		
		try {
			buyInforDto buyInforDto = restTemplate.postForObject(impGetInforUrl+impId, entity, buyInforDto.class);
			System.out.println(buyInforDto.toString() + "결제정보");
			return buyInforDto.getResponse();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getBuyInfor error");
			throw new RuntimeException("getBuyInfor 결제 정보 불러오기 실패");
		}finally {
			headers.clear();
			body.clear();
		}
	}
	

	}
*/
	}

