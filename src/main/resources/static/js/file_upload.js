$('#singleUploadForm').submit(function(event) {

    event.preventDefault();
    var formElement = this;
    var voucherId =$('#voucherId').val();
    //var showBanner=$('#showBanner').val();

    var formData = new FormData(formElement);
     formData.append("id",voucherId);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/admin/uploadVoucherImage",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            console.log(response);
            alert("File Upload Success");
            location.reload();
            // process response
        },
        error: function (error) {
            console.log(error);
            alert("File Upload Failed");
        }
    });

});



$('#bannerUploadForm').submit(function(event) {

    event.preventDefault();
    var formElement = this;
    var voucherId =$('#id').val();
    //var showBanner=$('#showBanner').val();

    var formData = new FormData(formElement);
     formData.append("id",voucherId);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/admin/uploadBanner",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            console.log(response);
            alert("File Upload Success");
            location.reload();
            // process response
        },
        error: function (error) {
            console.log(error);
            alert("File Upload Failed");
        }
    });

});