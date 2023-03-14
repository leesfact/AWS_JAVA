let numbers1 = [1,2,3,4,5];
let numbers2 = [6,7,8,9,10];
let numbers3 = new Array();


// concat
let numbers4 = numbers1.concat(numbers2);

console.log(numbers1);
console.log(typeof numbers2);
console.log(typeof numbers3);

console.log(numbers4);


function odd(num) {
    return num % 2 !=0;
} 
// filter
let numbers5 = numbers4.filter(odd);
console.log(numbers5);


let numbers6 = numbers4.filter(n => n % 2 != 0);
console.log(numbers6);


// basic for
for(let i = 0; i < numbers5.length; i++){
    console.log("i: "+ numbers5[i]);
}

// for - each (자바에선 `:` //자바스크립트 : `of`)
for(let num of numbers5){
    console.log(`forEach: ${num}`)
}

// java
// List<String> list = new ArrayList<String>();
// localStorage.forEach(n -> {});


// javascript
numbers5.forEach(n => console.log(`ArrayForEach: ${n}`));


// indexOf 해당 인덱스 찾기
console.log(numbers5.indexOf(5));

// 마지막 인자값이 어느 index에 존재하는지 못찾으면 -1
console.log(numbers5.lastIndexOf(2));

// join(" ") 
console.log(numbers5.join(","));

// push (add)
console.log(numbers5.push(11));
console.log(numbers5)

// unshift 배열의 가장 앞에 값 추가 
console.log(numbers5.unshift(13));
console.log(numbers5)

// pop (제일 마지막 요소를 제거)
console.log(numbers5.pop());
console.log(numbers5)

// splice (추가와 삭제를 동시에)
// splice(start index, delete count, add number)
// 배열도 넣을 수 있음
numbers5.splice(2,1,15,17);
console.log(numbers5);

// slice (해당 영역 추출)
console.log(numbers5.slice(3,6));

// sort 
console.log(numbers5.sort(function(a, b) {
    return a - b;
}));

// reverse
console.log(numbers5.reverse());

//toString
console.log(numbers5.toString());



const backButton = document.getElementsByTagName("button");
backButton[0].onclick = () => {
    history.back();
}

