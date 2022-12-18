package domain


class Card(
    val shape: CardShape,
    val number: CardNumber
)

enum class CardNumber(
    val primaryScore: Int,
    val secondaryScore: Int = primaryScore,
    val nameValue: String
) {
    ACE(1, 11, "A"), TWO(2, nameValue = "2"), THREE(3, nameValue = "3"),
    FOUR(4, nameValue = "4"), FIVE(5, nameValue = "5"), SIX(6, nameValue = "6"),
    SEVEN(7, nameValue = "7"), EIGHT(8, nameValue = "8"), NINE(9, nameValue = "9"),
    TEN(10, nameValue = "10"), JACK(10, nameValue = "J"), QUEEN(10, nameValue = "Q"), KING(10, nameValue = "K")
}

enum class CardShape(
    val nameValue: String
) {
    HEART("하트"), SPADE("스페이드"), CLOVER("클로버"), DIAMOND("다이아몬드")
}