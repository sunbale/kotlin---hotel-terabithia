package Hotel

data class  Orcamento(
    val nomeEmpresa: String,
    val valorPorAparelho: Double,
    val quantidadeAparelhos: Int,
    val desconto : Double,
    val quantidadeMinima: Int,
    val valorFixo: Double,
    val total: Double
)

fun arCondicionado(){
    val orcamentos = mutableListOf<Orcamento>()

println("===AR CONDICIONADO===")
    while (true) {
    println(" Bem vindo a manutenção de ar condicionados! \nPor favor, informe o nome da empresa: ")
    val nomeEmpresa = readln().trim()
        var valorPorAparelho: Double?

        while (true) {

            println("Informe o valor do aparelho:")
            valorPorAparelho = readln().toDoubleOrNull()

            if (valorPorAparelho != null && valorPorAparelho >= 0) {
                break
            }

            println("Valor por aparelho inválido.")
        }

        var quantidadeAparelhos: Int?

        while (true) {

            println("Informe a quantidade de aparelhos:")
            quantidadeAparelhos = readln().toIntOrNull()

            if (quantidadeAparelhos != null && quantidadeAparelhos >= 0) {
                break
            }

            println("Quantidade de aparelhos inválida.")
        }

        var desconto: Double?

        while (true) {

            println("Informe o percentual de desconto:")
            desconto = readln().toDoubleOrNull()

            if (desconto != null && desconto >= 0 && desconto <= 100) {
                break
            }

            println("Valor de desconto inválido.")
        }

        var quantidadeMinima: Int?

        while (true) {

            println("Informe a quantidade mínima para desconto:")
            quantidadeMinima = readln().toIntOrNull()

            if (quantidadeMinima != null && quantidadeMinima >= 0) {
                break
            }

            println("Quantidade mínima inválida.")
        }

        var valorFixo: Double?

        while (true) {

            println("Informe o valor do deslocamento:")
            valorFixo = readln().toDoubleOrNull()

            if (valorFixo != null && valorFixo >= 0) {
                break
            }

            println("Valor de deslocamento inválido.")
        }
        val total = calcularOrcamento(
            valorPorAparelho!!,
            quantidadeAparelhos!!,
            desconto!!,
            quantidadeMinima!!,
            valorFixo!!
        )
println("O serviço da $nomeEmpresa custará R$ %.2f".format(total))
        val novoOrcamento = Orcamento(
            nomeEmpresa = nomeEmpresa,
            valorPorAparelho = valorPorAparelho!!,
            quantidadeAparelhos = quantidadeAparelhos!!,
            desconto = desconto!!,
            quantidadeMinima = quantidadeMinima!!,
            valorFixo = valorFixo!!,
            total = total
        )
    orcamentos.add(novoOrcamento)



        println("Deseja informar novos dados? (S/N)")
        val resposta = readln()

        when (resposta.trim().uppercase()) {
            "S" -> continue

            "N" -> {
                if (orcamentos.size < 2) {
                    println("É necessário informar pelo menos duas empresas.")
                    continue
                }
                val menor = orcamentos.minByOrNull {
                    it.total
                }

                val maior = orcamentos.maxByOrNull {
                    it.total
                }

                if (menor != null && maior != null) {

                    val diferencaPercentual =
                        ((maior.total - menor.total) / menor.total) * 100

                    println()
                    println(
                        "Melhor orçamento: ${menor.nomeEmpresa} — R$ %.2f"
                            .format(menor.total)
                    )

                    println(
                        "Maior orçamento: ${maior.nomeEmpresa} — R$ %.2f"
                            .format(maior.total)
                    )

                    println(
                        "Diferença percentual: %.2f%%"
                            .format(diferencaPercentual)
                    )
                }

                return
            }
            else -> {
                println("Resposta inválida. Digite S ou N.")
            }

        }


        }
    }



fun calcularOrcamento(
    valorPorAparelho: Double,
    quantidadeAparelhos: Int,
    desconto: Double,
    quantidadeMinima: Int,
    valorFixo: Double,
): Double {
    val bruto = valorPorAparelho * quantidadeAparelhos
    val valorDesconto: Double

    if (quantidadeAparelhos >= quantidadeMinima ){
        valorDesconto = bruto * desconto / 100
        println("Desconto aplicado: R$ %.2f".format(valorDesconto))

    }
    else{
        valorDesconto = 0.0
        println("Desconto não aplicado")
    }
    val total = bruto - valorDesconto + valorFixo
    return total
}

