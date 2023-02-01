<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>所有論壇列表</title>
    <!-- Custom fonts for this template-->
    <link
            href="/iSpanCar/script/vendor/fontawesome-free/css/all.min.css"
            rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <!-- Custom styles for this template-->
    <link
            href="/iSpanCar/script/css/sb-admin-2.min.css"
            rel="stylesheet">
    <link
            href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css"
            rel="stylesheet">
    <link href="https://unpkg.com/@wangeditor/editor@latest/dist/css/style.css" rel="stylesheet">
    <style>
        #editor—wrapper {
            border: 1px solid #ccc;
            z-index: 100; /* 按需定義 */
        }

        #toolbar-container {
            border-bottom: 1px solid #ccc;
        }

        #editor-container {
            height: 500px;
        }
    </style>

    <style>
        textarea {
            background: transparent;
            border-style: none;
        }

        .container {
            margin: 30px;
            padding: 0;
        }

        input {
            border: 0;
            background-color: #2db5c2;
            color: #fff;
            border-radius: 10px;
            opacity: 1;
        }

        input:hover {

            opacity: 0.6;
        }

        form {
            display: inline;
        }


    </style>
</head>

<body id="page-top">
<c:set value="${LoginOK}" var="login"/>
<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul
            class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion bg-gradient-info"
            id="accordionSidebar">

        <!-- Sidebar - Brand 左上標誌 -->
        <a
                class="sidebar-brand d-flex align-items-center justify-content-center"
                href="index">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fa-solid fa-car-rear"></i>
            </div>
            <div class="sidebar-brand-text mx-3">
                資車會<sup></sup>
            </div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item"><a class="nav-link" href="/">
            <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
        </a></li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">功能列表</div>

        <!-- Nav Item - Pages Collapse Menu -->
        <!-- <li class="nav-item active">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-cog"></i>
                <span>會員</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Custom Components:</h6>
                    <a class="collapse-item" href="buttons.html">Buttons</a>
                    <a class="collapse-item" href="cards.html">Cards</a>
                </div>
            </div>
        </li> -->
        <li class="nav-item">
            <a class="nav-link" href="memberselectall.controller">
                <i class="fa-solid fa-user"></i>
                <span>會員</span></a>
        </li>

        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item"><a class="nav-link"
                                href="CarDealerForm">
            <i class="fa-solid fa-car"></i> <span>車廠</span>
        </a></li>
        <li class="nav-item"><a class="nav-link"
                                href="CarInfoForm">
            <i class="fa-solid fa-car"></i> <span>車輛</span>
        </a></li>

        <!-- Divider -->
        <!-- <hr class="sidebar-divider"> -->

        <!-- Heading -->
        <!-- <div class="sidebar-heading">
            Addons
        </div> -->

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link" href="serviceAllController">
                <i class="fa-solid fa-screwdriver-wrench"></i>
                <span>保養廠</span></a>
        </li>

        <!-- Nav Item - Charts -->
        <li class="nav-item"><a class="nav-link" href="/backstage/threadsView">
            <i class="fa-brands fa-rocketchat"></i> <span>論壇</span>
        </a></li>

        <!-- Nav Item - Tables -->
        <li class="nav-item"><a class="nav-link"
                                href="<c:url value='/ProductListAll'/>"> <i
                class="fa-sharp fa-solid fa-cart-shopping"></i> <span>商城</span></a></li>

        <li class="nav-item"><a class="nav-link" href="<c:url value='/orderQueryAll.controller'/>">
            <i class="fa-solid fa-coins"></i> <span>訂單</span>
        </a></li>
        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">


            <!-- Topbar -->
            <nav
                    class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <div class="h4 mt-2 text-gray-800">資車國際</div>


                <!-- Topbar Navbar 右邊頭像 -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none"><a
                            class="nav-link dropdown-toggle" href="#" id="searchDropdown"
                            role="button" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
                    </a> <!-- Dropdown - Messages -->
                        <div
                                class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text"
                                           class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow"><a class="nav-link dropdown-toggle" href="#"
                                                              id="userDropdown" role="button"
                                                              data-toggle="dropdown" aria-haspopup="true"
                                                              aria-expanded="false">
                        <span class="mr-2 d-none d-lg-inline text-gray-600 small">${login.accountnumber}</span>
                        <!-- 職位 -->
                        <input type="hidden" value="${login.accountnumber}" id="myAccountnumber">
                        <input type="hidden" value="${memberPosition.positionPk}" id="myPosition">
                        <input type="hidden" value="${memberPosition.permissionsInsert}" id="myPositionInsert">
                        <input type="hidden" value="${memberPosition.permissionsUpdate}" id="myPositionUpdate">
                        <input type="hidden" value="${memberPosition.permissionsDelete}" id="myPositionDelete">
                        <input type="hidden" value="${memberPosition.permissionsSelect}" id="myPositionSelect">
                        <!--<img class="img-profile rounded-circle" id="myImage" src="showimageforthismember.controller?accountnumber=${login.accountnumber}"> -->
                    </a> <!-- Dropdown - User Information -->
                        <div
                                class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#"> <i
                                    class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
                            </a>

                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal"
                               data-target="#logoutModal"> <i
                                    class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content 內容 -->
            <div class="container">
                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800">發表文章</h1>

                <div>
                    <input type="button" onclick="history.go(-1)" class="btn btn-danger" value="返回">
                    <input type="button" style="background-color:#2db5c2;border-color:#2db5c2"
                           onclick='handleSave()' class="btn btn-primary" value="提交">
                </div>

                <br/>

                <form id="saveForm" action="/backstage/thread" method="post" accept-charset="UTF-8">
                    <div id="catediv" class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroup-sizing-sm">分類</span>
                        </div>
                    </div>


                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">標題</span>
                        </div>
                        <input type="text" class="form-control" id="title" name="title" required>
                    </div>

                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">精華</span>
                        </div>
                        <select class="form-control form-select" name="best">
                            <option value="true">是</option>
                            <option value="false">否</option>
                        </select>
                    </div>


                    <div id="newt" style="width: 100%; height: 100%">
                        <input id="body" type="hidden" name="body">
                        <div id="editor—wrapper">
                            <div id="toolbar-container"><!-- 工具欄 --></div>
                            <div id="editor-container"><!-- 編輯器 --></div>
                        </div>
                    </div>
                </form>


                <footer class="footer"></footer>

            </div>
            <!-- /container -->
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
        class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">決定登出?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
                <a class="btn btn-primary" href="<c:url value='/logoutServlet.do' />">登出</a></div>
            <!--                 <div class="modal-footer"> -->

            <!--                 </div> -->
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script
        src="/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
