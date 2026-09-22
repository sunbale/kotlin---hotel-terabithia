package Hotel

import kotlin.math.ceil
import kotlin.math.floor

data class Evento (
    val convidados: Int,
    val auditorio: String,
    val cadeirasExtras: Int,
    val dia: String,
    val horaInicial: Int,
    val duracao: Int,
    val horaFinal: Int,
    val empresa: String,
    val quantidadeGarcons: Int,
    val custoDeGarcons: Double,
    val custoBuffet: Double,
    val custoTotal: Double

)
data class ResultadoAuditorio(
    val nome: String,
    val cadeirasExtras: Int
)
val agendaEventos = mutableListOf<Evento>()

fun eventos() {

    println("=== EVENTOS ===")


    // PARTE A
    println("Informe o número de convidados:")
    val convidados = readln().toIntOrNull()

    if (convidados == null || convidados < 0 || convidados > 350) {
        println("Número de convidados inválido")
        return
    }

    val resultadoAuditorio = escolherAuditorio(convidados)

    val auditorio = resultadoAuditorio.nome
    val cadeirasExtras = resultadoAuditorio.cadeirasExtras


    println("Auditório selecionado: $auditorio")
    println("Cadeiras adicionais: $cadeirasExtras")


    // PARTE B
    println("Informe o dia da semana:")
    val dia = readln().trim().lowercase()

    println("Informe a hora inicial:")
    val horaInicial = readln().toIntOrNull()

    if (horaInicial == null) {
        println("Horário inválido")
        return
    }

    println("Informe a duração do evento em horas:")
    val duracao = readln().toIntOrNull()

    if (duracao == null) {
        println("Duração inválida")
        return
    }

    val horaFinal = horaInicial + duracao

    val disponivel = verificarDisponibilidade(
        dia,
        horaInicial,
        duracao
    )

    if (disponivel) {
        val conflito = verificarConflito(
            auditorio,
            dia,
            horaInicial,
            horaFinal
        )

        if (conflito) {
            println("O auditório já está ocupado nesse horário.")
            return
        }


        println("Auditório disponível")

        println("Informe o nome da empresa:")
        val empresa = readln()

        println(
            "Auditório reservado para $empresa: " +
                    "$dia às ${horaInicial}hs"
        )

        val quantidadeGarcons = calcularGarcons(
            convidados,
            duracao
        )

        val custoGarcons = calcularCustoGarcons(
            quantidadeGarcons,
            duracao
        )


        println("Quantidade de garçons: $quantidadeGarcons")
        println("Custo dos garçons: R$ %.2f".format(custoGarcons))
        val custoBuffet = buffet(convidados)
        val custoTotal = custoGarcons + custoBuffet
        relatorio(
            empresa,
            auditorio,
            cadeirasExtras,
            dia,
            horaInicial,
            horaFinal,
            convidados,
            duracao,
            quantidadeGarcons,
            custoGarcons,
            custoBuffet,
            custoTotal
        )
        val confirmado = confirmarReserva()
        if (confirmado) {

            val novoEvento = Evento(
                convidados = convidados,
                auditorio = auditorio,
                cadeirasExtras = cadeirasExtras,
                dia = dia,
                horaInicial = horaInicial,
                duracao = duracao,
                horaFinal = horaFinal,
                empresa = empresa,
                quantidadeGarcons = quantidadeGarcons,
                custoDeGarcons = custoGarcons,
                custoBuffet = custoBuffet,
                custoTotal = custoTotal
            )

            agendaEventos.add(novoEvento)
            println("Evento salvo na agenda!")
        }

    } else {

        println("Auditório indisponível")
    }


}
fun escolherAuditorio(convidados: Int): ResultadoAuditorio {

    if (convidados <= 150) {
        return ResultadoAuditorio(
            nome = "Laranja",
            cadeirasExtras = 0
        )
    }

    if (convidados <= 220) {
        return ResultadoAuditorio(
            nome = "Laranja",
            cadeirasExtras = convidados - 150
        )
    }

    return ResultadoAuditorio(
        nome = "Colorado",
        cadeirasExtras = 0
    )
}

