function save() {
  // Construir el objeto data
  var data = {
    nombre: $("#nombre").val(),
    correo: $("#correo").val(),
    telefono: $("#telefono").val(),
    direccion: $("#direccion").val(),
    estado: parseInt($("#estado").val()),
  };

  var jsonData = JSON.stringify(data);
  
  $.ajax({
    url: "http://localhost:9000/v1/api/cliente",
    method: "POST",
    dataType: "json",
    contentType: "application/json",
    data: jsonData,
    success: function (data) {
      // Obtener el nombre del cliente agregado (o cualquier otro dato relevante)
      var clienteAgregado = data.nombre;

      // Mostrar un modal de SweetAlert personalizado
      Swal.fire({
        title: "¡Registro Agregado!",
        html: `El cliente <strong>${clienteAgregado}</strong> fue añadido con éxito.`,
        icon: "success",
        confirmButtonText: "Aceptar",
      }).then(() => {
        // Luego de cerrar el modal, cargar y limpiar datos
        loadData();
        clearData();
      });
    },
    error: function (error) {
      console.error("Error en la solicitud:", error);
    },
  });
}



function update() {
  var data = {
    nombre: $("#nombre").val(),
    correo: $("#correo").val(),
    telefono: $("#telefono").val(),
    direccion: $("#direccion").val(),
    estado: parseInt($("#estado").val()),
  };
  var id = $("#id").val();
  var jsonData = JSON.stringify(data);

  $.ajax({
    url: 'http://localhost:9000/v1/api/cliente/' + id,
    data: jsonData,
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    success: function (data) {
      var clienteActualizado = data.nombre;

      Swal.fire({
        title: "¡Registro Actualizado!",
        html: `El cliente <strong>${clienteActualizado}</strong> fue actualizado con éxito.`,
        icon: "success",
        confirmButtonText: "Aceptar",
      }).then(() => {
        loadData();
        clearData();

        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Agregar");
        btnAgregar.attr("onclick", "save()");
      });
    },
    error: function (error) {
      console.error("Error en la solicitud:", error);
    },
  });
}


function loadData() {
    $.ajax({
        url: 'http://localhost:9000/v1/api/cliente',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
          var html = '';
    
          data.forEach(function (item) {
            // Construir el HTML para cada objeto
            html += `<tr>
                    <td>`+ item.nombre + `</td>
                    <td>`+ item.correo + `</td>
                    <td>`+ item.telefono + `</td>
                    <td>`+ item.direccion + `</td>
                    <td>`+ (item.estado == true ? 'Activo' : 'Inactivo') + `</td>
                    <th><img src="../asset/icon/pencil-square.svg" alt="" onclick="findById(`+ item.id + `)"></th>
                    <th><img src="../asset/icon/trash3.svg" alt="" onclick="deleteById(`+ item.id + `)"></th>
                </tr>`;
          });
    
          $('#resultData').html(html);
        },
        error: function (error) {
          // Función que se ejecuta si hay un error en la solicitud
          console.error('Error en la solicitud:', error);
        }
      });
}

function findById(id) {
  $.ajax({
    url: "http://localhost:9000/v1/api/cliente/" + id,
    method: "GET",
    dataType: "json",
    success: function (data) {
      $("#id").val(data.id);
      $("#nombre").val(data.nombre);
      $("#correo").val(data.correo);
      $("#telefono").val(data.telefono);
      $("#direccion").val(data.direccion);
      $("#estado").val(data.estado == true ? 1 : 0);

      //Cambiar boton.
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text("Actualizar");
      btnAgregar.attr("onclick", "update()");
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}

function deleteById(id) {
  Swal.fire({
    title: "¿Estás seguro?",
    text: "Esta acción eliminará el registro. ¿Deseas continuar?",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#d33",
    cancelButtonColor: "#3085d6",
    confirmButtonText: "Sí, eliminar",
    cancelButtonText: "Cancelar",
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        url: "http://localhost:9000/v1/api/cliente/" + id,
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      }).done(function () {
        Swal.fire({
          title: "¡Registro Eliminado!",
          text: "El registro ha sido eliminado con éxito.",
          icon: "success",
          confirmButtonText: "Aceptar",
        }).then(() => {
          loadData();
          clearData();
        });
      });
    }
  });
}


function validarFormulario() {
  var nombre = document.getElementById('nombre').value;
  var correo = document.getElementById('correo').value;
  var telefono = document.getElementById('telefono').value;
  var direccion = document.getElementById('direccion').value;

  if (nombre === '' || correo === '' || telefono === '' || direccion === '') {
      alert('Por favor, completa todos los campos.');
      return false; // Prevent form submission
  }

  return true; // Allow form submission
}
function clearData() {
  $('#id').val('');
  $('#nombre').val('');
  $('#correo').val('');
  $('#telefono').val('');
  $('#direccion').val('');
  $('#estado').val('');
}
