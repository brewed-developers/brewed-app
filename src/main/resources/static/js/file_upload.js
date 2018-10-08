$('#singleUploadForm').submit(function(event) {

    event.preventDefault();
    var formElement = this;

    var formData = new FormData(formElement);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/storage/s3/uploadFile",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            console.log(response);
            // process response
        },
        error: function (error) {
            console.log(error);
            // process error
        }
    });

});