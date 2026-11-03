// Opens and closes the navigation menu on small screens.
// On a laptop the menu is always visible, so this does nothing there.

const toggle = document.querySelector(".navbar-toggle");
const links = document.querySelector(".navbar-links");

toggle.addEventListener("click", function () {
  links.classList.toggle("open");
  toggle.textContent = links.classList.contains("open") ? "\u2715" : "\u2630";
});

// close the menu after tapping any link
links.querySelectorAll("a").forEach(function (link) {
  link.addEventListener("click", function () {
    links.classList.remove("open");
    toggle.textContent = "\u2630";
  });
});