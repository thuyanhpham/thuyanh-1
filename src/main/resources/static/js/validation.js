$(document).ready(function () {
    // Gọi API để lấy danh sách địa chỉ
    $.get("/api/address", function (data) {
        let dropdown = $("#addressId");
        dropdown.empty();
        dropdown.append(`<option value="">-- Chọn Địa Chỉ --</option>`); 
        $.each(data, function (index, address) {
            dropdown.append(`<option value="${address.id}">${address.city}, ${address.province}</option>`);
        });
    }).fail(function () {
        console.error("Không thể tải danh sách địa chỉ!");
    });

    $("#employeeForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
            email: {
                required: true,
                email: true
            },
            phone: {
                required: true,
                phoneVN: true
            },
            addressId: {
                required: true
            }
        },
        messages: {
            name: {
                required: "Vui lòng nhập tên!",
                minlength: "Tên phải có ít nhất 3 ký tự!",
                maxlength: "Tên không được vượt quá 50 ký tự!"
            },
            email: {
                required: "Vui lòng nhập email!",
                email: "Email không hợp lệ!"
            },
            phone: {
                required: "Vui lòng nhập số điện thoại!"
            },
            "address1.id": {
                required: "Vui lòng chọn địa chỉ!"
            }
        },
        errorPlacement: function (error, element) {
			console.log("Lỗi tại trường: ", element.attr("name"), "=>", error.text());
            error.insertAfter(element);
        },
		invalidHandler: function (event, validator) {
			console.log("Form có lỗi: ", validator.numberOfInvalids());
		},
        submitHandler: function (form) {
			console.log("Form hợp lệ, chuẩn bị submit!")
            form.submit();
        }
    });
});
