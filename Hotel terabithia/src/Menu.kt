
package Hotel
data class Reserva(
    val nome: String,
    val quarto: Int,
    val tipoDeQuarto: Char,
    val diarias: Int,
    val subtotal: Double,
    val taxaDeServico: Double,
    val total: Double
)
val quartosOcupados = BooleanArray(20)
val historico = mutableListOf<Reserva>()
var nomeFuncionario = ""
val nomeHotel: String = "Terabithia"
fun main() {


    print("Bem vindo ao Hotel $nomeHotel!\n")
    println("Informe o seu nome: ")
    nomeFuncionario = readln()
    val senhaCorreta = 2678
    var tentativas = 0
    var senha = 0
    while(tentativas < 3) {

        println("informe a senha:")
        senha = readln().toInt()

        if (senha == senhaCorreta) {
            println("senha correta! Acesso permitido")
            break
        } else {
            tentativas++
            println("Senha Incorreta!")
            if (tentativas < 3){
                println("você ainda tem ${3 - tentativas} tentativa(S)")
            }
        }
    }
    if (tentativas == 3 && senha != senhaCorreta){
        println("SISTEMA BLOQUEADO")
        return
    }
    // Função principal que chama a função inicio().
    inicio()
}

fun inicio() {

    println("Bem vindo $nomeFuncionario ao Hotel $nomeHotel! \n É um imenso prazer ter você por aqui!")
    println("Escolha uma opção:")
    println("1 - Reservas de quarto")
    println("2 - Cadastrar hospedes")
    println("3 - Eventos")
    println("4 - ar condicionado")
    println("5 - Abastecimento de automoveis")
    println("6 - Relatórios operacionais")
    println ("7 - Sair do hotel")
    // A varival escolha armazena a opção escolhida pelo usuário.
    // uma variavel local é utilizada apenas dentro da função inicio().
   //1. Reservas de Quartos
    //2. Cadastro de Hóspedes
    //3. Eventos
    //4. Ar-Condicionado
    //5. Abastecimento
    //6. Relatórios Operacionais
    //7. Sair

    val escolha = readln().toIntOrNull()
    when (escolha) {

        1 -> cadastrarQuartos()
        2 -> cadastrarHospedes()
        3 -> eventos()
        4 -> arCondicionado()
        5 -> AbastecimentoDeAutomoveis()
        6 -> relatoriosOperacionais()
        7 -> sairDoHotel()
        else -> erro()
    }
}



fun erro(){
    println("Por favor, informe um número entre 1 a 7.")
    inicio()
}

fun sairDoHotel() {
    println("Você deseja sair?")
    println("Digite sim ou não:")
    val confirma = readln().trim().lowercase()

    if (confirma == "sim") {
        println("Muito obrigado e até logo $nomeFuncionario!")
    } else {
        inicio()
    }
}