/**
*
 */

window.onload = function () {
	 	const pass1 = document.querySelector(".pass1");
    	const pass2 = document.querySelector(".pass2");
    	const button = document.querySelector(".prueba");
    	const small = document.querySelector(".checker");
    	document.querySelector("form").onsubmit = function() {
			return check();
		};
    	
		
		let match = false;
		
		function check(){
			if(pass1.value == pass2.value){
				return true;
			}else{
				small.textContent="Las contraseñas no coinciden";
				return false;
			}
		}
	
	}