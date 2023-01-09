let navtext = '<div class="container px-4 px-lg-5">' +
    '<a class="navbar-brand" href="#page-top">首頁</a>' +
    '<button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"' +
    'data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"' +
    'aria-label="Toggle navigation">' +
    'Menu' +
    '<i class="fas fa-bars"></i>' +
    '</button>' +
    '<div class="collapse navbar-collapse" id="navbarResponsive">' +
    '<ul class="navbar-nav ms-auto">' +
    '<li class="nav-item"><b><a class="nav-link" href="#about">車廠</a></b></li>' +
    '<li class="nav-item"><b><a class="nav-link" href="#projects">車輛</a></b></li>' +
    '<li class="nav-item"><b><a class="nav-link" href="#projects">保養廠</a></b></li>' +
    '<li class="nav-item"><b><a class="nav-link" href="#about">論壇</a></b></li>' +
    '<li class="nav-item"><b><a class="nav-link" href="#about">商城</a></b></li>' +
    '<li class="nav-item"><b><a class="nav-link" href="#signup">登入</a></b></li>' +
    '</ul>' +
    '</div>' +
    '</div>';
let nav = document.getElementById('mainNav');
nav.innerHTML = navtext;

let headertext = '<div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">' +
    '<div class="d-flex justify-content-center">' +
    '<div class="text-center">' +
    '<h1 class="mx-auto my-0 text-uppercase">資車會</h1>' +
    '<h2 class="text-white-50 mx-auto mt-2 mb-5">資車國際</h2>' +
    '</div>' +
    '</div>' +
    '</div>';
let header = document.getElementById('masthead');
header.innerHTML = headertext;