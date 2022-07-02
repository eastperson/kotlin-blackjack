package blackjack.view.output.converter

import blackjack.domain.BlackjackGameResult
import blackjack.domain.CardNumber
import blackjack.domain.Dealer
import blackjack.domain.Participants
import blackjack.domain.Player
import blackjack.domain.PlayingCard
import blackjack.domain.Suit
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class EndOfGameConverterTest {
    @Test
    fun `EndOfGameConverter는 게임의 결과를 출력을 위한 문자열로 변환해 반환한다`() {
        val dealer = Dealer(
            "딜러",
            PlayingCard(Suit.DIAMONDS, CardNumber.NINE),
            PlayingCard(Suit.HEARTS, CardNumber.QUEEN)
        )
        val player1 = Player(
            "panther",
            10_000,
            PlayingCard(Suit.SPADES, CardNumber.TWO),
            PlayingCard(Suit.HEARTS, CardNumber.ACE),
            PlayingCard(Suit.SPADES, CardNumber.EIGHT)
        )
        val player2 = Player(
            "fox",
            20_000,
            PlayingCard(Suit.DIAMONDS, CardNumber.JACK),
            PlayingCard(Suit.CLUBS, CardNumber.SEVEN),
            PlayingCard(Suit.CLUBS, CardNumber.TEN),
        )
        val participants = Participants(dealer, listOf(player1, player2))
        val blackjackGameResult = BlackjackGameResult.from(participants)

        val cardText =
            "딜러카드: 9다이아몬드, Q하트 - 결과: 19\npanther카드: 2스페이드, A하트, 8스페이드 - 결과: 21\nfox카드: J다이아몬드, 7클로버, 10클로버 - 결과: 27"
        val matchStatusText = "## 최종 수익\n딜러: 10000\npanther: 10000\nfox: -20000"
        val expected = "$cardText\n\n$matchStatusText"
        Assertions.assertThat(EndOfGameConverter.convert(blackjackGameResult)).isEqualTo(expected)
    }
}