var table = document.getElementById("myTable");		//main table
var rowamt = 0
var count = 1
var currentdiv = null
var currentpic = null

function loadimages(){
	var table = document.getElementById("myTable");

	for(j=0; j<2; j++){
		var row = table.insertRow(j);	
		for (i = 0; i < 5; i++) {
			var cell = row.insertCell(i);	
			cell.innerHTML = "<img src=img/" + (count) + ".jpg  style='width:250px;height:250px;' onclick='imageclicked("+count+",this)' id='image"+count+"-'> <br> <div id="+count+"></div>";
			count++
		}
	}
}

function imageclicked(id,img){
	inputs = document.getElementsByTagName('input')
	for(j=0; j < inputs.length; j++){
			inputs[j].parentElement.removeChild(inputs[j])
	}

	var div = document.getElementById(id)
	var input = document.createElement('input'); 
	input.type = "text"; 
	input.id = "textbox"
	input.style.width= "97%"
	div.appendChild(input)

	currentpic = img
	currentdiv = div
}

function tag(){
	linktext = document.getElementById('textbox').value

	if(linktext.length < 1 || linktext.indexOf(" ") > -1){
		alert("cannot give blank tag")
	}
	else{
		var foo = document.createTextNode("\u00A0");
		currentdiv.appendChild(foo);

		var a = document.createElement('a');
		var linkText = document.createTextNode(linktext);
		a.appendChild(linkText);
		a.href = "#"+a.title;
		a.id = linktext 
		a.onclick = function () {filter(this);};


		//img tag
		image = currentpic
		image.id = image.id+linktext+"-"
		currentdiv.appendChild(a);

		var foo = document.createTextNode("\u00A0");
		currentdiv.appendChild(foo);

		var ax = document.createElement('a');
		var linkText = document.createTextNode("x");
		ax.appendChild(linkText);
		ax.href = "#"+a.title;
		ax.id = currentdiv.id + "delete"
		ax.onclick = function () {removeTag(a, this, image);};

		currentdiv.appendChild(ax);
	}
}

function filter(a){
	images = document.getElementsByTagName("img");

	for(j=0; j < images.length; j++){
		arr = images[j].id.split("-")
		var boo;
		for(i=0;i<arr.length;i++){
			//alert("is "+arr[i]+" equal to "+a.innerHTML)
			if(arr[i] == a.innerHTML){ 
				boo = true
				break
			}
			else{
				boo=false
			}
		}
		if(boo==false){
			imgid = images[j].id
			$("#"+imgid).hide(1000);

			links = document.getElementsByTagName('a')
			for(x=0; x < links.length; x++){	
				id = links[x].id
				$("#"+id).hide(0);
				$("#textbox").hide(0);
			}
		}
	}
}

function clearFilter(){
	images = document.getElementsByTagName("img");
	for(j=0; j < images.length; j++){	
		imgid = images[j].id
		$("#"+imgid).show(1000);
	}

	links = document.getElementsByTagName('a')
	for(x=0; x < links.length; x++){	
		id = links[x].id
		$("#"+id).show(0);
	}
}

function removeTag(taglink,a,image){
	var r = confirm("Are you sure you want to remove this images tags?");
    if (r == true) {
        oldid = a.id.split("")[0]
		image.id = "image"+oldid
		$( "#"+a.parentElement.id ).empty();
    } 
}
