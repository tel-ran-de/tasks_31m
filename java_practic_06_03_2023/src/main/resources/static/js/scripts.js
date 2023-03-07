$(function () {

    var id;

    $('.btn-danger').click(function () {
        $(".modal").addClass("active");
        $('#modal_category_name').text($(this).attr("data-category_name"));
        id = $(this).attr("data-category_id");
    });
    $('#close_modal').click(function () {
        $('.modal').removeClass("active");
    });
    $('#yes-modal').click(function () {
        $.get("/deleteCategory/" + id)
            .done(function(data){
                location.reload();
            });
        $('.modal').removeClass("active");
    });
    $('#no-modal').click(function () {
        $('.modal').removeClass("active");
    });
});