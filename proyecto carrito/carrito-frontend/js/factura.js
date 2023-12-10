async function save() {
  var id_cliente = parseInt($("#cliente_id").val());
  console.log(id_cliente);

  try {
    var cliente = await getClienteId(id_cliente);

    var data = {
      "codigo": $("#codigo").val(),
      "fecha": new Date($("#fecha").val()).toISOString(),
      "valorTotal": parseFloat($("#valor_total").val()),
      "clienteId": cliente,
      "estado": parseInt($("#estado").val()),
    };

    var jsonData = JSON.stringify(data);

    $.ajax({
      url: "http://localhost:9000/v1/api/factura",
      method: "POST",
      dataType: "json",
      contentType: "application/json",
      data: jsonData,
      success: function (data) {
        var FacturaAgregar = data.codigo;

        Swal.fire({
          title: "Factura Agregada!",
          html: `La Factura <strong>${FacturaAgregar}</strong> fue añadida con éxito.`,
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
  } catch (error) {
    console.error("Error obteniendo el cliente:", error);
  }
}

async function update() {
  try {
    // Obtener el ID del cliente desde el campo de selección
    var id_cliente = parseInt($("#cliente_id").val());

    // Obtener el cliente utilizando la función asincrónica
    var cliente = await getClienteId(id_cliente);

    // Crear un objeto con los datos del formulario
    var data = {
      "codigo": $("#codigo").val(),
      "fecha": $("#fecha").val(),
      "valorTotal": parseFloat($("#valor_total").val()),
      "clienteId": cliente,
      "estado": parseInt($("#estado").val()),
    };

    // Obtener el ID de la factura desde el campo oculto
    var id = $("#id").val();

    // Convertir el objeto de datos a formato JSON
    var jsonData = JSON.stringify(data);

    // Realizar la solicitud AJAX para actualizar la factura
    $.ajax({
      url: "http://localhost:9000/v1/api/factura/" + id,
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      data: jsonData,
      success: function (result) {
        // Mostrar una alerta de éxito
        Swal.fire({
          icon: 'success',
          title: 'Registro actualizado con éxito',
          showConfirmButton: false,
          timer: 1500
        });

        // Cargar y limpiar datos
        loadData();
        clearData();

        // Restaurar el botón Agregar
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Agregar");
        btnAgregar.attr("onclick", "save()");
      },
      error: function (error) {
        console.error("Error en la solicitud de actualización:", error);
      },
    });
  } catch (error) {
    // Manejar errores obtenidos al obtener el cliente
    console.error("Error obteniendo el cliente:", error);
    Swal.fire({
      icon: 'error',
      title: 'Error obteniendo el cliente',
      text: error.message
    });
  }
}

function loadData() {
  $.ajax({
    url: "http://localhost:9000/v1/api/factura",
    method: "GET",
    dataType: "json",
    success: function (data) {
      console.log(data);
      var html = "";

      data.forEach(function (item) {
        // Construir el HTML para cada objeto
        html +=
          `<tr>
                  <td>` +
          item.codigo +
          `</td>
                  <td>` +
          item.fecha +
          `</td>
                  <td>` +
          item.valorTotal +
          `</td>
                  <td>` +
          item.clienteId.nombre +
          `</td>
                  <td>` +
          (item.estado == true ? "Activo" : "Inactivo") +
          `</td>
                  <th><img src="../asset/icon/pencil-square.svg" alt="" onclick="findById(` +
          item.id +
          `)"></th>
                  <th><img src="../asset/icon/trash3.svg" alt="" onclick="deleteById(` +
          item.id +
          `)"></th>
              </tr>`;
      });

      $("#resultData").html(html);
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}

function findById(id) {
  $.ajax({
    url: "http://localhost:9000/v1/api/factura/" + id,
    method: "GET",
    dataType: "json",
    success: function (data) {
      $("#id").val(data.id);
      $("#codigo").val(data.codigo);
      $("#fecha").val(data.fecha);
      $("#valor_total").val(data.valorTotal);
      $("#cliente_id").val(data.clienteId.id);
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
    text: "Esta acción eliminará el Produto. ¿Deseas continuar?",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#d33",
    cancelButtonColor: "#3085d6",
    confirmButtonText: "Sí, eliminar",
    cancelButtonText: "Cancelar",
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
    url: 'http://localhost:9000/v1/api/factura/' + id,
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
function clearData() {
  $("#id").val("");
  $("#codigo").val("");
  $("#fecha").val("");
  $("#valor_total").val("");
  $("#cliente_id").val("");
  $("#estado").val("");
}

function loadCliente() {
  $.ajax({
    url: "http://localhost:9000/v1/api/cliente",
    method: "GET",
    dataType: "json",
    success: function (data) {
      var html = "<option selected>--Seleccione--</option>";

      data.forEach(function (item) {
        // Construir el HTML para cada objeto
        html += `<option value="${item.id}">${item.nombre}</option>`;
      });

      $("#cliente_id").html(html);
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}
async function getClienteId(id) {
  return new Promise(function(resolve, reject) {
    $.ajax({
      url: "http://localhost:9000/v1/api/cliente/" + id,
      method: "GET",
      dataType: "json",
      success: function(data_cliente) {
        resolve(data_cliente);
      },
      error: function(error) {
        reject(error);
      },
    });
  });
}


$(function () {
  var codigo, fecha, valorTotal, cliente_id, estado;

  $(".btnAgregar").on('click', function () {
      codigo = $(".codigo").val();
      fecha = $(".fecha").val();
      valorTotal = $(".valorTotal").val();
      cliente_id = $(".cliente_id").val();
      estado = $(".estado").val();

      if (codigo === '' || fecha === '' || valorTotal === '' || cliente_id === '' || estado === '--Seleccione--') {
          alert("Campos vacíos, por favor llénelos.");
      }
  });
});