fun verificarDisponibilidade(
    dia: String,
    horaInicial: Int,
    duracao: Int
): Boolean {

    if (duracao < 1 || duracao > 12) {
        return false
    }

    val horaFinal = horaInicial + duracao

    if (
        dia == "segunda" ||
        dia == "terca" ||
        dia == "quarta" ||
        dia == "quinta" ||
        dia == "sexta"
    ) {

        return horaInicial >= 7 && horaFinal <= 23

    } else if (
        dia == "sabado" ||
        dia == "domingo"
    ) {

        return horaInicial >= 7 && horaFinal <= 15
    }

    return false
}



     fun calcularGarcons (convidados: Int, duracao: Int): Int{

         val garcomBase = ceil(convidados / 12.0).toInt()

         val garconsExtra = floor(duracao / 2.0).toInt()

         val totalGarcons = garcomBase + garconsExtra

         return totalGarcons

//Base: `ceil(convidados / 12)`
//- Reforço por duração: `floor(duração / 2)`
//- Total garçons = base + reforço
//- Custo garçom/hora = R$ 10,50
     //Cálculo:
     //- `custo_garcons = total_garcons × duração × 10,50`
 }
fun calcularCustoGarcons(
    quantidadeGarcons: Int,
    duracao: Int
): Double {

    return quantidadeGarcons * duracao * 10.50

}

fun buffet (convidados: Int): Double{
    println("===BUFFET===")
   val cafe = convidados * 0.2
    val agua = convidados * 0.5
    val salgados = convidados *  7
    val custoCafe = cafe * 0.80
    val custoAgua = agua * 0.40
    val custoSalgados = (salgados / 100.0) * 34.0
    val custoTotal = custoCafe + custoAgua + custoSalgados
    println("Café %.2f litros".format(cafe))
    println("Água %.2f litros".format(agua))
    println("Salgados: $salgados unidades")
    println("Custo do café R$ %.2f".format(custoCafe))
    println("Custo da água R$ %.2f".format(custoAgua))
    println("Custo dos salgados R$ %.2f".format(custoSalgados))

    println("Custo total do Buffet R$ %.2f".format(custoTotal))

    return custoTotal
}
fun relatorio(
    empresa: String,
    auditorio: String,
    cadeirasExtras: Int,
    dia: String,
    horaInicial: Int,
    horaFinal: Int,
    convidados: Int,
    duracao: Int,
    quantidadeGarcons: Int,
    custoGarcons: Double,
    custoBuffet: Double,
    custoTotal: Double
) {
    println("===RELATORIO==")

    println("Empresa: $empresa")
    println("Auditório: $auditorio")
    println("Cadeiras adicionais: $cadeirasExtras")
    println("Dia: $dia")
    println("Horário inicial: ${horaInicial}hs")
    println("Horário final: ${horaFinal}hs")
    println("Quantidade de convidados: $convidados")
    println("Duração: $duracao horas")
    println("Quantidade de garçons: $quantidadeGarcons")

    println("Custo dos garçons: R$ %.2f".format(custoGarcons))
    println("Custo do buffet: R$ %.2f".format(custoBuffet))
    println("Custo total: R$ %.2f".format(custoTotal))

}
fun verificarConflito(
    auditorio: String,
    dia: String,
    horaInicial: Int,
    horaFinal: Int
): Boolean {
    for (evento in agendaEventos) {

        if (
            evento.auditorio == auditorio &&
            evento.dia == dia
        ) {

            if (
                evento.horaInicial < horaFinal &&
                evento.horaFinal > horaInicial
            ) {
                return true
            }
        }
    }
 return false
}


fun confirmarReserva(): Boolean {

    while (true) {

        println("Confirmar reserva? (S/N)")

        val resposta = readln()

        when (resposta.trim().uppercase()) {

            "S" -> {
                println("Reserva efetuada com sucesso.")
                return true
            }

            "N" -> {
                println("Reserva não efetuada.")
                return false
            }

            else -> {
                println("Resposta inválida. Digite S ou N.")
            }
        }
    }
}

//Confirmar reserva? (S/N): S
//Reserva efetuada com sucesso.