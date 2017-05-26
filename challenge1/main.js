var base,

app = {



    data : {
        0:{last_name: "Harris",
         first_name: "Mike",
         email_address: "mharris@updox.com",
         specialty: "Pediatrics",
         practice_name: "Harris Pediatrics"},

        1:{last_name: "Wijoyo",
         first_name: "Bimo",
         email_address: "bwijoyo@updox.com",
         specialty: "Podiatry",
         practice_name: "Wijoyo Podiatry"},

        2:{last_name: "Rose",
         first_name: "Nate",
         email_address: "nrose@updox.com",
         specialty: "Surgery",
         practice_name: "Rose Cutters"},

        3:{last_name: "Carlson",
         first_name: "Mike",
         email_address: "mcarlson@updox.com",
         specialty: "Orthopedics",
         practice_name: "Carlson Orthopedics"},

        4:{last_name: "Witting",
         first_name: "Mike",
         email_address: "mwitting@updox.com",
         specialty: "Pediatrics",
         practice_name: "Witting’s Well Kids Pediatrics"},

        5:{last_name: "Juday",
         first_name: "Tobin",
         email_address: "tjuday@updox.com",
         specialty: "General Medicine",
         practice_name: "Juday Family Practice"}
    },


    init : function(){
        console.log("Hello, World!");

        // $("#data").html("<h2>Hello there!</h2>");
        console.log(this.data[0]);
        this.loadData();
    },

    loadData: function() {
        var section = $(".data");
        section.append(JSON.stringify(this.data));
        //document.getElementById("data").innerHTML='<object type="text/html" data="home.html" ></object>';


    }




};


$.onload = app.init();
