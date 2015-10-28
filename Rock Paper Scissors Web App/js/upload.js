/*
function mostrarMensaje1(){
alert('Bienvenido al curso JavaScript de aprenderaprogramar.com');
}*/

$(function(){
$("#upload_link").on('click', function(e){
    e.preventDefault();
    $("#upload:hidden").trigger('click');
});
});

