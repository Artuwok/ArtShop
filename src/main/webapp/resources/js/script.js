(function ($) {
    $(document).ready(function () {
        $('#cssmenu > ul > li > a').click(function () {
            $('#cssmenu li').removeClass('active');
            $(this).closest('li').addClass('active');
            var checkElement = $(this).next();
            if ((checkElement.is('ul')) && (checkElement.is(':visible'))) {
                $(this).closest('li').removeClass('active');
                checkElement.slideUp('normal');
            }
            if ((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
                $('#cssmenu ul ul:visible').slideUp('normal');
                checkElement.slideDown('normal');
            }
            if ($(this).closest('li').find('ul').children().length == 0) {
                return true;
            } else {
                return false;
            }
        });
    });
})(jQuery);

function showCart() {
    window.location.href = "/showCart"
}

function sendId(itemToView) {
    window.location.href = "/notebooks/" + itemToView;
}

function buyItem(itemToView) {
    var URL = "/addToShoppingCart/" + itemToView;
    var data = {id: itemToView};
    $.ajax({
            type: "GET",
            url: URL
        },
        location.reload(true));
}

function fillOneNoutTable() {
    $.get("/notebooks/currentItem.json", function (data) {
        $.each(data, function (i, itemToView) {

            $(".oneNoutClass").append(
                '<div class="fillOneNoutDetails"><img src= "' + itemToView.image_url + '" + width="400px" height="300px"/>' + "<br>"
                + "<b>Item code: </b>" + itemToView.id + "<br>"
                + "<b>Item model: </b>" + itemToView.name + "<br>"
                + "<b>Price: </b>" + itemToView.price + " grn" + "<br>"
                + "<b>Description: </b>" + itemToView.description + "<br>"
                + "<input id='itemToView.id' type='button' onclick='buyItem(\"" + itemToView.id + "\");' value='Add to Cart'/>"
                + "</div>"
            );
        });
    });
}

function fillAllNouts() {
    $.get("/data/.json", function (data) {
        $.each(data, function (i, itemToView) {

            $(".mainDiv").append(
                '<div class="oneNoutDiv"><img src= "' + itemToView.image_url + '" + width="150px" height="100px"/>' + "<br>"
                + "<b>Item code: </b>" + itemToView.id + "<br>"
                + "<b>Item model: </b>" + itemToView.name + "<br>"
                + "<b>Price: </b>" + itemToView.price + " grn" + "<br>"
                + "<input id='itemToView.id' type='button' onclick='sendId(\"" + itemToView.id + "\");' value='View Details'/>"
                + "</div>"
            );
        });
    });
}