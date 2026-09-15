package Hotel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
val formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
data class Hospede(
    var nome: String,
    val dataCadastro: LocalDateTime

)
val listaHospedes = mutableListOf(
    Hospede("Carlos Villagran", LocalDateTime.now()),
    Hospede("Maria Antonieta de las Nieves", LocalDateTime.now()),
    Hospede("Roberto Gómez Bolaños", LocalDateTime.now()),
    Hospede("Florinda Meza", LocalDateTime.now()),
    Hospede("Ramón Valdés", LocalDateTime.now()),
    Hospede("Rubén Aguirre", LocalDateTime.now()),
    Hospede("Angelines Fernández", LocalDateTime.now()),
    Hospede("Edgar Vivar", LocalDateTime.now()),
    Hospede("Horácio Gómez Bolaños", LocalDateTime.now()),
    Hospede("Raúl Padilla", LocalDateTime.now())
)

fun cadastrarHospedes() {


    while (true) {
        println("""Cadastro de Hóspedes
            Selecione uma opção:
            1. Cadastrar
            2. Pesquisar por nome exato
            3. Pesquisar por prefixo
            4. Listar ordenado (A-Z)
            5. Atualizar cadastro
            6. Remover cadastro
            7. Voltar""".trimIndent())

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarHospede(listaHospedes)
            2 -> pesquisarHospede(listaHospedes)
            3 -> pesquisarHospedePrefixo(listaHospedes)
            4 -> listarHospedesOrdenado(listaHospedes)
            5 -> atualizarCadastro(listaHospedes)
            6 -> removerCadastro(listaHospedes)
            7 -> {
                if (sairCadastroDeHospedes()) {
                    return
                }
            }
            else -> erroCadastroDeHospedes()
        }
    }
}

fun cadastrarHospede(listaHospedes: MutableList<Hospede>) {
    if (listaHospedes.size >= 15){
        println ("Máximo de cadastros atingido!")
        return

    }
    println("Cadastro de Hóspedes.\nPor favor, informe o nome da Hóspede:")
    val novoHospede = readln()
    val dataCadastro = LocalDateTime.now()

    if (novoHospede.isBlank()) {
        println("Nome inválido. O nome não pode ficar vazio.")
        return
    }
    val jaExiste = listaHospedes.any {
        it.nome.equals(novoHospede, ignoreCase = true)
    }
    if (jaExiste) {
        println("Hóspede já cadastrado")
        return
    }
    listaHospedes.add(
        Hospede(novoHospede, dataCadastro)
    )
    println("$novoHospede cadastrado com sucesso!")
    listarHospedesOrdenado(listaHospedes)

    // Não é necessário chamar a função cadastrarHospedes(), pois o loop while já está chamando.
}

fun pesquisarHospede(listaHospedes: MutableList<Hospede>) {
    println("Pesquisa de Hóspedes.")
    println("Por favor, informe o nome do Hóspede:")
    val nomeHospede = readln()
    if (nomeHospede.isBlank()) {
        println("Nome inválido. O nome não pode ficar vazio.")
        return
    }
    val resultado = listaHospedes.filter {
        it.nome.equals(nomeHospede, ignoreCase = true)
    }
if (resultado.isEmpty()) {
    println("Hóspede não encontrado")
} else {
    println("Hóspede encontrado")
    resultado.forEach {
        println("${it.nome} - ${it.dataCadastro.format(formato)}")
    }
}

}
fun pesquisarHospedePrefixo(listaHospedes: MutableList<Hospede>) {
    println("===PESQUISA POR PREFIXO===")
    println("Digite o ínicio do nome: ")
    val prefixo = readln()
    if (prefixo.isBlank()) {
        println("Prefixo inválido. Digite pelo menos uma letra.")
        return
    }
    val resultado = listaHospedes.filter { it.nome.startsWith(prefixo, ignoreCase = true) }
    if (resultado.isEmpty()) {
        println("Hospede não encontrado")
    } else {
        resultado.forEach {
            println("${it.nome} - ${it.dataCadastro.format(formato)}")
        }
    }
}
fun listarHospedesOrdenado (listaHospedes: MutableList<Hospede>){
    listaHospedes.sortBy {
        it.nome.lowercase()}
    println("===LISTA DE HÓSPEDES===")

    listaHospedes.forEachIndexed { indice, hospede ->
        println("[${indice + 1}] - ${hospede.nome} - ${hospede.dataCadastro.format(formato)}")

}


}

fun atualizarCadastro(listaHospedes: MutableList<Hospede>) {
listarHospedesOrdenado(listaHospedes)
    println("Digite o número do hóspede que deseja atualizar")
    val escolha = readln().toIntOrNull()

    if (escolha == null || escolha < 1 || escolha > listaHospedes.size){
        println("Hospede não encontrado")
        return
    }
    val indice = escolha - 1
    println("Digite o novo nome do hóspede:")
    val novoNome = readln()
    if (novoNome.isBlank()){
        println("Nome inválido. O nome não pode ficar vazio")
        return
    }
    val jaExiste = listaHospedes.withIndex().any {
        it.index != indice &&
                it.value.nome.equals(novoNome, ignoreCase = true)
    }
    if (jaExiste) {
        println("Este nome já consta na lista, operação cancelada.")
        return
    }
    listaHospedes[indice].nome = novoNome
    println("operação realizada com sucesso!")
}

fun removerCadastro(listaHospedes: MutableList<Hospede>) {
    listarHospedesOrdenado(listaHospedes)
    println("digite o número do hóspede que deseja remover: ")
    val nomeRemover = readln().toIntOrNull()
    if (nomeRemover == null || nomeRemover < 1 || nomeRemover > listaHospedes.size){
        println("Hospede não encontrado")
        return
    }
    val indice = nomeRemover - 1
    listaHospedes.removeAt(indice)
    println("operação realizada com sucesso")
    println("Lista atualizada de hóspedes:")
    listarHospedesOrdenado(listaHospedes)

}

fun sairCadastroDeHospedes(): Boolean {
    println("Você deseja sair? S/N")


    while (true) {
        val escolha = readln()
         when (escolha.trim().uppercase()) {
                "S" -> return true
                "N" -> return false
                else -> println("Resposta inválida! Digite 'S' ou 'N'")

         }

    }

}


fun erroCadastroDeHospedes() {

    println("Por favor, informe um número de 1 a 7.")
}

