package Hotel
data class Local (
    val convidados: Int,
    val auditório: String,
    var cadeirasExtras: Int,
    val lugares: Int,
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
val agendaEventos = mutableListOf<Local>()
var duracao = readln().toInt()
fun eventos(){

    println("===AUDITÓRIO DE EVENTOS===")
    println("Informe o número de convidados?")
    val convidados = readln().toIntOrNull()
    println("ESCOLHA UM AUDITÓRIO")
    println("1 . AUDITÓRIO LARANJA")
    println("2. AUDITÓRIO COLORADO")
}

fun reserva(){
    println("===AGENDA==")
println("Informe o dia da semana:")
    val diaDaSemana = readln()
    println("Informe o horário:")
    var horario = readln()
    println("Informe a duração:")
    duracao = readln().toInt()
    println("Confirmar agenda?")
    val confirmacao = readln().toCharArray()
    println("Informe o nome da empresa")
    println("Confirma agenda?")
    val verificacao = readln()

    println("Auditório reservado para (nome da empresa): (dia da semana) às (horas)hs")
}
 fun equipeDeGarcom (){
     println("Informe o nome da empresa:")
     var nomeEmpresa = readln()
     var base = 0
     var reforco = 0
     var totalGarcom = (base + reforco)
     val horaGarcom = 10.50
     var calculoCustoGarcom = (totalGarcom * duracao * horaGarcom)


//Base: `ceil(convidados / 12)`
//- Reforço por duração: `floor(duração / 2)`
//- Total garçons = base + reforço
//- Custo garçom/hora = R$ 10,50
     //Cálculo:
     //- `custo_garcons = total_garcons × duração × 10,50`
 }
fun buffet (){
    println("===BUFFET===")
   val cafe = 0.80
    val agua = 0.40
    val salgado = 34.0
}
fun relatorio () {
    println("===RELATORIO==")
    //Exibir relatório técnico:
    //
    //- auditório, empresa, data, hora início/fim
    //- convidados, garçons, duração
    //- custo garçons, custo buffet, total geral
}

// Exemplo de execução formatado
//[Eventos]
//Convidados: 192
//Auditório selecionado: Laranja (42 cadeiras adicionais)
//
//Dia: segunda
//Hora inicial: 13
//Duração: 8
//Empresa: Lojas Transilvânia
//Status: Auditório reservado.
//
//Garçons necessários: 20
//Custo com garçons: R$ 1.680,00
//
//Buffet:
//Café: 38,4 L
//Água: 96,0 L
//Salgados: 1344 un
//Custo buffet: R$ 540,96
//
//Total do evento: R$ 2.220,96
fun confirmarReserva(){
    println("Confirmar reserva?")
    val resposta = readln()
    when (resposta.trim().uppercase()) {
        "S" -> ("RESERVA EFETUADA COM SUCESSO")
        "N" -> return
    }
}
//Confirmar reserva? (S/N): S
//Reserva efetuada com sucesso.