

function processFiles(files) {
	var file = files[0];

	var reader = new FileReader();

	reader.onload = function (e) {
		// Cuando éste evento se dispara, los datos están ya disponibles.
		// Se trata de copiarlos a una área <div> en la página.
		//var output = document.getElementById("fileOutput"); 
		//alert(e.target.result);
		//output.textContent = e.target.result;

		callws(e.target.result);
	};
	reader.readAsText(file);


	

}


    function callws(fileUploaded) {

		var json={
    "winnerPlayer": "\"Player1\"",
    "winnerStrategy": "\"P\"",
    "secondPlayer": "\"Player2\"",
    "secondStrategy": "\"R\""
}
		
		var result = JSON.stringify(json); // '{"name":"binchen"}'

		var result = JSON.parse(JSON.stringify(json));

		//alert(JSON.stringify(json)); // imprime el json
		//alert(result.winnerPlayer); // imprime el valor de winnerPlayer


		document.getElementById("tdWinner").innerHTML = result.winnerPlayer;
		document.getElementById("tdWinnerStrategy").innerHTML = result.winnerStrategy;
		document.getElementById("tdSecond").innerHTML = result.secondPlayer;
		document.getElementById("tdSecondStrategy").innerHTML = result.secondStrategy;
		document.getElementById("divResult").style.display = "";

    }

    function hiddenResults() {
    	document.getElementById("divResult").style.display = "none";
    }

    function hiddenTopTen() {
    	document.getElementById("divResult2").style.display = "none";
    }

    function hiddenAbout() {
    	document.getElementById("divAbout").style.display = "none";
    }

    function resetDB() {

    	alert("DB Cleaned");
    }

    function topTen() {

    	var top = [
		    {"namePlayer":"Player1", "pointsPlayer":"30"},
		    {"namePlayer":"Player2", "pointsPlayer":"27"},
		    {"namePlayer":"Player3","pointsPlayer": "24"},
		    {"namePlayer":"Player4","pointsPlayer": "21"},
		    {"namePlayer":"Player5","pointsPlayer": "18"},
		    {"namePlayer":"Player6","pointsPlayer": "15"},
		    {"namePlayer":"Player7","pointsPlayer": "12"},
		    {"namePlayer":"Player8","pointsPlayer": "9"},
		    {"namePlayer":"Player9","pointsPlayer": "6"},
		    {"namePlayer":"Player10","pointsPlayer": "3"}
		];


		var result = JSON.stringify(top); // '{"name":"binchen"}'

		var result = JSON.parse(JSON.stringify(top));

		//alert(JSON.stringify(json)); // imprime el json
		//alert(result.winnerPlayer); // imprime el valor de winnerPlayer


		document.getElementById("tdOne").innerHTML = top[0].namePlayer;
		document.getElementById("tdOnePoints").innerHTML = top[0].pointsPlayer;
		document.getElementById("tdTwo").innerHTML = top[1].namePlayer;
		document.getElementById("tdTwoPoints").innerHTML = top[1].pointsPlayer;
		document.getElementById("tdThree").innerHTML = top[2].namePlayer;
		document.getElementById("tdThreePoints").innerHTML = top[2].pointsPlayer;
		document.getElementById("tdFour").innerHTML = top[3].namePlayer;
		document.getElementById("tdFourPoints").innerHTML = top[3].pointsPlayer;
		document.getElementById("tdFive").innerHTML = top[4].namePlayer;
		document.getElementById("tdFivePoints").innerHTML = top[4].pointsPlayer;
		document.getElementById("tdSix").innerHTML = top[5].namePlayer;
		document.getElementById("tdSixPoints").innerHTML = top[5].pointsPlayer;
		document.getElementById("tdSeven").innerHTML = top[6].namePlayer;
		document.getElementById("tdSevenPoints").innerHTML = top[6].pointsPlayer;
		document.getElementById("tdEight").innerHTML = top[7].namePlayer;
		document.getElementById("tdEightPoints").innerHTML = top[7].pointsPlayer;
		document.getElementById("tdNine").innerHTML = top[8].namePlayer;
		document.getElementById("tdNinePoints").innerHTML = top[8].pointsPlayer;
		document.getElementById("tdTen").innerHTML = top[9].namePlayer;
		document.getElementById("tdTenPoints").innerHTML = top[9].pointsPlayer;
		document.getElementById("divResult2").style.display = "";
		

    }


    function about() {
    	//alert("aboutr");

//window.open("About.html",'','top=300,left=300,width=300,height=300');
	document.getElementById("divAbout").style.display = "";

    }

    function download() {
    	alert("Under construction...");
    }