/**
 * 
 */



//
//		<div class="row"><div class="col-md-12"><div class="card bg-default">
//					<h5 class="card-header">Card title</h5>
//					<div class="card-body">
//						<p class="card-text">Card content</p>
//					</div>
//					<div class="card-footer">Card footer</div>
//				</div>
//			</div>
//		</div>


// Read a page's GET URL variables and return them as an associative array.
function getUrlVars() {
	var vars = [], hash;
	var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
	for (var i = 0; i < hashes.length; i++) {
		hash = hashes[i].split('=');
		vars.push(hash[0]);
		vars[hash[0]] = hash[1];
	}
	return vars;
}



function addListItem(res, list) {
	for (var i = 0; i < res.length; i++) {
		var listItem = $("<div class=\"row\"><div class=\"col-md-12\"><div class=\"card bg-default\"></div></div></div>");
		var e1 = $('<h5>', {
			class: 'card-header',
			text: "[" + res[i].Cname + "]" + res[i].Ptitle
		})
		var e2 = $('<div>', {
			class: 'card-body',
		});
		var e2c = $('<p>', {
			class: 'card-text',
			text: res[i].Pbody
		});
		e2.append(e2c);
		var e3 = $('<div>', {
			class: 'card-footer'
		})
		var time = new Date(res[i].Ptime).toLocaleString();
		var e3a = $('<div>', {
			class: 'float-left',
			text: res[i].Mname + " " + time
		})
		var e3b = $('<div>', {
			class: 'float-right'
		})
		if (res[i].Pisop) { // if it is opening post (first one), delete full thread
			var deleteBtn = $('<button>', {
				type: 'button',
				class: 'btn btn-sm btn-outline-secondary',
				html: '<i class="bi bi-x-lg"></i>',
				onclick: 'deleteThread(' + res[i].SN + ')'
			})
		} else {  // else, delete one post
			var deleteBtn = $('<button>', {
				type: 'button',
				class: 'btn btn-sm btn-outline-secondary',
				html: '<i class="bi bi-x-lg"></i>',
				onclick: 'deletePost(' + res[i].PSN + ')'
			})
		}

		e3b.append(deleteBtn);
		e3.append(e3a).append(e3b);
		if (res[i].Pisop) {
			listItem.children().children().append(e1);
		}

		listItem.children().children().append(e2);
		listItem.children().children().append(e3);
		list.append(listItem);
	}
}

function deletePost(sn) {
	$.ajax({
		url: "newpost?sn=" + sn,
		method: "DELETE",
		success: function(res) {
			console.log(res);
			location.reload(); 
		},
		error: function(err) { console.log(err) },
	});
}



$(document).ready(function() {
	var SN = getUrlVars()['sn'];
	var list = $("#posts");
	$.ajax({
		url: "thread?sn=" + SN,
		method: "GET",
		dataType: "json",
		success: function(res) {
			console.log(res);
			addListItem(res, list);

		},
		error: function(err) { console.log(err) },
	});
	$("#time").val(new Date().getTime());
	$("#threadSN").val(SN);
});



