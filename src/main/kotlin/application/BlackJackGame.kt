package application

import domain.Cards
import domain.Dealer
import domain.Participants
import domain.Player

class BlackJackGame(
    private val dealer: Dealer = Dealer(),
    private val players: Participants
) {
    fun init() {
        repeat(INIT_CARD_COUNT) { players.receiveCard(dealer) }
    }

    fun receiveCard(player: Player) {
        dealer.giveCard(player = player)
    }

    fun hands(player: Player): Cards = player.hands
    fun allPlayers(): List<Player> {
        return this.players.allPlayers()
    }

    fun availableReceivePlayer(player: Player): Boolean = player.isAvailableReceive()

    private companion object {
        const val INIT_CARD_COUNT = 2
    }
}
