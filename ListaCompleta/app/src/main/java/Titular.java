public class Titular {
    String titulo;
    String subtitulo;

    public Titular(String tit, String subTit) {

        titulo = tit;
        subtitulo = subTit;

    }

    String getTitulo() {
        return titulo;
    }

    String getSubTitulo() {
        return subtitulo;
    }

    void setTitulo(String tit){
           titulo=tit;
     }

    void setSubTitulo(String subtit){

        subtitulo=subtit;
    }

     public String toString(){
        return titulo + "    " + subtitulo + "\n";
    }
}
