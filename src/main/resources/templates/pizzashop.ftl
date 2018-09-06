Pizzashop - ${pizzaString}
Pizzashop - ${createPizzaString}

============================



    <!DOCTYPE html>
    <html>
        <head>
            <meta charset=utf-8>
            <title>Pizzashop HTML</title>
            <link rel=stylesheet type=text/css href=Pizza.css>
        </head>
        <body background=http://cdn4.micasa.ch/medias/sys_master/zoom/1/c/5/6/id_10295631904798_zoom.jpg><b>
            <a href=Pizza Restaurant.html>
            <h1>Pizzeria HTML</h1>
            </a><br>
            <br>
            Pizza lieferung:
            <a href=https://www.dieci.ch/de/>bitte hier klicken um Die bestellung zu machen.<br></a><br>
            Zur auswahl stehen folgende Sorten mit dem Preis f&uumlr die Kleine Pizza
            <br>
            <br>
            <button type=button>show all</button>
            <br>
            <br>
            show Pizza <form action="PizzaServlet" method="GET"><label for=idzahl>Nummer: <input id=idzahl name=idzahl></label><br><input type="submit" value="SubmitPizzaByID"></form>
            <br>
            <br>
    !       ${pizzaString}
            <br>
            <br>
            <form action="PizzaServlet" method="GET"> creat<label for=idcreate>Id: <input id=idcreate name=idcreate></label>
            <br>
            <br>
            creat <label for=namecreate>Name: <input id=namecreate name=namecreate></label>
            <br>
            <br>
            creat <label for=pricecreate>Price: <input id=pricecreate name=pricecreate></label><br><input type="submit" value="SubmitCreatePizza"></form>
            <br>
            <br>
    !       ${createPizzaString}
            <br>
            <br>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Preis</th>
                    <th>Bild</th>
                </tr>
                <tr>
                    <td>Pizza Margherita</td>
                    <td>6.-</td>
                    <td><img src=http://www.cbc.ca/inthekitchen/assets_c/2012/11/MargheritaPizza21-thumb-596x350-247022.jpg width=200></td>
                </tr>
                <tr>
                    <td>Pizza Hawaii</td>
                    <td>6.50 Fr.</td>
                    <td><img src=https://images.kurier.at/46-90332057.jpg/620x340/248.134.343width=200></td>
                </tr>
                <tr>
                    <td>Pizza Napoli</td>
                    <td>7.50 Fr.</td>
                    <td><img src=https://media-cdn.tripadvisor.com/media/photo-s/0d/11/36/0c/pizza-napoli.jpgwidth=200></td>
                </tr>
                <tr>
                    <td>Pizza Verdi</td>
                    <td>5.50 Fr.</td>
                    <td><img src=https://media-cdn.tripadvisor.com/media/photo-s/0a/80/8a/21/pizza-verdi.jpgwidth=200></td>
                </tr>
                <tr>
                    <td>&#9733 Pizza a la HTML &#9733</td>
                    <td>8.-</td>
                    <td><img src=http://blog.prospective.ch/wp-content/uploads/2012/08/qr-code.pngwidth=200></td>
                </tr>
            </table><br>
            <br>
            </b>
        </body>
    </html>