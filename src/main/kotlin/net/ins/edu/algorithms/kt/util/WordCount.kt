package net.ins.edu.algorithms.kt.util

import java.util.Comparator

class WordCount(private val text: String) {

    fun wordsByCount() = text
        .split(" ")
        .groupingBy { it }
        .eachCount()
}

fun main() {
    val wordsByCount = WordCount(
        """
        There's a widespread opinion that only people who earn a lot of money are successful. This statement is controversial and open for debate. 
        On the one hand, we all head about people who became rich not because they worked hard, but rather by accident. For instance, those who inherited their fortune, or young people who live on their parent’s money, or even those who won a lottery. The problem is that if you have everything and it costs you nothing, then you risk to become a nihilist who's not able to enjoy small pleasures of life anymore. Often, these people have no idea what it takes to earn money, and not knowing it's value become spoiled, unreasonable spenders. Moreover, in rare cases such people go breaking bad, and end their lives miserably. Could it be recognized as "success"? Probably, it couldn't.
        One the other hand, wealth might be a result of one's hard work. Businessmen, startupers, highly qualified specialists, most of them earn a lot of money, and their high wage is exactly an appraisal of their achievements and a measure of their success. Usually, such persons truly understand the value of their money and know how to use them to make their lives happier. And sometimes not only their own lives. Some of them donate to charity, some invest into science and promising technologies that could make and makes other's lives better. 
        But, what does success even mean? Undoubtedly, to many, success can be measured in money, but not to everyone. For some, success is much more than just material assets, and relates to happiness and health of their families. For some, it is in ability to live in harmony with themselves and surrounding world. For others success is their life, rich in adventures and new connections they established during their lifetime. 
        So, the question about money and success is not unambiguous, and the answer depends on personal values and perception. To my mind, most successful people do earn a lot of money, but not every prosperous man could be recognized successful.
    """
    ).wordsByCount()

    println(wordsByCount)
}