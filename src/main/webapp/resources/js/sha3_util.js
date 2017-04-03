/**
 * 
 */
function sha3(msg) {
	var shaObj = new jsSHA("SHA3-256", "TEXT");
	shaObj.update(msg);
	return shaObj.getHash("HEX");
}