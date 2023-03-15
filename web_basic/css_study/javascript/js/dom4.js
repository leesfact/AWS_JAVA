

const addButton = document.getElementsByClassName("add-button");
addButton[0].onclick = () => {
    const todoText = document.getElementsByClassName("todo-text");
    const todoList = document.getElementsByClassName("todo-list");

    if (todoText[0].value === "") {
        alert("입력하지 않았습니다.");
        return;
    }

    const li = document.createElement("li");
    li.innerHTML += `
        <input type="checkbox" class="ok-check"> <span class="todo-content">${todoText[0].value}</span>
    `;
    todoList[0].appendChild(li);
    todoText[0].value = "";
    addEvent();
}



function addEvent() {
    const okCheck = document.getElementsByClassName("ok-check");
    const todoContent = document.getElementsByClassName("todo-content");
    for(let i = 0; i < okCheck.length; i++) {
        okCheck[i].onchange = () => {
            if(okCheck[i].checked){
                todoContent[i].style.color = 'red';
                todoContent[i].style.textDecoration = 'line-through';
            }else {
                todoContent[i].style.color = 'black';
                todoContent[i].style.textDecoration = 'none';
            }
        }
    }
}