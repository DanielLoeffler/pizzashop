
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset=utf-8>
            <title>Pizzashop HTML</title>
            <style>
                table {
                    border-collapse: collapse;
                    width: 300px;
                }
            </style>

        </head>
        <body background=http://cdn4.micasa.ch/medias/sys_master/zoom/1/c/5/6/id_10295631904798_zoom.jpg><b>
            <a href=Pizza Restaurant.html>
                <h1>Pizzeria HTML</h1>
            </a><br>
            <br>
            Pizza lieferung:
            <a href=https://www.dieci.ch/de/ target="_blank">bitte hier klicken um Die bestellung zu machen.<br></a><br>
            Zur auswahl stehen folgende Sorten mit dem Preis f&uumlr die Kleine Pizza

            <br>
            <br>

            <#if pizzas??>
                <table>
                    <#list pizzas as pizza>
                        <tr>
                            <td>${pizza.name}</td>
                            <td>${pizza.price}</td>
                            <td>id: ${pizza.id}</td>
                        </tr>
                    </#list>
                </table>
            <#else>
                Es sind keine Pizzas gespeichert
            </#if>


            <br>
            <br>
            <form action="PizzaServlet" method="post"> creat<label for=idcreate>Id: <input id=idcreate name=idcreate></label>
                <br>
                <br>
                creat <label for=namecreate>Name: <input id=namecreate name=namecreate></label>
                <br>
                <br>
                creat <label for=pricecreate>Price: <input id=pricecreate name=pricecreate></label><br><input type="submit" value="SubmitCreatePizza">
            </form>
            <br>
        </body>
    </html>