<script
        src="/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script
        src="/iSpanCar/script/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script
        src="/iSpanCar/script/js/sb-admin-2.min.js"></script>

<script src="https://kit.fontawesome.com/dbb4662278.js"
        crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8"
        src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">
    $(document).ready(
        function () {
            $("#time").val(new Date().getTime());
            $.ajax({
                url: "/category/all",
                method: "GET",
                dataType: "json",
                success: function (res) {
                    console.log(res);

                    var sel = $('<select>', {class: 'custom-select', name: 'category'}).appendTo('#catediv');
                    $(res).each(
                        function () {
                            sel.append($("<option>").attr('value',
                                this.id).text(this.name));
                        });

                },
                error: function (err) {
                    console.log(err)
                },
            });

        });
</script>
<script src="https://unpkg.com/@wangeditor/editor@latest/dist/index.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios@1.1.2/dist/axios.min.js"></script>
<script>
    const {createEditor, createToolbar, i18nChangeLanguage, i18nGetResources, i18nAddResources} = window.wangEditor

    const twLang = {
        "editor": {
            "more": "更多",
            "justify": "對齊",
            "indent": "縮進",
            "image": "圖片",
            "video": "視頻"
        },
        "common": {
            "ok": "確定",
            "delete": "刪除",
            "enter": "回車"
        },
        "blockQuote": {
            "title": "引用"
        },
        "codeBlock": {
            "title": "代碼塊"
        },
        "color": {
            "color": "文字顏色",
            "bgColor": "背景色",
            "default": "默認顏色",
            "clear": "清除背景色"
        },
        "divider": {
            "title": "分割線"
        },
        "emotion": {
            "title": "表情"
        },
        "fontSize": {
            "title": "字號",
            "default": "默認字號"
        },
        "fontFamily": {
            "title": "字體",
            "default": "默認字體"
        },
        "fullScreen": {
            "title": "全屏"
        },
        "header": {
            "title": "標題",
            "text": "正文"
        },
        "image": {
            "netImage": "網絡圖片",
            "delete": "刪除圖片",
            "edit": "編輯圖片",
            "viewLink": "查看鏈接",
            "src": "圖片地址",
            "desc": "圖片描述",
            "link": "圖片鏈接"
        },
        "indent": {
            "decrease": "減少縮進",
            "increase": "增加縮進"
        },
        "justify": {
            "left": "左對齊",
            "right": "右對齊",
            "center": "居中對齊",
            "justify": "兩端對齊"
        },
        "lineHeight": {
            "title": "行高",
            "default": "默認行高"
        },
        "link": {
            "insert": "插入鏈接",
            "text": "鏈接文本",
            "url": "鏈接地址",
            "unLink": "取消鏈接",
            "edit": "修改鏈接",
            "view": "查看鏈接"
        },
        "textStyle": {
            "bold": "粗體",
            "clear": "清除格式",
            "code": "行內代碼",
            "italic": "斜體",
            "sub": "下標",
            "sup": "上標",
            "through": "刪除線",
            "underline": "下劃線"
        },
        "undo": {
            "undo": "撤銷",
            "redo": "重做"
        },
        "todo": {
            "todo": "待辦"
        },
        "listModule": {
            "unOrderedList": "無序列表",
            "orderedList": "有序列表"
        },
        "tableModule": {
            "deleteCol": "刪除列",
            "deleteRow": "刪除行",
            "deleteTable": "刪除表格",
            "widthAuto": "寬度自適應",
            "insertCol": "插入列",
            "insertRow": "插入行",
            "insertTable": "插入表格",
            "header": "表頭"
        },
        "videoModule": {
            "delete": "刪除視頻",
            "uploadVideo": "上傳視頻",
            "insertVideo": "插入視頻",
            "videoSrc": "視頻地址",
            "videoSrcPlaceHolder": "視頻文件 url 或第三方 <iframe>",
            "videoPoster": "視頻封面",
            "videoPosterPlaceHolder": "封面圖片 url",
            "ok": "確定",
            "editSize": "修改尺寸",
            "width": "寬度",
            "height": "高度"
        },
        "uploadImgModule": {
            "uploadImage": "上傳圖片",
            "uploadError": "{{fileName}} 上傳出錯"
        },
        "highLightModule": {
            "selectLang": "選擇語言"
        }
    }

    i18nAddResources('tw', twLang)
    i18nChangeLanguage('tw')

    const editorConfig = {
        placeholder: '請輸入論壇内容',
        MENU_CONF: {
            uploadImage: {
                // 小於該值就插入 base64 格式（而不上傳），默認為 0
                server: '/api/upload-image',
                base64LimitSize: 50000 * 1024 // 50000kb
            }
        },
        onChange(editor) {
            const html = editor.getHtml()
            console.log('editor content', html)
            // 也可以同步到 <textarea>
        }
    }

    const editor = createEditor({
        selector: '#editor-container',
        html: '<p><br></p>',
        config: editorConfig,
        mode: 'default', // or 'simple'
    })

    const toolbarConfig = {
        excludeKeys: ['group-video'],
    }

    const toolbar = createToolbar({
        editor,
        selector: '#toolbar-container',
        config: toolbarConfig,
        mode: 'default', // or 'simple'
    })

    function formVail() {
        let formData = $("#saveForm").serializeArray();
        let formDataJson = {};
        for (row of formData) {
            let inputName = row.name
            let text = '';
            switch (inputName) {
                case "title":
                    text = '標題';
                    break;
                case "body":
                    text = '帖子内容';
                    break;
            }
            if (row.name !== 'id' && !row.value) {
                Swal.fire('請填寫' + text, "", "error");
                return;
            }
            formDataJson[row.name] = row.value;
        }
        return formDataJson;
    }

    function handleSave() {
        // 獲取html文本
        $("#body").val(editor.getHtml())
        let formDataJson = formVail()
        if (formDataJson) {
            axios.post('/backstage/thread', formDataJson).then((res) => {
                if (res.data === "no login") {
                    Swal.fire("未登錄！請先登錄!", "", "error");
                    return;
                }
                Swal.fire("操作成功!", "", "success").then(r => {
                    window.location.href = "/backstage/threadsView"
                });
            }).catch((error) => {

            });
        }
    }
</script>
<!-- <script> -->
</body>

</html>