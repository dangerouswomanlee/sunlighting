document.addEventListener('DOMContentLoaded', function () {
    var deleteForm = document.getElementById('delete-form');
    if (deleteForm) {
        deleteForm.addEventListener('submit', function (e) {
            if (!confirm('이 문의를 삭제하시겠습니까?')) {
                e.preventDefault();
            }
        });
    }
});
