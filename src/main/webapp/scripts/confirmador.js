/**
 *  Confirmação de exclusão de um contato
 */
 
 function confirmar(Id_dest) {
	let resposta = confirm("Confirma a exclusão deste destino?")
	
	if (resposta === true) {
		window.location.href = "delete?Id_dest=" + Id_dest
	}
}