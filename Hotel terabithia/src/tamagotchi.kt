
class BichinhoVirtual(val nome: String) {
    // Propriedades, Características ou Atributos
    var fome: Int = 10
    var felicidade: Int = 10
    var peso: Double = 10.0
    var altura: Double = 10.5
    var cansaco: Int = 0
    var cor: String = "Exemplo"
    var diversao: Int = 0
    var relaxado: Boolean = false
    var acessorio_cabeca: Boolean = false
    var desc_acessorio_cabeca: String = ""
    var acessorio_costas: Boolean = false
    var desc_acessorio_costas: String = ""
    // Ações, Métodos ou CoisaQuePodeFazer
    fun alimentar() {
        // fome vai diminuir
    }
    fun brincar() {
        // felicidade aumenta
        // cansaco aumenta
        // diversão aumenta
        // fome aumenta
    }
    fun dormir() {
        //se relaxado == true dormir faz cansaco diminuir MUITO
        // caso contrario faz cansac diminuir pouco
    }
    fun banho() {
        // muda relaxado para verdadeiro
    }
    // pelo
    // genero
    // cabelo
    // peruca
    // patas
    // guelras
    // calda
    // asas
}