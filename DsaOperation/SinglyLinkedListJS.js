var Node = function(data) {
	this.data = data;
	this.next = null;
}

var LinkedList = function() {
	this.size = 0;
	this.head = null;
}

LinkedList.prototype.add = function(data) {
	var node = new Node(data);
	if (this.head == null) {
		this.head = node;
		document.getElementById("screen").innerHTML = data +" added!"; 
	} else {
		var temp = this.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		document.getElementById("screen").innerHTML = data +" added!"; 
	}
}

LinkedList.prototype.deleteNode = function(element) {
	if(this.head == null) {
		document.getElementById("screen").innerHTML = "Linked list is empty";
	} else {
		var current = this.head;
		var prev = null;
		while (current != null) {
			if (current.data == element) {
				if (prev == null) {
					this.head = current.next;
				} else {
					prev.next = current.next;
				}
				document.getElementById('screen').innerText = current.data+" Deleted!"; 
				return 1;
			}
			prev = current;
			current = current.next;
		}
		document.getElementById('screen').innerText = "Element not found!";
		return -1;
	}
}

LinkedList.prototype.display = function() {
	if (this.head == null) {
		alert("Linked list is empty");
	} else {
		var temp = this.head;
		var linkedList = "";
		while (temp != null) {
			linkedList += temp.data + "->";
			temp = temp.next;
		}
		alert(linkedList);
	}
}

var linkedList = new LinkedList();
function addNode() {
	var data = document.getElementById("nodeData").value;
	linkedList.add(data);
}

function displayNodes() {
	linkedList.display();
}

function deleteNode() {
	var data = document.getElementById("nodeData").value;
	linkedList.deleteNode(data);
}