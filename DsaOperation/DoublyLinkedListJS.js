var Node = function(data) {
	this.data = data;
	this.prev = null;
	this.next = null;
}

var LinkedList = function() {
	this.size = 0;
	this.head = null;
	this.tail = null;
}

LinkedList.prototype.add = function(data) {
	var node = new Node(data);
	if (this.head == null) {
		this.head = node;
		this.tail = node;
		document.getElementById("screen").innerHTML = data +" added!"; 
	} else {
		node.prev = this.tail;
		this.tail.next = node;
		this.tail = node;
		document.getElementById("screen").innerHTML = data +" added!"; 
	}
}

LinkedList.prototype.deleteNode = function(element) {
	if(this.head == null) {
		document.getElementById("screen").innerHTML = "Linked list is empty";
	} else {
		var current = this.head;
		while (current != null) {
			if (current.data == element) {
				if (current == this.head && current == this.tail) { 
                    this.head = null;
                    this.tail = null; 
                } else if(current == this.head) {
                    this.head = this.head.next;
                } else if(current == this.tail) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
				document.getElementById('screen').innerText = current.data+" Deleted!";
				return 1;
			}
			current = current.next;
		}
		document.getElementById('screen').innerText = "Element not found!";
		return -1;
	}
}

LinkedList.prototype.display = function() {
	if (this..head == null) {
		alert("Linked list is empty");
		return;
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