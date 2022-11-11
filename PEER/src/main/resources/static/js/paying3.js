/**
 * 
 */
// 참고 링크 : https://velog.io/@jyleedev/%EC%95%84%EC%9E%84%ED%8F%AC%ED%8A%B8-API-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EA%B0%95%EC%9D%98-%EA%B2%B0%EC%A0%9C-%EA%B5%AC%ED%98%84-%EC%84%9C%EB%B2%84-%EA%B2%80%EC%A6%9D

// 결제 api코드

// $(document).ready(function(){
// }); -> 문서가 준비되면 제일 먼저 실행하는 함수
$(document).ready(function() {
	$("#iamportPayment").click(function() {
		iamportPayment(); // 버튼 클릭하면 호출, #iamport는 iamport()함수를 호출
	});
}) // 버튼 클릭하면 실행

var msg;
/** 결제 **/
// 결제 금액, 구매자의 이름, 이메일
const priceAmount = $('#totalPrice').val();
const buyerMemberEmail = $('#memberEmail').val();
const buyerMemberName = $('#memberName').val();
// const form = document.getElementById("payment");

console.log(priceAmount);
console.log(buyerMemberName);
console.log(buyerMemberEmail);
const IMP = window.IMP;
IMP.init('imp80310113');

function requestPay() {
    // IMP.request_pay(param, callback) 결제창 호출
    IMP.request_pay({ // param
        pg: "html5_inicis",
        pay_method: "card",
        merchant_uid: '99' + new Date().getTime(),
        name: "Helpring 강의",
        amount: 100,
        buyer_email: buyerMemberEmail,
        buyer_name: buyerMemberName,

    }, function (rsp) { // callback

        // 결제 검증
        $.ajax({
            type: 'POST',
            url: '/verifyIamport/'+rsp.imp_uid,
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            }
        }).done(function(result){

            // rsp.paid_amount와 result.response.amount(서버 검증) 비교 후 로직 실행
            if(rsp.paid_amount === result.response.amount){
                alert("결제가 완료되었습니다.");
                $.ajax({
                    type:'POST',
                    url:'/lecture/payment',
                    beforeSend: function(xhr){
                        xhr.setRequestHeader(header, token);
                    }
                }).done(function() {
                    window.location.reload();
                }).fail(function(error){
                        alert(JSON.stringify(error));
                })
            } else{
                alert("결제에 실패했습니다."+"에러코드 : "+rsp.error_code+"에러 메시지 : "+rsp.error_message);

            }
        })
    });
};