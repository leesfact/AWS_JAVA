window.onload = () => {
    console.log("온로드 테스트");

    let calc = new Calc("김준일",50); //Calc -> let 자료형이 없기때문에
    calc.showInfo();
    Calc.staticPrint(); // 자바스크립트에서는 클래스명을 통해서 스태틱에 접근
    console.log(Calc.testNumber2);
    TestService.getInstance().showTestPrint();

}

function add(a,b) {
    return a+b ;
}





    
console.log(add(10,20));
    
    
/* 
*  Javascript에서의 Class
*  #은 private를 의미
*  자료형은 선언하지 않는다
*  멤버변수 또는 멤버메소드를 참조할 떄는 항상 this를 붙인다.
*  멤버메소드를 정의할 때는 function 키워드를 사용하지 않는다.
*  생성자는 constructor로 정의
*/
   
   
   
class Calc {
    #PI = null;     
    
    testNumber = 10;
    static testNumber2 = 20;
    name = null;
    age = null;
       
    constructor(name, age){
        if(typeof name == "string" && typeof age == "number"){
            this.name = name;
            this.age = age;
        }else if(typeof name == "string") {
            this.name = name;
            this.age = null;
        }else if(typeof name =="number") {
            this.name = null;
            this.age = name;
        }else {
            this.name = null;
            this.age = null;
        }
    }
        
    showInfo() {
    console.log(this.#PI);
    console.log(this.testNumber);
    console.log(this.testNumber2);
    console.log(this.name);
    console.log(this.age);
    }
    
    
    static staticPrint() {
        console.log("스태틱  테스트");
    }
}


// 오브젝트 객체

let Calc2 = {
    name : "김준일",
    age : 30,
    showInfo: function(){
        console.log(Calc2.name);
        console.log(Calc2.age);
    }
}



// Singleton 적용


class TestService {
    static #instance = null;
    static getInstance() {
        if(this.#instance ==null){
            this.#instance = new TestService();
        }
        return this.#instance
    }

    showTestPrint() {
        console.log("싱글톤 테스트 출력");
    }
}