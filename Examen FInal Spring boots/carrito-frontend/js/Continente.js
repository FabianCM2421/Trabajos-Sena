function save() {
  // Construir el objeto data
  var data = {
    'codigo': $('#codigo').val(),
    'nombre': $('#nombre').val(),
    'estado': parseInt($('#estado').val()),
  };

  var jsonData = JSON.stringify(data);
  $.ajax({
    url: 'http://localhost:9000/v1/api/Continente',
    method: 'POST',
    dataType: 'json',
    contentType: 'application/json',
    data: jsonData,
    success: function (data) {
      var PaisIngresado = data.nombre;

      Swal.fire({
          title: "Factura Agregada!",
          html: `La Factura <strong>${PaisIngresado}</strong> fue añadida con éxito.`,
          icon: "success",
          confirmButtonText: "Aceptar",
      }).then(() => {
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
  // Construir el objeto data
  var data = {
    'codigo': $('#codigo').val(),
    'nombre': $('#nombre').val(),
    'precio': parseFloat($('#precio').val()),
    'cantidad': parseInt($('#cantidad').val()),
    'estado': parseInt($('#estado').val()),
  };
  var id = $("#id").val();
  var jsonData = JSON.stringify(data);
  $.ajax({
    url: 'http://localhost:9000/v1/api/Continente/' + id,
    data: jsonData,
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
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
    url: 'http://localhost:9000/v1/api/Continente',
    method: 'GET',
    dataType: 'json',
    success: function (data) {
      var html = '';

      data.forEach(function (item) {
        // Construir el HTML para cada objeto
        html += `<tr>
                  <td>`+ item.codigo + `</td>
                  <td>`+ item.nombre + `</td>
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
    url: 'http://localhost:9000/v1/api/Continente/' + id,
    method: 'GET',
    dataType: 'json',
    success: function (data) {
      $('#id').val(data.id);
      $('#codigo').val(data.codigo);
      $('#nombre').val(data.nombre);
      $('#estado').val(data.estado == true ? 1 : 0);

      //Cambiar boton.
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text('Actualizar');
      btnAgregar.attr('onclick', 'update()');
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error('Error en la solicitud:', error);
    }
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
        url: 'http://localhost:9000/v1/api/Continente/' + id,
        method: "delete",
        headers: {
          "Content-Type": "application/json"
        }
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














function clearData() {
  $('#id').val('');
  $('#codigo').val('');
  $('#nombre').val('');
  $('#estado').val('');
}