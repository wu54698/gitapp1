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
function getUrlVars()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
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
			class: 'card-footer',
			text: res[i].Mname 
		})
		var time = new Date(res[i].Ptime).toLocaleString();
		e3.append(" "+time);
		if ( res[i].Pisop ){
			listItem.children().children().append(e1);	
		}
		
		listItem.children().children().append(e2);
		listItem.children().children().append(e3);
		list.append(listItem);
	}
}




$(document).ready(function() {
	var SN = getUrlVars()['sn'];
	var list = $("#posts");
	$.ajax({
		url: "http://localhost:8080/jspExercise/thread?sn="+SN,
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



