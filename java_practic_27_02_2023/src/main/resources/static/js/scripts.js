$(function () {
    $('#experiment').click(function () {
        $(".modal").addClass("modal_active");
    });
    $('.modal_close-button').click(function () {
        $('.modal').removeClass("modal_active");
    });
});