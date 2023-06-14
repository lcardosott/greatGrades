public enum Medias {
    MEDIA_ARITMETICA_SIMPLES(1),
    MEDIA_PONDERADA(2),
    MEDIA_HARMONICA(3),
    MEDIA_GEOMETRICA(4),
    MEDIA_QUADRATICA(5);
    private int value;

    public int getValue() {
        return value;
    }
    private Medias (int value) {
        this.value = value;
    }
}
