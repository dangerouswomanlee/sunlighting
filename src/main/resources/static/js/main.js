console.log("Site Loaded");

function openImage(src) {
    document.getElementById("modalImg").src = src;
    document.getElementById("imageModal").style.display = "flex";
}

function closeImage() {
    document.getElementById("imageModal").style.display = "none";
}

/* 슬라이드 */

window.addEventListener("DOMContentLoaded", function () {

    const slides = document.querySelectorAll(".slide");
    const nextBtn = document.querySelector(".next");
    const prevBtn = document.querySelector(".prev");

    let current = 0;

    function showSlide(index) {
        slides[current].classList.remove("active");
        current = (index + slides.length) % slides.length;
        slides[current].classList.add("active");
    }

    function nextSlide() { showSlide(current + 1); }
    function prevSlide() { showSlide(current - 1); }

    // 자동 슬라이드
    let autoSlide = setInterval(nextSlide, 3000);

    // 버튼 이벤트
    nextBtn.addEventListener("click", function () {
        nextSlide();
        resetAuto();
    });

    prevBtn.addEventListener("click", function () {
        prevSlide();
        resetAuto();
    });

    function resetAuto() {
        clearInterval(autoSlide);
        autoSlide = setInterval(nextSlide, 3000);
    }

});
