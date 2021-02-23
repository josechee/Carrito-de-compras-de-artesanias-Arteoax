var ajax, ajaxTiempo, ajaxLista, ajaxEliminar,ajaxComprar;

window.onload = function () {
    //listaProyectos();
    listaCarritos();
};

function crea_cadena_valores(idProducto,txt) {
    var txtIdProducto = idProducto;
   // alert("txt: "+document.getElementById(txt).value);
    var txtCantidad = document.getElementById(txt).value;
    return "txtIdProducto=" + txtIdProducto +
            "&txtCantidad=" + txtCantidad;

}

function Agregar(idProducto,txt) {
   // alert("txt: "+document.getElementById(txt).value);
    ajax = getAJAX();
// alert("prueba:"+txt);
    var query_string = crea_cadena_valores(idProducto,txt);
 //  alert("prueba:"+txt);
 //   alert(query_string);
    if (ajax) {
        ajax.onreadystatechange = procesaRespuesta;
        ajax.open("POST", "agregarAlCarrito.jsp");

        ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");


        ajax.send(query_string);
    } else {
        alert("error");
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////

function tiempo() {
    alert("tiempo");
    ajaxTiempo = getAJAX();
    id = setInterval(mostrarHora, 100);
}

function mostrarHora() {
    if (ajaxTiempo) {
        ajaxTiempo.onreadystatechange = procesaTiempo;
        ajaxTiempo.open("POST", "tiempo_do.jsp", true);
        ajaxTiempo.send(null);
    } else {
        alert("error");
    }
}


function getAJAX() {
    /*if(window.XMLHttpRequest) {
     return new XMLHttpRequest();
     }
     else if(window.ActiveXObject) {
     return new ActiveXObject("Microsoft.XMLHTTP");
     }*/
    return new XMLHttpRequest();
}

function procesaRespuesta() {
    if (ajax.readyState == 4) {
        if (ajax.status == 200) {
            document.getElementById("respuesta").innerHTML = ajax.responseText;
        }
    }
}

function procesaRespuestaEliminar() {
    if (ajaxEliminar.readyState == 4) {
        if (ajaxEliminar.status == 200) {
            document.getElementById("respuesta").innerHTML = ajaxEliminar.responseText;
            //alert(ajaxEliminar.responseText);
        }
    }
}

function procesaTiempo() {
    if (ajaxTiempo.readyState == 4) {
        if (ajaxTiempo.status == 200) {
            document.getElementById("tiempo").innerHTML = ajaxTiempo.responseText;
        }
    }
}

function listaCarritos() {
    ajaxLista = getAJAX();
    id = setInterval(mostrarListaCarritos, 1000);
}



function mostrarListaCarritos() {
    if (ajaxLista) {
        ajaxLista.onreadystatechange = procesaListaCarritos;
        ajaxLista.open("post", "listadoDelCarrito.jsp");
        ajaxLista.send(null);
    } else {
        alert("error");
    }
}

function procesaListaCarritos() {
    if (ajaxLista.readyState == 4) {
        if (ajaxLista.status == 200) {
            document.getElementById("carritos").innerHTML = ajaxLista.responseText;
            // document.getElementById("respuesta").innerHTML = ajaxLista.responseText;
        }
    }
}

function eliminar(id) {
    alert("Entra en la funcion Eliminar");
    ajaxEliminar = getAJAX();
    if (ajaxEliminar) {
        ajaxEliminar.onreadystatechange = procesaRespuestaEliminar;
        ajaxEliminar.open("POST", "eliminarProyecto_do.jsp");
        ajaxEliminar.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        ajaxEliminar.send("id=" + id);
    } else {
        alert("error");
    }
}

//////////////////////////////////////
function procesaRespuestaComprar() {
    if (ajaxComprar.readyState == 4) {
        if (ajaxComprar.status == 200) {
            document.getElementById("respuestaCompra").innerHTML = ajaxComprar.responseText;
             alert(ajaxEliminar.responseText);
        }
    }
}

function realizarCompra() {
   // alert("Entra en la funcion realizarCompra");
    ajaxComprar = getAJAX();
    if (ajaxComprar) {
        ajaxComprar.onreadystatechange = procesaRespuestaComprar;
        ajaxComprar.open("POST", "realizarCompra.jsp");
        ajaxComprar.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        ajaxComprar.send(null);
    } else {
        alert("error");
    }
}

////////////////////////////

function listaProductos() {
    ajaxLista = getAJAX();
    id = setInterval(mostrarListaProductos, 1000);
}

function mostrarListaProductos(region) {
    alert("entra en mostratrListaProductos con: " + region);
    if (ajaxLista) {
        ajaxLista.onreadystatechange = procesaListaProductos;
        ajaxLista.open("post", "controlConsultarProductos.jsp", true);
        ajaxLista.send("region=" + region);
    } else {
        alert("error");
    }
}

function procesaListaProductos() {
    alert("hola   entra a  : procesaListaProductos");
    if (ajaxLista.readyState == 4) {
        alert("hola   ready == 4");
        if (ajaxLista.status == 200) {
            lert("hola   status == 200");
            document.getElementById("filas").innerHTML = ajaxLista.responseText;
            alert("hola" + ajaxLista.responseText);
            // document.getElementById("respuesta").innerHTML = ajaxLista.responseText;
        }
    }
}

function consultarProductos(region) {
    alert("Entra en la funcion consultarProducto con:   " + region);
    ajaxEliminar = getAJAX();
    if (ajaxEliminar) {
        ajaxEliminar.onreadystatechange = procesaRespuestaEliminar;
        ajaxEliminar.open("POST", "controlConsultarProductos.jsp");
        ajaxEliminar.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        ajaxEliminar.send("region=" + region);
    } else {
        alert("error");
    }
}

