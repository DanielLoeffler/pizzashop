
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset=utf-8>
            <title>Pizzashop HTML</title>
            <link rel="stylesheet" type="text/css" href="style.css">
            <style>
                table {
                    border-collapse: collapse;
                    width: 300px;
                }
                * {
                    box-sizing: border-box;
                }

                body {
                    font-family: Arial, Helvetica, sans-serif;
                    color: black;
                }


                header {
                    background-color: rgba(149, 165, 166, 0.8);
                    padding: 30px;
                    text-align: center;
                    font-size: 35px;
                    color: blue;
                }


                nav {
                    float: left;
                    width: 30%;
                    /*height: 300px;  only for demonstration, should be removed */
                    background: rgba(149, 165, 166, 0.8);
                    padding: 20px;
                }


                nav ul {
                    list-style-type: none;
                    padding: 0;
                }

                article {
                    float: left;
                    padding: 20px;
                    width: 70%;
                    background-color: rgba(248, 249, 249, 0.8);
                    /*height: 300px;  only for demonstration, should be removed */
                }


                section:after {
                    content: "";
                    display: table;
                    clear: both;
                }


                footer {
                    background-color: rgba(149, 165, 166, 0.8);
                    padding: 10px;
                    text-align: center;
                    color: black;
                }


                @media (max-width: 600px) {
                    nav, article {
                        width: 100%;
                        height: auto;
                    }
                }

                  table.center {
                    margin-left:auto;
                    margin-right:auto;
                  }
            </style>

        </head>
        <body background="https://previews.123rf.com/images/feverpitched/feverpitched1008/feverpitched100800015/7652506-rot-und-wei%C3%9F-kariert-picknick-decke-tischtuch-detail.jpg">
            <header>
              <a href=http://localhost:8080/test/pizza>
                  <h1>Pizzeria HTML</h1>
              </a>
            </header>

            <section>
                <nav>
                    <ul>
                        <li><a href=https://www.dieci.ch/de/ target="_blank">Pizza lieferung</a></li>
                        <li>Wählen sie eine Pizza aus:</li>
                    </ul>

                    <form action="order" method="post">
                        <#if pizzas??>
                            <select name="pizza">
                                <#list pizzas as pizza>
                                    <option value="${pizza.id}">${pizza.name}</option>
                                </#list>
                            </select>

                            <br>
                            <br>
                            <table>
                                <tr>
                                    <td>
                                        anzahl:
                                    </td>
                                    <td>
                                        <label for=anzahl><input id=anzahl name=anzahl></label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Tel:
                                    </td>
                                    <td>
                                        <label for=tel><input id=tel name=tel></label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        addresse:
                                    </td>
                                    <td>
                                        <label for=address><input id=address name=address></label>
                                    </td>
                                </tr>
                            </table>
                            <input type="submit" value="SubmitOrderPizza">
                            <br>
                            <br>
                            Es sind folgende orders vorhanden:
                            <br>
                            <#if orders??>
                                <#list orders as order>
                                    ${order.phone},
                                    ${order.address},
                                </#list>
                            <#else>
                                Es giebt keine gespeicherte Orders
                            </#if>
                        </#if>

                    </form>
                </nav>

                <article>
                    <h1>Zur auswahl stehen folgende Sorten mit dem Preis f&uuml;r die Kleine Pizza</h1>
                    <p>
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
                    </p>
                </article>
            </section>

            <footer>
                <p>Eien neue Pizza erstellen</p>
                <p>
                    <form action="pizza" method="post">
                        <table class="center">

                            <tr>
                                <td><label for=namecreate>create Name: </td>
                                <td><input id=namecreate name=namecreate></label></td>
                            </tr>

                            <tr>
                                <td><label for=pricecreate>create Price: </td>
                                <td><input id=pricecreate name=pricecreate></label></td>
                            </tr>

                        </table>
                        <br>
                        <input type="submit" value="SubmitCreatePizza">
                    </form>
                </p>
            </footer>
        </body>
    </html>

