/**
 * 
 */






function addListItem(res, list) {
	for (var i = 0; i < res.length; i++) {
		var listItem = $("<li class=\"list-group-item\"><a><div class=\"row\"></div></a></li>");
		var e1 = $('<div>', {
			class: 'col-xl-1',
			text: res[i].thread.category.name
		})
		var e2 = $('<div>', {
			class: 'col-xl-8',
			text: res[i].title
		})
		var e3 = $('<div>', {
			class: 'col-xl-3',
			text: res[i].member.name 
		})
		var time = new Date(res[i].time).toLocaleString();
		e3.append("<br/>"+time);
		
		listItem.children().attr('href','thread.jsp?id='+ res[i].thread.id);
		
		listItem.children().children().append(e1);
		listItem.children().children().append(e2);
		listItem.children().children().append(e3);
		list.append(listItem);
	}
}




$(document).ready(function() {
	var list = $(".list-group");
	$.ajax({
		url: "http://localhost:8080/iSpanCar/threads.do",
		method: "GET",
		dataType: "json",
		success: function(res) {
			console.log(res);
			addListItem(res, list);
			
		},
		error: function(err) { console.log(err) },
	});
});



