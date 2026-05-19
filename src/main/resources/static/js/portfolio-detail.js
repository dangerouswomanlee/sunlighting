document.addEventListener('DOMContentLoaded', function () {
    var modal = document.getElementById('imageModal');
    var modalImg = document.getElementById('modalImg');

    document.querySelectorAll('.detail-photo').forEach(function (img) {
        img.addEventListener('click', function () {
            modalImg.src = this.src;
            modal.style.display = 'flex';
        });
        img.addEventListener('error', function () {
            this.style.display = 'none';
        });
    });

    if (modal) {
        modal.addEventListener('click', function () {
            this.style.display = 'none';
        });
    }
});
