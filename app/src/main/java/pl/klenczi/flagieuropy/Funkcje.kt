package pl.klenczi.flagieuropy

fun filterKolory(listaInput: MutableList<Panstwo>, listaOutput: MutableList<Panstwo>, cze : Boolean = false, bi : Boolean = false, ni : Boolean = false, cza : Boolean = false ){
    for(i in listaInput){
        if(cze == i.cze && bi == i.bi && ni == i.ni && cza == i.cza){
            listaOutput.add(i)
        }
    }
}

fun fiterUlozenie(listaInput: MutableList<Panstwo>, listaOutput: MutableList<Panstwo>, u: String = "inne"){
    for(i in listaInput){
        if(u == i.u || u == "inne"){
            listaOutput.add(i)
        }
    }
}