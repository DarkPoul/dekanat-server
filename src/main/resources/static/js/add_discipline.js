// Отримуємо посилання на елементи DOM
const plusButton = document.getElementById('plus-button-type-control');
const submenu = document.getElementById('submenu');

// Функція для перевірки умови та переключення стану підменю
function toggleSubmenu() {
    const isSubmenuVisible = !submenu.classList.contains('hidden');
    if (isSubmenuVisible) {
        // Підменю відкрите, закриваємо його
        submenu.classList.add('hidden');
    } else {
        // Підменю зачинено, відкриваємо його
        submenu.classList.remove('hidden');
    }
}

// Обробник натискання на кнопку зі значком плюс
plusButton.addEventListener('click', () => {
    // Викликаємо функцію переключення стану підменю
    toggleSubmenu();
});


// Отримуємо посилання на елементи DOM
const plusButton_2 = document.getElementById('plus-button-type-control_2');
const submenu_2 = document.getElementById('submenu_2');

// Функція для перевірки умови та переключення стану підменю
function toggleSubmenu_2() {
    const isSubmenuVisible = !submenu_2.classList.contains('hidden');
    if (isSubmenuVisible) {
        // Підменю відкрите, закриваємо його
        submenu_2.classList.add('hidden');
    } else {
        // Підменю зачинено, відкриваємо його
        submenu_2.classList.remove('hidden');
    }
}

// Обробник натискання на кнопку зі значком плюс
plusButton_2.addEventListener('click', () => {
    // Викликаємо функцію переключення стану підменю
    toggleSubmenu_2();
});


