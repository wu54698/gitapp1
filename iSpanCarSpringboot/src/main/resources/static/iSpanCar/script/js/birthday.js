function creatyear() {
    var Today = new Date();
    var year = Today.getFullYear();
    var txt = "";
    for (let i = year; i >= 1900; i--) {
        txt += "<option " + ((i == year) ? "selected" : "") + " value='" + i  + "year" + "'>" + i + "</option>" + "<br>";
    }
    document.querySelector("#year").innerHTML = txt;

}

var month = [];
function createmonth() {
    var txt = "";
    for (let i = 1; i <= 12; i++) {
        txt += "<option value='" + i  + "month" + "'>" + i + "月" + "</option>" + "<br>";
        month.push(i + "month");
    }
    document.querySelector("#month").innerHTML = txt;
}

var dates = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
$('#year').blur(function yearcount() {
    var options = $("#year option:selected");
    var year = options.text();
    console.log(year)
    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
        dates[1] = 29;
    } else {
        dates[1] = 28;
    }
})

function createdate() {
    var getmonth = document.getElementById("month").value;
    var txt = "";
    var indexno = month.indexOf(getmonth);
    for (let i = 1; i <= dates[indexno]; i++) {
        txt += "<option value='" + i + "" + "'>" + i + "日" + "</option>" + "<br>";
    }
    document.querySelector("#date").innerHTML = txt;
}