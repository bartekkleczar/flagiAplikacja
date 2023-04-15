package pl.klenczi.flagieuropy

fun filterKolory(listaInput: MutableList<Panstwo>, listaOutput: MutableList<Panstwo>, cze : Boolean = false, bi : Boolean = false, ni : Boolean = false, cza : Boolean = false ){
    for(i in listaInput){
        if(cze == i.cze && bi == i.bi && ni == i.ni && cza == i.cza){
            listaOutput.add(i)
        }
    }
}

fun filterUlozenie(listaInput: MutableList<Panstwo>, listaOutput: MutableList<Panstwo>, u: String = "inne"){
    for(i in listaInput){
        if(u == i.u){
            listaOutput.add(i)
        }
    }
}

fun filterZnaczek(listaInput: MutableList<Panstwo>, listaOutput: MutableList<Panstwo>, z: Boolean = false){
    for(i in listaInput){
        if(z == i.z){
            listaOutput.add(i)
        }
    }
}