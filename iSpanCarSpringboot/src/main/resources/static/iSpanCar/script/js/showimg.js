//在input file內容改變的時候觸發事件
$('#file').change(function () {
    //獲取input file的files文件數組;
    //$('#filed')獲取的是jQuery對象，.get(0)轉為原生對象;
    //這邊預設只能選一個，但是存放形式仍然是數組，所以取第一個元素使用[0];
    var file = $('#file').get(0).files[0];
    //創建用來讀取此文件的對象
    var reader = new FileReader();
    //使用該對象讀取file文件
    reader.readAsDataURL(file);
    //讀取文件成功後執行的方法函數
    reader.onload = function (e) {
        //讀取成功後返回的一個參數e，整個的一個進度事件
        console.log(e);
        //選擇所要顯示圖片的img，要賦值給img的src就是e中target下result裡面
        //的base64編碼格式的地址
        $('#imgshow').get(0).src = e.target.result;
    }
})
$('#imgshowbox').css('text-align', 'center')