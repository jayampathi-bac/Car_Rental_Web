$("#btn-main-login").click(function () {
    let username= $("#username").val();
    let password = $("#password").val();
    // $.ajax({
    //     method:"get",
    //     url: "http://localhost:8080/Back_End_war/api/v1/login",
    //     contentType: "application/json",
    //     // data: JSON.stringify({
    //     //     "username":username,
    //     //     "password":password,
    //     //
    //     // }),
    //     success: function (res) {
    //         console.log(res)
    //         let a=res.data;
    //         if (res.data==1) {
    //             $('#adminPage').css('display','block');
    //             $('#registeredUserPage').css('display','none');
    //             $('#driverPage').css('display','none');
    //             $('#guestUserPage').css('display','none');
    //         }
    //         if(res==2){
    //             $('#registeredUserPage').css('display','block');
    //             $('#adminPage').css('display','none');
    //             $('#driverPage').css('display','none');
    //             $('#guestUserPage').css('display','none');
    //         }
    //         if(res.data==3){
    //             $('#driverPage').css('display','block');
    //             $('#adminPage').css('display','none');
    //             $('#registeredUserPage').css('display','none');
    //             $('#guestUserPage').css('display','none');
    //         }
    //     }
    // });
    $.ajax({
        method: "post",
        url: "http://localhost:8080/Back_End_war/api/v1/login",
        contentType: "application/json",
        data: JSON.stringify({
            "username" :username,
            "password" :password
        }),
        success: function (res) {
            console.log(res);
            if (res.status==1) {
                $('#homePage').css('display','none');
                $('#adminPage').css('display','block');
                $('#registeredUserPage').css('display','none');
                $('#driverPage').css('display','none');
                $('#guestUserPage').css('display','none');

                $('#dashboard').css('display','block');
                $('#car-manage').css('display','none');
                $('#user-manage').css('display','none');
                $('#driver-manage').css('display','none');
                $('#schedule-manage').css('display','none');
                $('#request-manage').css('display','none');
                $('#maintainance-manage').css('display','none');
                $('#payment-manage').css('display','none');
                $('#income-manage').css('display','none');
            }
            if(res.status==2){
                $('#registeredUserPage').css('display','block');
                $('#homePage').css('display','none');
                $('#adminPage').css('display','none');
                $('#driverPage').css('display','none');
                $('#guestUserPage').css('display','none');

                $('#usercarview').css('display','block');
                $('#userSettings').css('display','none');
                $("#cus-form-id").text(res.userid);
                loadVehicles();
            }
            if(res.status==3){
                $('#driverPage').css('display','block');
                $('#adminPage').css('display','none');
                $('#registeredUserPage').css('display','none');
                $('#guestUserPage').css('display','none');
                $('#homePage').css('display','none');


                $('#driverSchedule').css('display','block');
                $('#drivereditdetails').css('display','none');
            }
        }
    });
});
//set userid for customer
$("#btn-userLogin").click(function () {
    $.ajax({
        method: "get",
        url: "http://localhost:8080/Back_End_war/api/v1/customer",
        success:function (e) {
            //let Id= "id :"+e;
            $("#Cuserid").text(e)
        }
    });
});
//set userid for driver
$("#btn-drivermanage").click(function () {
    $.ajax({
        method: "get",
        url: "http://localhost:8080/Back_End_war/api/v1/driver",
        success:function (e) {
            //let Id= "id :"+e;
            console.log(e)
            $("#driverid").val(e)
            //$("#Cuserid").text(e)
        }
    });
});
