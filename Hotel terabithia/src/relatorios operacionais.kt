package Hotel

fun relatoriosOperacionais(){


        val totalReservas = historico.size

        var quantidadeOcupados = 0

        for (ocupado in quartosOcupados) {
            if (ocupado) {
                quantidadeOcupados++
            }
        }

        val taxaOcupacao = (quantidadeOcupados.toDouble() / 20) * 100

        val totalHospedes = listaHospedes.size


        val totalEventos = agendaEventos.size


        var receitaHospedagem = 0.0

        for (reserva in historico) {
            receitaHospedagem += reserva.total
        }


        var receitaEventos = 0.0

        for (evento in agendaEventos) {
            receitaEventos += evento.custoTotal
        }

        val receitaTotal = receitaHospedagem + receitaEventos

        println()

        println(" ======== RELATÓRIOS OPERACIONAIS ======== ")

        println("Reservas confirmadas : $totalReservas")
        println("Quartos ocupados     : $quantidadeOcupados/20")
        println("Taxa de ocupação     : %.2f%%".format(taxaOcupacao))
        println("Hóspedes cadastrados : $totalHospedes")
        println("Eventos confirmados  : $totalEventos")
        println("----------------------------------------------")
        println("Receita hospedagem   : R$ %.2f".format(receitaHospedagem))
        println("Receita eventos      : R$ %.2f".format(receitaEventos))
        println("Receita total        : R$ %.2f".format(receitaTotal))
        println("==============================================")    }
