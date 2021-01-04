function loadAllfreeDrivers() {
    $("#tblDriver").empty();
    $.ajax({
        url: "http://localhost:8080/Back_End_war/api/v1/driver/getallFreedriver",
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

                $("#select-tblDriver").append(row);
                $("#select-tblDriver tr").on('click',function () {
                    $("#sel-driverid").val($($(this).children().get(0)).text());

                })

            }
        }
    });
}
$("#btn-selectdriver").click(function () {
    $("#select-tblDriver").empty();
loadAllfreeDrivers();
})
//--load table--


//send Approval---
$("#btn-select-driver").click(function () {
    let dId = $("#sel-driverid").val()
    console.log(dId)
    $("#btn-selectdriver").text(dId)
});

  $("#btn-acceptRequest").click(function () {
      $.ajax({
        method: "get",
        url: "http://localhost:8080/Back_End_war/api/v1/approval",
        success:function (e) {
            let approvalid = e;
            let bookingid = $("#req-bookingid").val();
            let vehicleid = $("#req-carid").val();
            let driverid = $("#btn-selectdriver").text();
            $.ajax({
                method: "post",
                url: "http://localhost:8080/Back_End_war/api/v1/approval",
                contentType: "application/json",
                data: JSON.stringify({
                    "approvalid":approvalid,
                    "bookingid": bookingid,
                    "driverid": driverid,
                    "vehicleid": vehicleid,

                }),
                success: function (res) {

                    $.ajax({
                       // method:"post",
                        url:"http://localhost:8080/Back_End_war/api/v1/driver/update/" + driverid,
                        success:function (res){
                            if (res.message == "Success") {
                                alert("Status update..!");

                            } else {
                                alert("Status not update..!");
                            }
                        }
                    });
                    alert(res.message);
                    if (res.message == "Success") {
                        alert("Approval added");
                        clearApproval();
                    } else {
                        alert("Approval Failed");
                        clearApproval();
                    }
                }
            });
            $("#btn-selectdriver").text("Add driver");
        }  });
})

function loadAllApproval() {
$("#tbdy-payment").empty()
    $.ajax({
        url: "http://localhost:8080/Back_End_war/api/v1/approval/getall",
        dataType: 'json',
        success: function (res) {
            let data = res.data;
            for (var i in data) {
                let approvalid = data[i].approvalid;
                let bookingid = data[i].bookingid;
                let vehiclid =data[i].vehicleid;
                let driverid = data[i].driverid;

                var row = `<tr><td>${approvalid}</td><td>${bookingid}</td><td>${driverid}</td>
                            <td>${vehiclid}</td></tr>`;
                $("#tbdy-payment").append(row);

                $("#tbdy-payment tr").on('click',function () {
                    let userid;
                    let id=($($(this).children().get(1)).text());
                    $.ajax({
                        url: "http://localhost:8080/Back_End_war/api/v1/booking/" + id,
                        success: function (res) {
                            console.log(res)
                            console.log(res.data.userid);
                           userid=res.data().res.data.userid01;
                            }

                    });

                    $("#pay-bookingid").val($($(this).children().get(1)).text());
                    $("#pay-userid").val(userid);
                    $("#pay-vehiclid").val($($(this).children().get(2)).text());
                    $("#pay-driverid").val($($(this).children().get(3)).text());

                })

            }
        }
    });
}