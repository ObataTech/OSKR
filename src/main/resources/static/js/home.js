document.getElementById("input").onkeyup = function() {
    let count = this.value.length;
    document.getElementById("count").innerHTML = "文字数：" + count;
}