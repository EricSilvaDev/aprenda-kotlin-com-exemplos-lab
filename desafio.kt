// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)



enum class Nivel { JUNIOR, PLENO, SENIOR, ESPECIALISTA }

data class Desenvolvedor(val nome: String, val cpf: String, val idade: Int) {
    
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Desenvolvedor>()
    
    fun matricular(desenvolvedor: Desenvolvedor): Unit {
//         TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
		inscritos.add(desenvolvedor)
    }
    
    fun cancelarMatricula(desenvolvedor: Desenvolvedor): Unit {
        inscritos.remove(desenvolvedor)
    }
    
    fun listarInscritos() {
        println("$inscritos")
    }
}

fun main() {
//     TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
//     TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
	
    val dev1 = Desenvolvedor("Eric", "07400319450", 34);
    val dev2 = Desenvolvedor("Ney", "12345678910", 42);
    
    val conteudoEducacional1 = ConteudoEducacional("Lógica de Programação",20)
    val conteudoEducacional2 = ConteudoEducacional("Programando em Kotlin",40)
    val conteudoEducacional3 = ConteudoEducacional("Banco de Dados MySQL",10)
    val conteudoEducacional4 = ConteudoEducacional("Introdução ao Spring Framework",30)
    
    var conteudos = mutableListOf<ConteudoEducacional>(conteudoEducacional1, conteudoEducacional2, conteudoEducacional3, conteudoEducacional4)
    
    val formacao = Formacao("Kotlin Backend para Iniciantes", conteudos, Nivel.JUNIOR)
    
    formacao.matricular(dev1)
    formacao.matricular(dev2)
    
    formacao.listarInscritos()
    
    formacao.cancelarMatricula(dev1)
    formacao.listarInscritos()

    
}