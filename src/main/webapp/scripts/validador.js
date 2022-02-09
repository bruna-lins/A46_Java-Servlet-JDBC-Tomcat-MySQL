/**
 *  Validação de forms
 */
 
 function validar() { 
	let name = frmDestino.name.value
	let description = frmDestino.description.value
	let price = frmDestino.price.value
	
	if (name === "") {
		alert('Preencha o campo Nome')
		frmDestino.name.focus()
		return false
	} else if (description === "") {
		alert('Preencha o campo Descrição')
		frmDestino.description.focus()
		return false
	} else if (price === "") {
		alert('Preencha o campo Valor')
		frmDestino.price.focus()
		return false
	} else {
		document.forms["frmDestino"].submit()
	}
}