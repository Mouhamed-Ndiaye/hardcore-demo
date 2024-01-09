let menuicn = document.querySelector(".menuicn");
let nav = document.querySelector(".navcontainer");

menuicn.addEventListener("click", () => {
    nav.classList.toggle("navclose");
})


document.querySelector('.option2').addEventListener('click', function () {
    loadSection('cours');
});

document.querySelector('.option3').addEventListener('click', function () {
    loadSection('exercices');
});
function loadSection(section) {
    fetch('/' + section)
        .then(response => response.text())
        .then(data => {
            document.querySelector('.main').innerHTML = data;
            history.pushState({section: section}, '', '/' + section);
        })
        .catch(error => console.error('Erreur lors du chargement de la section', error));
}

window.addEventListener('popstate', function (event) {
    if (event.state && event.state.section) {
        loadSection(event.state.section);
    }
});
document.addEventListener('DOMContentLoaded', function () {
    var menuOptions = document.querySelectorAll('.nav-option');

    menuOptions.forEach(function (option) {
        option.addEventListener('click', function () {
            menuOptions.forEach(function (opt) {
                opt.classList.remove('selected');
            });
            option.classList.add('selected');

            let section = option.textContent.trim().toLowerCase();
            loadSection(section);
        });
    });
});
