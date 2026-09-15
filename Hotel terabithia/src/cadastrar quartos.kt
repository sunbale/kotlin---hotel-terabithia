
package Hotel


fun mostrarMapaQuartos() {

    println("==== MAPA DE QUARTOS ====")

    for (quarto in 1..20) {

        val status = if (quartosOcupados[quarto - 1]) {
            "O"
        } else {
            "L"
        }

        print("%02d-$status\t".format(quarto))

        if (quarto % 5 == 0) {
            println()
        }
    }

    println("L = Livre | O = Ocupado")
}


fun mostrarQuartosLivres() {

    println("Quartos livres:")

    for (quarto in 1..20) {

        if (!quartosOcupados[quarto - 1]) {
            print("$quarto ")
        }
    }

    println()
}


fun cadastrarQuartos() {

    // =========================
    // VALOR DA DIÁRIA
    // =========================

    println("Informe o valor da diária:")

    var valor = readln().toDoubleOrNull()

    while (valor == null || valor <= 0) {

        println("VALOR INVÁLIDO, informe um valor válido:")

        valor = readln().toDoubleOrNull()
    }


    // =========================
    // NOME DO HÓSPEDE
    // =========================

    println("Informe o nome do hóspede:")

    val nome = readln()


    // =========================
    // QUANTIDADE DE DIÁRIAS
    // =========================

    println("Informe a quantidade de diárias (1-30):")

    var diarias = readln().toIntOrNull()

    while (diarias == null || diarias < 1 || diarias > 30) {

        println("ERRO, informe uma quantidade válida de diárias:")

        diarias = readln().toIntOrNull()
    }


    // =========================
    // TIPO DE QUARTO
    // =========================

    println("Tipo de quarto:")
    println("S - Standard")
    println("E - Executivo")
    println("L - Luxo")

    var tipoDeQuarto = readln().trim().uppercase()

    while (
        tipoDeQuarto != "S" &&
        tipoDeQuarto != "E" &&
        tipoDeQuarto != "L"
    ) {

        println("Opção inválida! Digite S, E ou L:")

        tipoDeQuarto = readln().trim().uppercase()
    }


    val fator = when (tipoDeQuarto) {

        "S" -> 1.00
        "E" -> 1.35
        "L" -> 1.65
        else -> 1.00
    }


    // =========================
    // ESCOLHA DO QUARTO
    // =========================

    println("Escolha um quarto (1-20):")

    var quarto = readln().toIntOrNull()


    // Verifica se o número é válido
    while (quarto == null || quarto < 1 || quarto > 20) {

        println("QUARTO INVÁLIDO! Escolha um número de 1 a 20:")

        quarto = readln().toIntOrNull()
    }



    while (quartosOcupados[quarto!! - 1]) {

        println("Quarto já está ocupado.")

        mostrarQuartosLivres()

        println("Escolha outro quarto (1-20):")

        quarto = readln().toIntOrNull()

        while (quarto == null || quarto < 1 || quarto > 20) {

            println("QUARTO INVÁLIDO! Escolha um número de 1 a 20:")

            quarto = readln().toIntOrNull()
        }
    }


    // =========================
    // CÁLCULOS
    // =========================

    val subtotal = valor * diarias * fator

    val taxaDeServico = subtotal * 0.10

    val total = subtotal + taxaDeServico


    // =========================
    // RESERVA
    // =========================

    val reserva = Reserva(
        nome = nome,
        quarto = quarto,
        tipoDeQuarto = tipoDeQuarto[0],
        diarias = diarias,
        subtotal = subtotal,
        taxaDeServico = taxaDeServico,
        total = total
    )


    // =========================
    // RESUMO
    // =========================

    println()
    println("========== RESUMO DA RESERVA ==========")

    println("Hóspede: $nome")
    println("Quarto: $quarto ($tipoDeQuarto)")
    println("Diárias: $diarias")
    println("Subtotal: R$ %.2f".format(subtotal))
    println("Taxa de serviço (10%%): R$ %.2f".format(taxaDeServico))
    println("Total: R$ %.2f".format(total))

    println("========================================")


    // =========================
    // CONFIRMAÇÃO
    // =========================

    println("$nomeFuncionario confirma a reserva? (S/N)")

    var confirma = readln().trim().uppercase()

    while (confirma != "S" && confirma != "N") {

        println("Opção inválida! Digite S para confirmar ou N para cancelar.")

        confirma = readln().trim().uppercase()
    }




    if (confirma == "S") {

        quartosOcupados[quarto - 1] = true

        historico.add(reserva)

        println()
        println("RESERVA REALIZADA COM SUCESSO!")

        mostrarMapaQuartos()

    } else {

        println()
        println("Reserva não efetuada.")
    }

    inicio()
}