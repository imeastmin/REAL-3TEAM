/**
 * 
 */
$(document).ready(function(){

$('.input-daterange').datepicker({
    format: 'yyyy-mm-dd',
    autoclose: true,
    startDate: '0d',
    endDate: '+60d',
    clearBtn: true,		//날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션
    showWeekDays: true, // 위에 요일 보여주는 옵션 기본값 : true
    title: '날짜선택', //캘린더 상단에 보여주는 타이틀
    todayHighlight: true, //오늘 날짜에 하이라이팅 기능 기본값 :false
    language: 'ko', //달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
    
});

});