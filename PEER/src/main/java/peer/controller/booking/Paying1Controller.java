package peer.controller.booking;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

public class Paying1Controller {

	@PostMapping
	public void confirmPay(@RequestParam("imp_uid")String imp_uid) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		JSONObject body = new JSONObject();
		body.put("imp_448280090638", imp_uid);
		body.put("6471873064075181", "jK3gBdGp0BD7KdVbpanK7QFDOjl7mGj16jSLAQUlNOJx33suFx5ap52TJOIncMq5K64Y02pvGJhsjRF2");
		try {
			HttpEntity<JSONObject>entity = new HttpEntity<>(body,headers);
			ResponseEntity<JSONObject> token = restTemplate.postForEntity("https://api.iamport.kr/users/getToken", entity, JSONObject.class);
			
			System.out.println(token + "fulltoken");
			System.out.println(token.getStatusCode() + "tgetsoken");
			System.out.println(token.getStatusCodeValue() + "getvaltoken");
			System.out.println(token.getBody() + "bodytoken");
			System.out.println(token.getBody().get("response") + "bodytoken");
			
			//restTemplate.getForEntity("https://api.iamport.kr/payments/" + imp_uid + "", JSONObject.class);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
		}
		
		
		
	}
}
