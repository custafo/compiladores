package src;

class Token {
    private TipoToken tipo;
    private String valor;

    public Token(TipoToken tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return tipo + ": " + valor;
    }
}