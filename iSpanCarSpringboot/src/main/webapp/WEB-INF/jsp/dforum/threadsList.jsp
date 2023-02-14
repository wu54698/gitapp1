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
            text-indent: 75px;

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

        .td-info {
            cursor: pointer;
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
                    <li class="nav-item"><a class="nav-link" href="findAllDealer.controller">
							<i class="fa-solid fa-car"></i> <span>車廠</span>
			</a></li>
            <li class="nav-item"><a class="nav-link" href="SelectAllCar.controller">
					<i class="fa-solid fa-car"></i> <span>車輛</span>
			</a></li>

            <!-- Divider -->
<!--             <hr class="sidebar-divider"> -->

<!--             Heading -->
<!--             <div class="sidebar-heading"> -->
<!--                 Addons  -->
<!--             </div>   -->

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="serviceAllController">
                    <i class="fa-solid fa-screwdriver-wrench"></i>
                    <span>保養廠</span></a>
            </li>

            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="threadsView">
                    <i class="fa-brands fa-rocketchat"></i>
                    <span>論壇</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item"><a class="nav-link"
				href="iSpancarShop.ProductListAll"> <i
					class="fa-sharp fa-solid fa-cart-shopping"></i> <span>商城</span></a></li>

            <li class="nav-item">
                <a class="nav-link" href="orderBack">
                    <i class="fa-solid fa-coins"></i>
                    <span>訂單</span></a>
            </li>
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
                        <span class="mr-2 d-none d-lg-inline text-gray-600 small">${login.memberName}</span>
                        <!-- 職位 -->
                        <input type="hidden" value="${login.accountnumber}" id="myAccountnumber">
                        <input type="hidden" value="${memberPosition.positionPk}" id="myPosition">
                        <input type="hidden" value="${memberPosition.permissionsInsert}" id="myPositionInsert">
                        <input type="hidden" value="${memberPosition.permissionsUpdate}" id="myPositionUpdate">
                        <input type="hidden" value="${memberPosition.permissionsDelete}" id="myPositionDelete">
                        <input type="hidden" value="${memberPosition.permissionsSelect}" id="myPositionSelect">
                        <img class="img-profile rounded-circle" id="myImage"
                             src="/showimageforthismember.controller?accountnumber=${login.accountnumber}">
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
                <h1 class="h3 mb-4 text-gray-800">論壇管理</h1>
                <div class="row">
                    <div class="col-4 form-floating">
                        <input id="postTitle" type="input" value="${title}" class="form-control" type="text"
                               placeholder="請輸入標題">
                    </div>
                    <div class="col-4">
                        <select id="postSelect" class="form-control form-select" aria-label="請選擇類別">

                        </select>
                    </div>
                    <div class="col-4">
                        <input type="button" style="background-color:#2db5c2;border-color:#2db5c2" onclick="doSearch()"
                               class="btn btn-primary" value="查詢">
                    </div>
                </div>

                <br/>
                <div class="row">
                    <div class="col-12">
                        <input type="button" style="background-color:#2db5c2;border-color:#2db5c2"
                               onclick="location.href='/backstage/thread/newthread'" class="btn btn-primary" value="新增文章">
                        <input type="button" style="background-color:#2db5c2;border-color:#2db5c2"
                               onclick="window.open('/dforum/home')" class="btn btn-primary" value="論壇首頁">
                    </div>
                </div>

                <br/>

                <table id="threadList" style="width:1270px;">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>類別</th>
                        <th>標題</th>
                        <th>創建人</th>
                        <th>創建時間</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var='post' items='${postList}' varStatus="vs">
                        <tr data-post-id="${post.id}" id="pos_row_${post.id}">
                            <td class="td-info">${post.id}</td>
                            <td class="td-info">${post.thread.category.name}</td>
                            <td class="td-info">${post.title}</td>
                            <td class="td-info">${post.member.accountnumber}</td>
                            <td class="td-info">${post.time}</td>
                            <td>
                                <button onclick="location.href = '/backstage/thread/${post.id}?edit=true'"
                                        class="btn btn-info btn-circle"><i class="fa-solid fa-pen"></i></button>
                                <button onclick="deletePost(${post.id})" class="btn btn-danger btn-circle"><i
                                        class="fas fa-trash"></i></button>
                                <!-- <button onclick="location.href = '/backstage/thread/${post.id}'" class="btn btn-info btn-circle"><i class="fa-regular fa-circle-info"></i></button>-->
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <script src="https://kit.fontawesome.com/f9c412c6fd.js" crossorigin="anonymous"></script>
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
<script>
    $(document).ready(function () {
        $('#threadList').DataTable({
            bPaginate: false,
            searching: false,
        });
    });
</script>
<script>
    function deletePost(id) {
        Swal.fire({
            title: '確定刪除?',
            text: "資料將被刪除",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '刪除',
            cancelButtonText: '取消'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: "DELETE",
                    url: "/backstage/thread/" + id,
                    success: function (res) {
                        if(res == '操作成功！'){
                            $("#pos_row_" + id).remove();
                            Swal.fire(res, "", "success", {button: "確定"});
                            return;
                        }
                        Swal.fire(res, "", "error", {button: "確定"});
                    }
                })
            }
        })
    }

    $(document).ready(
        function () {
            $.ajax({
                url: "/category/all",
                method: "GET",
                dataType: "json",
                success: function (res) {
                    $("#postSelect").append("<option value=''>請選擇</option>")
                    for (data of res) {
                        $("#postSelect").append("<option value=" + data.id + ">" + data.name + "</option>")
                    }
                    $("#postSelect").val(${categoryId})
                }
            });

        });

    function doSearch() {
        var title = $("#postTitle").val();
        var categoryId = $("#postSelect").val();
        window.location.href = 'threadsView?title=' + title + "&categoryId=" + categoryId;
    }

    $(".td-info").click(function (target) {
        location.href = '/backstage/thread/' + $(target.target).parent().data("post-id")
    })

</script>
<script>
    var aa;
    $(".btn1").on('mouseover', function () {
        aa = $(this).parent().parent().children('#productno').text();
        console.log(aa)
    });

    function foredit() {
        console.log(aa);
        let bb = $(this).parent().parent().children('#productno').text();
        window.open("iSpanCar/SendIdToUpdate.controller?productno=" + aa);
    }
</script>
</body>

</html>