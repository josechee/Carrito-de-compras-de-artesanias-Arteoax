var ajax, ajaxTiempo, ajaxLista,ajaxEliminar;

window.onload = function () {
    listaProductos();
};

function crea_cadena_valores() {
    var txtRegion = document.getElementById("JComboxRegiones").value;
    var txtNombre = document.getElementById("txtNombre").value;
    var txtDescripcion = document.getElementById("txtDescripcion").value;
    var txtCosto = document.getElementById("txtCosto").value;
    var txtExistencia = document.getElementById("txtExistencia").value;
    return "txtRegion=" + txtRegion +
            "&txtNombre=" + txtNombre +
            "&txtDescripcion=" + txtDescripcion +
            "&txtCosto=" + txtCosto  +
            "&txtExistencia=" +txtExistencia;

}

function registrarProducto() {
    ajax = getAJAX();
    
    if (ajax) {
        
        ajax.onreadystatechange = procesaRespuesta;
        ajax.open("POST", "registrarProducto.jsp");
        
        ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        var query_string = crea_cadena_valores();
        ajax.send(query_string);
    } else {
        alert("error");
    }
}

function tiempo() {
    alert("tiempo");
    ajaxTiempo = getAJAX();
    id = setInterval(mostrarHora, 1000);
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

function listaProductos() {
    ajaxLista = getAJAX();
    id = setInterval(mostrarListaProductos, 1000);
}

function mostrarListaProductos() {
    if (ajaxLista) {
        ajaxLista.onreadystatechange = procesaListaProductos;
        ajaxLista.open("post", "listadoProductosRegistrados.jsp");
        ajaxLista.send(null);
    } else {
        alert("error");
    }
}

function procesaListaProductos() {
    if (ajaxLista.readyState == 4) {
        if (ajaxLista.status == 200) {
            document.getElementById("filas").innerHTML = ajaxLista.responseText;
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