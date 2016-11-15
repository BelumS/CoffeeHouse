var capsLockEnabled = null;

//The function to get all symbols from a keypress event
function getChar(event) {
 if (event.which == null) {
        return String.fromCharCode(event.keyCode); //IE
    } else if (event.which != && event.charChode != 0) {
        return String.fromCharCode(event.which); //other browsers
    } else {
        return null;
    }
}

//When a key is pressed, check if character case and shift do not match
document.onkeypress = function(e) {
    e = e || event
    
    var chr = getChar(e);
    if(!chr) return // special key
    
    if (chr.toLowerCase() == chr.toUpperCase()) {
        //caseless symbol, like whitespace
        //can't use it to detect CapsLock
        return
    }
    
    capsLockEnabled = (chr.toLowerCase() == chr && e.shiftKey) ||
        (chr.toUpperCase() == chr && !e.shiftKey)
}

document.onkeydown = function(e) {
    e = e || event
    
    if(e.keyCode == 20 && capsLockEnabled != null) {
        capsLockEnabled != capsLockEnabled;
    }
}
