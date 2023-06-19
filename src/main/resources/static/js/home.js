document.getElementById("input").onkeyup = function() {
    let count = this.value.length;
    if(count > 20){
        document.getElementById("count").style.color="red";
    }
    else{
        document.getElementById("count").style.color="";
    }
    document.getElementById("count").innerHTML = "文字数：" + count;
}