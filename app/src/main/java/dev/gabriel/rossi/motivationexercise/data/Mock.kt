package dev.gabriel.rossi.motivationexercise.data

import dev.gabriel.rossi.motivationexercise.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val all = MotivationConstants.FILTER.ALL //1
    private val happy = MotivationConstants.FILTER.HAPPY //2
    private val sunny = MotivationConstants.FILTER.SUNNY //3

    private val mListPhrase = listOf(

        //happy
        Phrase("Ser feliz não é viver apenas momentos de alegria. É ter coragem de enfrentar a tristeza e sabedoria para transformar os problemas em aprendizado.", happy),
        Phrase("Felicidade não é ausência de conflito, mas habilidade em lidar com ele. Alguém feliz não tem o melhor de tudo, mas torna tudo melhor.", happy),
        Phrase("A felicidade é como uma borboleta: quanto mais você corre atrás dela, mais ela foge. Um dia você se distrai e ela pousa em seu ombro.", happy),
        Phrase("Não é no fim da estrada que você encontrará a felicidade, mas em cada parada pelo caminho.", happy),
        Phrase("Não importa o que você decidiu, o que importa é que isso te faça feliz.", happy),

        //sunny
        Phrase("Bom dia! Você tem toda a capacidade de ser tão incrível quanto as pessoas que lhe inspiram. Acredite em você!", sunny),
        Phrase("Nunca é tarde demais para conquistarmos um grande sonho.", sunny),
        Phrase("Não será o sol que tornará este dia perfeito, mas sim sua disposição e vontade de ser feliz.", sunny),
        Phrase("Não seja vítima das dificuldades, tente ultrapassá-las!", sunny),
        Phrase("Erros são as provas de que estamos tentando.", sunny)
    )

    fun getPhrase(value: Int): String {
        val filtered = mListPhrase.filter { it.categoryId == value || value == all }
        return filtered[Random.nextInt(filtered.size)].description
    }
}