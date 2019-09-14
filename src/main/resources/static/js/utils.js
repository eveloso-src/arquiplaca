function addRow(row, id) {
	var cell1 = row.insertCell();
	cell1.innerHTML=document.getElementById(id).value;
}