// JavaScript
let add_disc = document.getElementById('plus-button');
let plusButton = document.getElementById('plus-button-type-control');
let submenu = document.getElementById('submenu');
setLinkDisabled(true);

function toggleSubmenu() {
    const isSubmenuVisible = !submenu.classList.contains('hidden');
    if (isSubmenuVisible) {
        submenu.classList.add('hidden');
    } else {
        submenu.classList.remove('hidden');
    }
}

plusButton.addEventListener('click', () => {
    toggleSubmenu();
});

let plusButton_2 = document.getElementById('plus-button-type-control_2');
let submenu_2 = document.getElementById('submenu_2');

function toggleSubmenu_2() {
    const isSubmenuVisible = !submenu_2.classList.contains('hidden');
    if (isSubmenuVisible) {
        submenu_2.classList.add('hidden');
    } else {
        submenu_2.classList.remove('hidden');
    }
}

plusButton_2.addEventListener('click', () => {
    toggleSubmenu_2();
});

add_disc.addEventListener("click", function (event) {
    if (add_disc.classList.contains("disabled")) {
        event.preventDefault();
    }
});

function setLinkDisabled(disabled) {
    if (disabled) {
        add_disc.classList.add('disabled');
    } else {
        add_disc.classList.remove('disabled');
    }
}

function select_group() {
    const selectElement = document.getElementById("group_select");
    const selectedValue = selectElement.value;
    if (selectedValue === '0') {
        setLinkDisabled(true);
    } else {
        setLinkDisabled(false);
    }
    // console.log(selectedValue);
}



function add_disc_to_training_plan(){
    let name_disc = document.getElementById('searchInput');
    let choice_disc = document.getElementById('choice_disc');
    let first_control = document.getElementById('first_control');
    let first_control_department = document.getElementById('first_control_department');
    let second_control = document.getElementById('second_control');
    let second_control_department = document.getElementById('second_control_department');
    let hours = document.getElementById('hours');
    let number_of_parts = document.getElementById('number_of_parts');

    console.log(name_disc.value);
    console.log(choice_disc.checked);
    console.log(first_control.value);
    console.log(first_control_department.value);
    console.log(second_control.value);
    console.log(second_control_department.value);
    console.log(number_of_parts.value);
    console.log(hours.value);

    const toSend = {
        name: name_disc.value,
        email: first_control.value
    }



    fetch('/get_plan', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify(toSend),
    })
        .then(response => {
            if (response.ok) {
                console.log('Дані успішно відправлені до сервера');
            } else {
                console.error('Сталася помилка при відправленні даних до сервера');
            }
        })
        .catch(error => {
            console.error('Сталася помилка:', error);
        });
}


