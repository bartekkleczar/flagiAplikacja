package pl.klenczi.flagieuropy

fun filterKolory(listaInput: MutableList<Panstwo>, listaOutput: MutableList<Panstwo>, cze: Int = 2, bi : Int = 2, ni : Int = 2, cza : Int = 2 ){
    for(i in listaInput){
        if((cze== i.cze|| cze == 2)){
            if((bi == i.bi || bi == 2)){
                if((ni== i.ni|| ni== 2)){
                    if((cza == i.cza || cza == 2)){
                        listaOutput.add(i)
                    }
                }
            }
        }
    }
}

fun filterUlozenie(listaInput: MutableList<Panstwo>, listaOutput: MutableList<Panstwo>, u: String = "dowolne"){
    for(i in listaInput){
        if(u == i.u || u == "dowolne"){
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