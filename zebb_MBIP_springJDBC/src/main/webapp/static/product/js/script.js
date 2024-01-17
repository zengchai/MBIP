function clearForm() {
    document.getElementById("productName").value = "";
    document.getElementById("productDescription").value = "";
    document.getElementById("productCategory").value = "";
    document.getElementById("productPrice").value = "";

}
function cancelForm() {
    window.location.href = '/product/list';
}
