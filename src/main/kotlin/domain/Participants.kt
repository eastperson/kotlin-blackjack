package domain

class Participants(
    private var players: List<Player>
) {
    fun receiveCard(dealer: Dealer) {
        this.players.forEach { dealer.giveCard(it) }
    }

    fun allPlayers(): List<Player> = this.players.toList()

    companion object {
        fun from(names: List<String>): Participants {
            val players = mutableListOf<Player>()
            names.forEach { name ->
                players.add(Player(name))
            }
            return Participants(players = players.toList())
        }
    }
}