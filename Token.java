class Token {
    private TipoToken tipo;
    private String valor;

    public Token(TipoToken type, String value) {
        this.tipo = type;
        this.valor = value;
    }

    @Override
    public String toString() {
        return tipo + ": " + valor;
    }
}