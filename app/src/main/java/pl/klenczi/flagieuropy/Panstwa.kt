package pl.klenczi.flagieuropy

val albania = Panstwo("Albania", u = "inne", z = true, cze = 1, bi = 0, ni = 0, cza = 1, image = R.drawable.albania)
val andora = Panstwo("Andora", u = "pionowe", z = true, cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.andora)
val armenia = Panstwo("Armenia", u = "poziome", z = false, cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.armenia)
val austria = Panstwo("Austria", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.austria)
val azerbejdzan = Panstwo("Azerbejdzan", u = "poziome", z = true, cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.azerbejdzan)
val anglia = Panstwo("Anglia", u = "krzyz", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.anglia)
val bialorus = Panstwo("Bialorus", u = "poziome", z = true, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.bialorus)
val bosnia = Panstwo("Bosnia", u = "inne", z = true, cze = 0, bi = 1, ni = 1, cza = 0, image = R.drawable.bosnia)
val bulgaria = Panstwo("Bulgaria", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.bulgaria)
val chorwacja = Panstwo("Chorwacja", u = "poziome", z = true, cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.chorwacja)
val czarnogora = Panstwo("Czarnogora", u = "inne", z = true, cze = 1, bi = 0, ni = 0, cza = 0, image = R.drawable.czarnogora)
val czechy = Panstwo("Czechy", u = "poziome", z = false, cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.czechy)
val dania = Panstwo("Dania", u = "krzyz", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.dania)
val estonia = Panstwo("Estonia", u = "poziome", z = false, cze = 0, bi = 1, ni = 1, cza = 1, image = R.drawable.estonia)
val finlandia = Panstwo("Finlandia", u = "krzyz", z = false, cze = 0, bi = 1, ni = 1, cza = 0, image = R.drawable.finlandia)
val francja = Panstwo("Francja", u = "pionowe", z = false, cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.francja)
val grecja = Panstwo("Grecja", u = "poziome", z = false, cze = 0, bi = 1, ni = 1, cza = 0, image = R.drawable.grecja)
val hiszpania = Panstwo("Hiszpania", u = "poziome", z = true, cze = 1, bi = 0, ni = 0, cza = 0, image = R.drawable.hiszpania)
val holandia = Panstwo("Holandia", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.holandia)
val irlandia = Panstwo("Irlandia", u = "pionowe", z = false, cze = 0, bi = 1, ni = 0, cza = 0, image = R.drawable.irlandia)

val niemcy = Panstwo("Niemcy", u = "poziome", z = false, cze = 1, bi = 0, ni = 0, cza = 1, image = R.drawable.niemcy)
val polska = Panstwo("Polska", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.polska)

val panstwa = mutableListOf<Panstwo>(
    albania, andora, armenia, austria, azerbejdzan, anglia, bialorus,
    bosnia, bulgaria, chorwacja, czarnogora, czechy, dania, estonia,
    finlandia, francja, grecja, hiszpania, holandia, irlandia,

    niemcy, polska
)