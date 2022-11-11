package peer.controller.booking;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//에러 3개 @RequiredArgsConstructor
@RequestMapping("/paying3Verify")
public class VerifyController {

    // Iamport 결제 검증 컨트롤러
    private final IamportClient iamportClient;
    
    // 생성자를 통해 REST API 와 REST API secret 입력
    public VerifyController(){
        this.iamportClient = new IamportClient("6471873064075181", "jK3gBdGp0BD7KdVbpanK7QFDOjl7mGj16jSLAQUlNOJx33suFx5ap52TJOIncMq5K64Y02pvGJhsjRF2");
    }

    // 프론트에서 받은 PG사 결괏값을 통해 아임포트 토큰 발행
    @PostMapping("/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(@PathVariable String imp_uid) throws IamportResponseException, IOException{
        log.info("paymentByImpUid 진입");
        return iamportClient.paymentByImpUid(imp_uid);
    }
    
}

