package Hotel

fun relatoriosOperacionais(){

    val totalReservas = historico.size

    var quantidadeOcupados = 0
    println("Total de reservas confirmadas: $totalReservas")
    val taxaOcupacao = (quantidadeOcupados.toDouble( / 20)) * 100
    println("Taxa de ocupação: %.2f%%".format(taxaOcupacao))


    for (ocupado in quartosOcupados) {
        if (ocupado) {
            quantidadeOcupados++
        }
    }
    val totalHospedes = listaHospedes.size
    println("Hóspedes cadastrados: $totalHospedes")
    val totalEventos = agendaEventos.size
    println("Eventos confirmados: $totalEventos")
    var receitaHospedagem = 0.0

    for (reserva in historico) {
        receitaHospedagem += reserva.total
    }
    var receitaEventos = 0.0

    for (evento in agendaEventos) {
        receitaEventos += evento.custoTotal
    }
    val receitaTotal = receitaHospedagem + receitaEventos
    println("==============================================")
    println("           RELATÓRIOS OPERACIONAIS            ")
    println("==============================================")
    println("Reservas confirmadas : $totalReservas")
    println("Quartos ocupados     : $quantidadeOcupados/20")
    println("Taxa de ocupação     : %.2f%%".format(taxaOcupacao))
    println("Hóspedes cadastrados : $totalHospedes")
    println("Eventos confirmados  : $totalEventos")
    println("----------------------------------------------")
    println("Receita hospedagem   : R$ %.2f".format(receitaHospedagem))
    println("Receita eventos      : R$ %.2f".format(receitaEventos))
    println("Receita total        : R$ %.2f".format(receitaTotal))
    println("==============================================")
}