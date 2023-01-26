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

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link" href="serviceAllController">
                <i class="fa-solid fa-screwdriver-wrench"></i>
                <span>保養廠</span></a>
        </li>

        <!-- Nav Item - Charts -->
        <li class="nav-item"><a class="nav-link" href="threadsView">
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
                <h1 class="h3 mb-4 text-gray-800">文章詳情</h1>

                <div>
                    <input type="button" onclick="history.go(-1)" class="btn btn-danger" value="返回">
                </div>

                <br/>

                <form id="postForm" action="/thread" method="post" accept-charset="UTF-8">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">分類</span>
                        </div>
                        <input readonly type="text" class="form-control" value="${post.thread.category.name}">
                    </div>


                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">標題</span>
                        </div>
                        <input readonly type="text" class="form-control" value="${post.title}">
                    </div>

                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">時間</span>
                        </div>
                        <input readonly type="text" class="form-control" value="${post.time}">
                    </div>

                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">發佈人</span>
                        </div>
                        <input readonly type="text" class="form-control" value="${post.member.accountnumber}">
                    </div>


                    <div id="newt" style="width: 100%; height: 100%">
                        ${post.body}
                    </div>

                    <div>
                        <input type="hidden" id="memberId" name="memberId" value="1"/>
                        <input type="hidden" id="time" name="time"/>
                    </div>
                </form>
                <br/>
                <h1 class="h3 mb-4 text-gray-800">留言板</h1>
                <footer class="footer">
                    <div class="list-group">
                        <div class="list-group-item">
                            <div>
                                <textarea id="messageContent" placeholder="請輸入留言内容..." autofocus rows="4"
                                          style="width: 100%"></textarea>
                                <input type="button" onclick="submitMessage()" value="發佈"
                                       style="bottom: 25px;right: 25px;position: absolute;">
                            </div>
                        </div>
                        <div id="message-content">
                        </div>
                    </div>
                </footer>

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
<script src="/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
<script src="/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/iSpanCar/script/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/iSpanCar/script/js/sb-admin-2.min.js"></script>

<script src="https://kit.fontawesome.com/dbb4662278.js" crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
    $(function () {
        listMessage();
    })

    function submitMessage() {
        let val = $("#messageContent").val()
        if (!val) {
            Swal.fire("操作提醒!", "請輸入留言内容！","error");
        }
        $.ajax({
            type: "POST",
            url: "/post/message",
            data: JSON.stringify({content: val, member: {id: 1}, post: {id: ${post.id}}}),
            contentType: 'application/json',
            success: (res) => {
                if ("no login" === res) {
                    Swal.fire("未登录，请先登录!", "", "error");
                    return;
                }
                Swal.fire(res,"","success");
                listMessage();
                $("#messageContent").val("")
            }
        })
    }

    function listMessage() {
        $.ajax({
            type: "GET",
            url: "/post/message/${post.id}",
            dataType: "json",
            success: (res) => {
                let html = '';
                let i = res.length + 1;
                for (let r of res) {
                    i--;
                    html += `
                        <div class="list-group-item">
                            <div>\${r.member.accountnumber}:</div>
                            <p class="list-group-item-text">\${r.content}</p>
                            <div style="text-align: right"><span style="color: red">\${i}樓</span>&nbsp;&nbsp;\${r.time}</div>
                        </div>
                `
                }
                $("#message-content").html(html);
            }
        })
    }
</script>

<!-- <script> -->
</body>

</html>