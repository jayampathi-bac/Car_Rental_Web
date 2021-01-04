$('#btn-requestmanage').click(function () {
    loadAllRequests();
});
function loadAllRequests() {
    $("#tblRequest").empty();
    $.ajax({
        url: "http://localhost:8080/Back_End_war/api/v1/booking/getall",
        dataType: 'json',
        success: function (res) {
            let data = res.data;
            for (var i in data) {
                let rid=data[i].bookingid;
                let userid = data[i].userid;
                let carid = data[i].vehicleid;
                let waiverslip =data[i].waiver;
                let pickdate = data[i].pickupdate;
                let returndate = data[i].returndate;
                let driver = data[i].reqdriver;

                var row = `<tr><td>${rid}</td><td>${userid}</td><td>${carid}</td><td>${waiverslip}</td>
                            <td>${pickdate}</td><td>${returndate}</td><td>${driver}</td>
                            </tr>`;
                $("#tblRequest").append(row);

                $("#tblRequest tr").on('click',function () {
                    console.log("fired")
                    $("#req-bookingid").val($($(this).children().get(0)).text());
                    $("#req-carid").val($($(this).children().get(2)).text());
                    $("#req-veiwer").val($($(this).children().get(3)).text());
                    $("#req-pickupdate").val($($(this).children().get(4)).text());
                    $("#req-returndate").val($($(this).children().get(5)).text());


                })

            }
        }
    });
}
// $('#btn-acceptRequest').click(function () {
//     let rid=$("#did").val();
//     alert(rid);
//     $.ajax({
//         url: "http://localhost:8080/EasyCar/Request/" +rid,
//         success: function (res) {
//             console.log(res);
//             let request = res.data;
//             // get details of the request
//             let id=request.rid;
//             let datentime=request.datentime;
//             let userid=request.userid;
//             let carid=request.carid;
//             let pickdate=request.pickdate;
//             let returndate=request.returndate;
//             let waiverslip=request.waiverslip;
//             let driver=request.driver;
//
//             console.log(id+datentime+userid+carid+pickdate+returndate+waiverslip+driver);
//
//         }
//     });
// });



// function setdata() {
//     console.log("fired")
//     console.log($($(this).children().get(0)).text());
//     $("#req-userid").val($($(this).children().get(0)).text());
// }
