// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)





enum class Nivel { JUNIOR, PLENO, SENIOR, ESPECIALISTA }

data class Desenvolvedor(val nome: String, val cpf: String, val idade: Int) 
    
data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: MutableSet<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableSetOf<Desenvolvedor>()
    
    fun matricular(desenvolvedor: Desenvolvedor): Unit {
//         TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
		val contains = inscritos.any { it == desenvolvedor }
        
        if(contains) {
            println("O dev ${desenvolvedor.nome} ja esta matriculado nessa formacao")
        }
        else {
            inscritos.add(desenvolvedor)
            println("Novo dev ${desenvolvedor.nome} matriculado com sucesso!!!")
        }
    }
    
    fun cancelarMatricula(desenvolvedor: Desenvolvedor): Unit {
        val contains = inscritos.any { it == desenvolvedor }
        
        if(contains){
            val nome = desenvolvedor.nome;
            inscritos.remove(desenvolvedor)
            println("A matricula do dev $nome foi cancelada com sucesso")
        }
        
        else{
            println("O dev nao esta matriculado nessa formacao") 
        }
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
    
    
    var conteudos = mutableSetOf<ConteudoEducacional>(conteudoEducacional1, conteudoEducacional2, conteudoEducacional3)
    
    val formacao = Formacao("Kotlin Backend para Iniciantes", conteudos, Nivel.JUNIOR)
    
    formacao.matricular(dev1)
    formacao.matricular(dev2)
    formacao.matricular(dev1)
    
    formacao.listarInscritos()
    
    formacao.cancelarMatricula(dev1)
    formacao.listarInscritos()
	
    val conteudoEducacional4 = ConteudoEducacional("Introdução ao Spring Framework",30)
    formacao.conteudos.add(conteudoEducacional4)
    print(formacao.conteudos)
    
}