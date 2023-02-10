$(function () {
     accountnumberok = false;
  	 accountnumberok2 = false;
     password1ok = false;
     password2ok = false;
     membernameok = false;
     emailok = false;
     idnumberok = false;
     cardok = false;
    

    let wrong = '<i class="fa-regular fa-circle-xmark"></i>'
    $('#createAccount').on('click', function () {

        let wrong = '<i class="fa-regular fa-circle-xmark"></i>'
        idno = $('#idnumber').val();//身分證
        function AAZZ() {
            var ABC = [];
            for (let i = 65; i <= 90; i++) {
                var str = i + "";
                var AtoZ = String.fromCharCode(str);
                ABC.push(AtoZ);
            }
            return ABC;
        }
        var aazz = function () {
            var number = [];
            for (let i = 97; i <= 122; i++) {
                var str = i + "";
                var atoz = String.fromCharCode(str)
                number.push(atoz);
            }
            return number;
        }

        if (idno.length == 0) {
            $('#idnumber').next().css('color', 'red').html(wrong + '必填')
        } else {

            if ((idno.length == 10) &&
                ((AAZZ().indexOf(idno[0])) || aazz.indexOf(idno[0])) &&
                (idno[1] == 1 || idno[1] == 2)) {
                var idnotrue = idno.toUpperCase();//小寫轉大寫
                if (!isNaN(parseInt(idno.substring(2)))) {//判斷後面為數值
                    var locnumber;
                    // 轉換地區碼
                    var loc = AAZZ().indexOf(idnotrue[0]);
                    if (loc <= 7) {
                        var locnumber = loc + 10;
                    } else if (loc == 8) {
                        var locnumber = 34;
                    } else if (loc > 8 && loc < 14) {
                        var locnumber = loc + 9;
                    } else if (loc == 14) {
                        var locnumber = 35;
                    } else if (loc > 14 && loc < 22) {
                        var locnumber = loc + 8;
                    } else if (loc == 22) {
                        var locnumber = 32;
                    } else if (loc == 23) {
                        var locnumber = 30;
                    } else if (loc == 24) {
                        var locnumber = 31;
                    } else if (loc == 25) {
                        var locnumber = 33;
                    }
                    //檢查碼
                    if (
                        ((10 - ((Math.floor(locnumber / 10) + ((locnumber % 10) * 9) + (idnotrue[1] * 8) + (idnotrue[2] * 7) + (idnotrue[3] * 6) + (idnotrue[4] * 5) + (idnotrue[5] * 4) + (idnotrue[6] * 3) + (idnotrue[7] * 2) + (idnotrue[8] * 1)) % 10)) % 10) == idnotrue[9]
                    ) {
                        $('#idnumber').next().empty();
                        idnumberok = true;
                        return idnotrue + "OK";
                    } else {
                        $('#idnumber').next().css('color', 'red').html(wrong + '請填入正確身分證字號')
                        idnumberok = false;
                        return "xx";
                    }
                } else {
                    $('#idnumber').next().css('color', 'red').html(wrong + '請填入正確身分證字號')
                    idnumberok = false;
                    return "xx";
                }

            } else {
                $('#idnumber').next().css('color', 'red').html(wrong + '請填入正確身分證字號')
                idnumberok = false;
                return "xx";
            }
        }
    })

    //-------帳號確認
    $('#createAccount').on('click', function () {

        let accountnumber = $('#accountnumber').val();
        if ((accountnumber.length >= 6) && (accountnumber.length <= 20)) {
            $('#accountnumber').next().empty();
            accountnumberok = true;

        } else {
            $('#accountnumber').next().css('color', 'red').html(wrong + '需輸入6-20字')
            accountnumberok = false;
        }

    })
    //----------密碼重複確認
    $('#createAccount').on('click', function () {
        let password1 = $('#memberpassword').val();
        let password2 = $('#RepeatPassword').val();

        if (password1 == password2) {
            $('#RepeatPassword').next().empty();
            password2ok = true;
        } else {
            password2ok = false;
            $('#RepeatPassword').next().css('color', 'red').html(wrong + '輸入錯誤')
        }

    })

    //---------密碼確認
    $('#createAccount').on('click', function () {

        let password = $('#memberpassword').val();
        let hasCapital = false;
        let hasLower = false;
        for (i = 0; i < password.length; i++) {
            if (password[i] >= 'A' && password[i] <= 'Z') { hasCapital = true }
            if (password[i] >= 'a' && password[i] <= 'z') { hasLower = true }
        }
        if ((password.length >= 8 && password.length <= 20) && hasCapital && hasLower) {
            $('#memberpassword').next().empty();
            password1ok = true;
        } else {
            password1ok = false;
            $('#memberpassword').next().css('color', 'red').html(wrong + '需輸入8-20字含英文大小寫')
        }

    })
    //---------名字
    $('#createAccount').on('click', function () {
        let membername = $('#membername').val();
        if (membername.length > 0) {
            $('#membername').next().empty();
            membernameok = true;
        } else {
            $('#membername').next().css('color', 'red').html(wrong + '必填')
            membernameok = false;
        }
    })
    //-----------信用卡
    $('#createAccount').on('click', function () {
        let card1 = $('#cardnumber').find('.div-card').eq(0).children().val();
        let card2 = $('#cardnumber').find('.div-card').eq(1).children().val();
        let card3 = $('#cardnumber').find('.div-card').eq(2).children().val();
        let card4 = $('#cardnumber').find('.div-card').eq(3).children().val();
        if (card1.length == 0 && card2.length == 0 && card3.length == 0 & card4.length == 0) {
            $('#cardnumber').next().css('color', 'red').html(wrong + '必填')
        } else {
            if (card1.length == 4 && card2.length == 4 && card3.length == 4 & card4.length == 4) {
                $('#cardnumber').next().empty();
                cardok = true;
            } else {
                $('#cardnumber').next().css('color', 'red').html(wrong + '請填入正確卡號')
                cardok = false;
            }
        }

    })
    //------信用卡跳格
    let maxlength = 4;
    $('.card-input2').keyup(function () {
        let contentLength = $(this).val().length;
        if (contentLength == maxlength) {
            $(this).parent().next().find('.card-input2').focus()
        }
    })

    //-------------email

    $('#createAccount').on('click', function () {
        let email = $('#email').val();
        if (email.length > 0) {
            if (email.indexOf('@') != -1) {
                $('#email').next().empty();
                emailok = true;
            }
            else {
                $('#email').next().css('color', 'red').html(wrong + '請填入正確email')
                emailok = false;
            }
        } else {
            $('#email').next().css('color', 'red').html(wrong + '必填')
            emailok = false;
        }

    })
    



})