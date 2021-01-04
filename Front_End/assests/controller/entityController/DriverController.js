// add driver
$("#btn-addDriver").click(function () {
    let id= $("#driverid").val();
    let name = $("#drivername").val();
    let contact = $("#drivercontact").val();
    let username= $("#driveruname").val();
    let password = $("#driverpass").val();
    let user={
        "userid":id,
        "username":username,
        "password":password,
        "status" :3
    }

    if((id!="")&(name!="")&(contact!="")&(username!="")&(password!="")){

            $.ajax({
                method: "post",
                url: "http://localhost:8080/Back_End_war/api/v1/driver",
                contentType: "application/json",
                data: JSON.stringify({
                    "id": id,
                    "name": name,
                    "contact":contact,
                    "username":username,
                    "password":password
                }),
                success: function (res) {
                    if (res.message == "Success") {
                        $.ajax({
                            method: "post",
                            url: "http://localhost:8080/Back_End_war/api/v1/user",
                            data: JSON.stringify(user),
                            contentType: "application/json",
                            success: function (res) {
                                if (res.message == "Success") {
                                    alert("User Registered");
                                    clearDriverField()
                                    setId();
                                } else {
                                    alert("User Register Failed");
                                    clearDriverField()
                                }
                            }
                        });
                        alert("Driver Registered");
                        clearDriverField()

                        loadAllDrivers();
                    } else {
                        alert("Register Failed");

                    }
                }
            });
    }else{
        alert("missing feilds");
    }
});
/// update vehicle
$("#btn-updateDriver").click(function () {
    let id= $("#driverid").val();
    let name = $("#drivername").val();
    let contact = $("#drivercontact").val();
    let username= $("#driveruname").val();
    let password = $("#driverpass").val();

    $.ajax({
        method: "put",
        url: "http://localhost:8080/Back_End_war/api/v1/driver",
        contentType: "application/json",
        data: JSON.stringify({
            "id": id,
            "name": name,
            "contact":contact,
            "username":username,
            "password":password
        }),
        success: function (res) {
            if (res.message == "Success") {
                alert("Driver Updated");
            } else {
                alert("Driver Update Failed"+res.data);
            }
           loadAllDrivers();
            clearDriverField()
        }
    });
});
/// delete driver
$("#btn-delereDriver").click(function (){
    let id= $("#driverid").val();
    $.ajax({
        method:"delete",
        url:"http://localhost:8080/Back_End_war/api/v1/driver?id="+id,
        success:function (res){
            if (res.message == "Success") {
                alert("Driver Removed..!");
                loadAllDrivers();
                clearDriverField()
                setId();
            } else {
                alert(res.data);
            }
        }
    });
});

/// load driver table
$('#btn-drivermanage').click(function () {
    loadAllDrivers();
})
function loadAllDrivers() {
    $("#tblDriver").empty();
    $.ajax({
        url: "http://localhost:8080/Back_End_war/api/v1/driver/getall",
        dataType: 'json',
        success: function (res) {
            let data = res.data;
            for (var i in data) {
                let id = data[i].id;
                let name = data[i].name;
                let contact =data[i].contact;
                let username = data[i].username;

                var row = `<tr><td>${id}</td><td>${name}</td><td>${contact}</td>
                            <td>${username}</td></tr>`;
                $("#tblDriver").append(row);


            }
        }
    });
}
function clearDriverField() {
    $("#driverid").val(null);
    $("#drivername").val(null);
    $("#drivercontact").val(null);
    $("#driveruname").val(null);
    $("#driverpass").val(null);
}
//set id
function setId(){
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
}
$('#btn-loadDriver').click(function () {
   loadAllDrivers();
   alert("loaded");
});
//search driver
$('#btn-searchDriver').click(function () {
    alert("hello");
   let id=$('#driversearch').val();
   alert(id);
    $.ajax({
        url: "http://localhost:8080/Back_End_war/api/v1/driver/" + id,
        success: function (res) {
            console.log(res);
            let driver = res.data;
            // set details to input fields
            let id=driver.id;
            if(id==undefined){
                alert("No Such Driver");
            }else{
                $("#driverid").val(driver.id);
                $("#drivername").val(driver.name);
                $("#drivercontact").val(driver.contact);
                $("#driveruname").val(driver.username);
                $("#driverpass").val(driver.password);

                var row = `<tr><td>${driver.id}</td><td>${driver.name}</td><td>${driver.contact}</td><td>${driver.username}</td>
                            </tr>`;
                $("#tblDriver").empty();
                $("#tblDriver").append(row);
            }
        }
    });
});
$('#drivereditdetail').click(function () {
    let id=$('#ddid').val();
    let username=$('#ddusername').val();
    let oldpass=$('#ddoldpass').val();
    let newpass=$('#ddnewpass').val();
    let conpass=$('#ddconpass').val();

    if((id!="")&(username!="")&(oldpass!="")&(newpass!="")&(conpass!="")){
        $.ajax({
            url: "http://localhost:8080/Back_End_war/api/v1/driver/?id="+id+"&password="+oldpass,
            success: function (res) {
                let data=res.data;
                if(data.id==undefined){
                    alert("Old Password Or User Id Incorrect");
                }else{
                    if(newpass==conpass){
                        alert("river exists");
                        update();
                    }else{
                        alert("passwords dont match");
                    }
                }
            }
        });
    }else{
        alert("Missing Feilds");
    }
});

function update() {

}
