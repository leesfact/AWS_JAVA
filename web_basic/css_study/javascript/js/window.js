
// window 객체는 기본 객체이므로 ‘window.’를 생략하고 메서드 이름만 사용해도 됨
//console.log(document);


//  location

//console.log(location.href);


//location.href = "https://www.naver.com";

const naverButton = document.getElementsByTagName("button");
naverButton[0].onclick = () => {
    //location.href = "https://www.naver.com";

    location.replace("https://www.naver.com");
}

naverButton[1].onclick = () => {
    location.href ="http://127.0.0.1:5500/css_study/javascript/array.html";
}