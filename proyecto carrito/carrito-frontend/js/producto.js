function save() {
    // Construir el objeto data
    var data = {
      'codigo': $('#codigo').val(),
      'nombre': $('#nombre').val(),
      'precio': parseFloat($('#precio').val()),
      'cantidad': parseInt($('#cantidad').val()),
      'estado': parseInt($('#estado').val()),
    };
  
    var jsonData = JSON.stringify(data);
    $.ajax({
      url: 'http://localhost:9000/v1/api/producto',
      method: 'POST',
      dataType: 'json',
      contentType: 'application/json',
      data: jsonData,
      success: function (data) {
        var ProductoAgregado = data.nombre;
  
        Swal.fire({
          title: "Producto Agregado!",
          html: `El Producto <strong>${ProductoAgregado}</strong> fue añadido con éxito.`,
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
      url: 'http://localhost:9000/v1/api/producto/' +id,
      data: jsonData,
      method: "PUT",
      headers: {
        "Content-Type": "application/json"
      },
    success: function (data) {
      var ProductoAgregado = data.nombre;

      Swal.fire({
        title: "Prodcuto Actualizado!",
        html: `El Prodcuto <strong>${ProductoAgregado}</strong> fue actualizado con éxito.`,
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
      url: 'http://localhost:9000/v1/api/producto',
      method: 'GET',
      dataType: 'json',
      success: function (data) {
        var html = '';
  
        data.forEach(function (item) {
          // Construir el HTML para cada objeto
          html += `<tr>
                  <td>`+ item.codigo + `</td>
                  <td>`+ item.nombre + `</td>
                  <td>`+ item.precio + `</td>
                  <td>`+ item.cantidad + `</td>
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
      url: 'http://localhost:9000/v1/api/producto/' + id,
      method: 'GET',
      dataType: 'json',
      success: function (data) {
        $('#id').val(data.id);
        $('#codigo').val(data.codigo);
        $('#nombre').val(data.nombre);
        $('#precio').val(data.precio);
        $('#cantidad').val(data.cantidad);
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
      url: 'http://localhost:9000/v1/api/producto/' + id,
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
    $('#id').val('');
    $('#codigo').val('');
    $('#nombre').val('');
    $('#precio').val('');
    $('#cantidad').val('');
    $('#estado').val('');
  }