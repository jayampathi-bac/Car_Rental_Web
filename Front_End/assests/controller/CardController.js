// $('#viewCars').scrollspy({ target: '#list-example' })
$('#btn-guestUser').click(function () {
    $('#test').empty();
    loadVehicleCards();
});
$('#btn-all').click(function () {
    $('#test').empty();
    loadVehicleCards();
});
$('#btn-sort').click(function () {
    let passengers=$('#passsearch').val();
    let transs=$('#transsearch').val();
    let types=$('#typesearch').val();
    let fuels=$('#fuelsearch').val();
    $('#test').empty();

    $.ajax({
        url: "http://localhost:8080/Back_End_war/api/v1/vehicle",
        dataType: 'json',
        success: function (res) {
            let data = res.data;
            for (var i in data) {
                let id = data[i].id;
                let brand = data[i].brand;
                let type = data[i].type;
                let image = data[i].image;
                let passenger = data[i].passenger;
                let transmission = data[i].transmission;
                let fuel = data[i].fuel;
                let dailyrate = data[i].dailyrate;
                let freekmforday = data[i].freekmforday;
                let monthlyrate = data[i].monthlyrate;
                let freekmformonth = data[i].freekmformonth;
                let priceperextrakm = data[i].priceperextrakm;
                let milage = data[i].milage;

                if ((passengers == passenger) & (transs == transmission) & (types == type) & (fuels == fuel)){

                    // var templateString = '<div class="card" style="max-width: 540px;">' +
                    //     ' <div class="row no-gutters">' + '<div class="col-md-4">' +
                    //     '<img src= "' + image + '">' + '</div>' +
                    //     '<div class="col-md-8">' + '<div class="card-body">' +
                    //     '<h5 class="card-title">' + data[i].brand + '</h5>' +
                    //     '<p class="card-text">' + brand + "  , Type = " + type + " , No Of Passengers =" + passenger + " , Transmission = " + transmission + " , DailyRate = " + dailyrate + " , Free Km per Day = " + freekmforday + " , Monthly Rate = " + monthlyrate + " , Free KM for Month = " + freekmformonth + " , Price Per Extra KM = " + priceperextrakm +
                    //     " , fuel type = " + fuel + '</p>' + '</div>' + '</div>' + '</div>' + '</div>';

                    var templateString='<div class="card" style="max-width: 70%;">\n' +
                        '    <div class="row no-gutters">\n' +
                        '        <div class="col-md-4">\n' +
                        '   <!--   Image silde   -->\n' +
                        '            <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">\n' +
                        '                <div class="carousel-inner">\n' +
                        '                    <div class="carousel-item active" data-interval="10000">\n' +
                        '                        <img src="assests/pictures/car.png" class="d-block w-100" alt="...">\n' +
                        '                    </div>\n' +
                        '                    <div class="carousel-item" data-interval="2000">\n' +
                        '                        <img src="assests/pictures/download.png" class="d-block w-100" alt="...">\n' +
                        '                    </div>\n' +
                        '                    <div class="carousel-item">\n' +
                        '                        <img src="..." class="d-block w-100" alt="...">\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '                <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">\n' +
                        '                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>\n' +
                        '                    <span class="sr-only">Previous</span>\n' +
                        '                </a>\n' +
                        '                <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">\n' +
                        '                    <span class="carousel-control-next-icon" aria-hidden="true"></span>\n' +
                        '                    <span class="sr-only">Next</span>\n' +
                        '                </a>\n' +
                        '            </div>\n' +
                        '        </div>\n' +
                        '        <div class="col-md-8">\n' +
                        '            <div class="card-body">\n' +
                        '                <h5 class="card-title">'+data[i].brand+'</h5>\n' +
                        '                <p class="card-text">'+brand+"  , Type = "+type+" , No Of Passengers ="+passenger+" , Transmission = "+transmission+" , DailyRate = "+dailyrate+" , Free Km per Day = "+freekmforday+" , Monthly Rate = "+monthlyrate+" , Free KM for Month = "+freekmformonth+" , Price Per Extra KM = "+priceperextrakm+
                        " , fuel type = "+fuel+'</p>\n' +
                        '            </div>\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '</div>'
                    $('#test').append(templateString);
                }
            }
        }
    });

});
function loadVehicleCards() {
    $.ajax({
        url: "http://localhost:8080/Back_End_war/api/v1/vehicle",
        dataType: 'json',
        success: function (res) {
            let data = res.data;
            for (var i in data) {
                let id = data[i].id;
                let brand = data[i].brand;
                let type =data[i].type;
                let image=data[i].image;
                let passenger = data[i].passenger;
                let transmission = data[i].transmission;
                let fuel = data[i].fuel;
                let dailyrate = data[i].dailyrate;
                let freekmforday = data[i].freekmforday;
                let monthlyrate = data[i].monthlyrate;
                let freekmformonth = data[i].freekmformonth;
                let priceperextrakm = data[i].priceperextrakm;
                let milage = data[i].milage;

                // var templateString = '<div class="card mb-3" style="max-width: 540px;">' +
                //     ' <div class="row no-gutters">' +'<div class="col-md-4">'+
                //     '<img src= "'+image+'">' +'</div>'+
                //     '<div class="col-md-8">'+'<div class="card-body">'+
                //     '<h5 class="card-title">'+data[i].brand+'</h5>'+
                //     '<p class="card-text">'+brand+"  , Type = "+type+" , No Of Passengers ="+passenger+" , Transmission = "+transmission+" , DailyRate = "+dailyrate+" , Free Km per Day = "+freekmforday+" , Monthly Rate = "+monthlyrate+" , Free KM for Month = "+freekmformonth+" , Price Per Extra KM = "+priceperextrakm+
                //     " , fuel type = "+fuel+'</p>'+'</div>'+'</div>'+'</div>'+'</div>';
                var templateString='<div class="card" style="max-width: 70%;">\n' +
                    '    <div class="row no-gutters">\n' +
                    '        <div class="col-md-4">\n' +
                    '   <!--   Image silde   -->\n' +
                    '            <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">\n' +
                    // '                <div class="carousel-inner">\n' +
                    // '                    <div class="carousel-item active" data-interval="10000">\n' +
                    // '                        <img src="assests/pictures/carHome.webp" class="d-block w-100" alt="...">\n' +
                    // '                    </div>\n' +
                    // '                    <div class="carousel-item" data-interval="2000">\n' +
                    // '                        <img src="assests/pictures/carHome.webp" class="d-block w-100" alt="...">\n' +
                    // '                    </div>\n' +
                    // '                    <div class="carousel-item">\n' +
                    // '                        <img src="..." class="d-block w-100" alt="...">\n' +
                    // '                    </div>\n' +
                    // '                </div>\n' +
                    '                <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">\n' +
                    '                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>\n' +
                    '                    <span class="sr-only">Previous</span>\n' +
                    '                </a>\n' +
                    '                <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">\n' +
                    '                    <span class="carousel-control-next-icon" aria-hidden="true"></span>\n' +
                    '                    <span class="sr-only">Next</span>\n' +
                    '                </a>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '        <div class="col-md-8">\n' +
                    '            <div class="card-body">\n' +
                    '                <h5 class="card-title">'+data[i].brand+'</h5>\n' +
                    '                <p class="card-text">'+brand+"  , Type = "+type+" , No Of Passengers ="+passenger+" , Transmission = "+transmission+" , DailyRate = "+dailyrate+" , Free Km per Day = "+freekmforday+" , Monthly Rate = "+monthlyrate+" , Free KM for Month = "+freekmformonth+" , Price Per Extra KM = "+priceperextrakm+
                    " , fuel type = "+fuel+'</p>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '</div>'
                $('#test').append(templateString);

            }
        }
    });
}