package Hotel

fun AbastecimentoDeAutomoveis() {
    println("===ABASTECIMENTO===")
    println("Wayne Oil")
    println("Informe o preço do álcool:")
    var alcoolWayne: Double?

    while (true) {
        println("Informe o preço do álcool:")
        alcoolWayne = readln().toDoubleOrNull()

        if (alcoolWayne != null && alcoolWayne >= 0) {
            break
        }

        println("Preço inválido.")
    }

    var gasolinaWayne: Double?
    while (true) {
        println("Informe o preço da gasolina:")
        gasolinaWayne = readln().toDoubleOrNull()
        if (gasolinaWayne != null && gasolinaWayne >= 0) {
            break
        }
        println("Preço inválido.")
    }


    var melhorCombustivelWayne: String
    var custoWayne: Double?

    if (alcoolWayne <= gasolinaWayne * 0.70) {
        melhorCombustivelWayne = "Álcool"
        custoWayne = alcoolWayne * 42
    } else {
        melhorCombustivelWayne = "Gasolina"
        custoWayne = gasolinaWayne * 42
    }
    println("Stark Petrol")
    var alcoolStark: Double?
    while (true) {
        println("Informe o preço do alcool:")
        alcoolStark = readln().toDoubleOrNull()
        if (alcoolStark != null && alcoolStark >= 0) {
            break
        }
        println("Preço inválido.")
    }
    var gasolinaStark: Double?
    while(true){
    println("Informe o preço da gasolina:")
   gasolinaStark = readln().toDoubleOrNull()
        if(gasolinaStark != null && gasolinaStark >= 0) {
        break
        }
    }
    var melhorCombustivelStark: String
    var custoStark: Double


    if (alcoolStark <= gasolinaStark * 0.70) {
        melhorCombustivelStark = "Álcool"
        custoStark = alcoolStark * 42
    }
    else {
        melhorCombustivelStark = "Gasolina"
        custoStark = gasolinaStark * 42
    }
    if (custoWayne < custoStark) {
        println("1º - Wayne Oil: R$ %.2f".format(custoWayne))
        println("2º - Stark Petrol: R$ %.2f".format(custoStark))
    } else {
        println("1º - Stark Petrol: R$ %.2f".format(custoStark))
        println("2º - Wayne Oil: R$ %.2f".format(custoWayne))
    }
    if (custoWayne < custoStark) {
        println("$nomeFuncionario, é mais barato abastecer com $melhorCombustivelWayne no posto Wayne Oil.")
    } else {
        println("$nomeFuncionario, é mais barato abastecer com $melhorCombustivelStark no posto Stark Petrol.")
    }
}