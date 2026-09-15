package Hotel

fun confirmouSaidaDoCadastro(resposta: String): Boolean? {
    return when (resposta.trim().uppercase()) {
        "S" -> true
        "N" -> false
        else -> null
    }
}
