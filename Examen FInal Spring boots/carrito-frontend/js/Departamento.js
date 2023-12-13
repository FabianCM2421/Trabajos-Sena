

function loadData() {
    $.ajax({
        url: "http://localhost:9000/v1/api/Departamento",
        method: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data);
            var html = "";

            data.forEach(function (item) {
                // Construir el HTML para cada objeto
                html +=
                    `<tr>
                    <td>` + item.codigo + `</td>
                    <td>` + item.nombre + `</td>
                    <td>` + item.paisId.nombre + `</td>
                    <td>` + (item.estado == true ? "Activo" : "Inactivo") + `</td>
                    <th><img src="../asset/icon/pencil-square.svg" alt="" onclick="findById(`+ item.id + `)"></th>
                    <th><img src="../asset/icon/trash3.svg" alt="" onclick="deleteById(`+ item.id + `)"></th>
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

function loadPais() {
    $.ajax({
        url: 'http://localhost:9000/v1/api/pais',
        method: "GET",
        dataType: "json",
        success: function (data) {
            var html = "<option selected>--Seleccione--</option>";

            data.forEach(function (item) {
                // Construir el HTML para cada objeto
                html += `<option value="${item.id}">${item.nombre}</option>`;
            });

            $("#pais_id").html(html);
        },
        error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        },
    });
}

function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/v1/api/Departamento/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.id);
            $('#codigo').val(data.codigo);
            $('#nombre').val(data.nombre);
            $("#pais_id").val(data.paisId.id);
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
    $.ajax({
        url: 'http://localhost:9000/v1/api/Departamento/' + id,
        method: "delete",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        alert("Registro eliminado con éxito");
        loadData();
        clearData();
    })
}

function clearData() {
    $('#id').val('');
    $('#codigo').val('');
    $('#nombre').val('');
    $('#pais_id').val('');
    $('#estado').val('');
}

async function getPaisId(id) {
    return new Promise(function (resolve, reject) {
        $.ajax({
            url: "http://localhost:9000/v1/api/pais/" + id,
            method: "GET",
            dataType: "json",
            success: function (data_Pais) {
                resolve(data_Pais);
            },
            error: function (error) {
                reject(error);
            },
        });
    });
}

async function save() {
    var pais_id = parseInt($("#pais_id").val());
    console.log(pais_id);

    try {
        var pais = await getPaisId(pais_id);
        console.log(pais);
        // Construir el objeto data
        var data = {
            'codigo': $('#codigo').val(),
            'nombre': $('#nombre').val(),
            "paisId": pais,
            'estado': parseInt($('#estado').val()),
        };

        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:9000/v1/api/Departamento',
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: jsonData,
            success: function (data) {
                alert("Registro agregado con éxito");
                loadData();
                clearData();
            },
            error: function (error) {
                console.error('Error en la solicitud:', error);
            }
        });
    } catch (error) {
        console.error("Error obteniendo el cliente:", error);
    }
}

async function update() {
    var pais_id = parseInt($("#pais_id").val());
    console.log(pais_id);

    try {
        var pais = await getPaisId(pais_id);
        console.log(pais);
        // Construir el objeto data
        var data = {
            'codigo': $('#codigo').val(),
            'nombre': $('#nombre').val(),
            "paisId": pais,
            'estado': parseInt($('#estado').val()),
        };
        var id = $("#id").val();
        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:9000/v1/api/Departamento/' + id,
            data: jsonData,
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            }
        }).done(function (result) {
            alert("Registro actualizado con éxito");
            loadData();
            clearData();

            //actualzar boton
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Agregar');
            btnAgregar.attr('onclick', 'save()');
        })
    } catch (error) {
        console.error("Error obteniendo el cliente:", error);
    }
}