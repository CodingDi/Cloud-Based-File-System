;(function () {
    $('#tel-input').blur(telInputBlur);
    $('#psw-input').blur(pswInputBlur);
})();

function telInputBlur() {
    if($('#tel-div').hasClass("has-error")) {
        $('#tel-div').removeClass("has-error");
        $('#tel-help-block').hide();
    }
    if($('#tel-input').val().trim().length != 11) {
        $('#tel-div').addClass("has-error");
        $('#tel-help-block').show();
    }
}

function pswInputBlur() {
    if($('#psw-div').hasClass("has-error")) {
        $('#psw-div').removeClass("has-error");
        $('#psw-help-block').hide();
    }
    if($('#psw-input').val().trim() == "") {
        $('#psw-div').addClass("has-error");
        $('#psw-help-block').show();
    }
}

function preSubmit() {
    $('#tel-input').blur();
    $('#psw-input').blur();
    if($('#tel-div').hasClass("has-error") || $('#psw-div').hasClass("has-error")) {
        return false;
    } else {
        // $('#psw-input').val($.md5($('#psw-input').val()));
        return true;
    }
}
