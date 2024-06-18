public class Cuenta {
    private Cliente cliente;
    private int numero;
    private float saldo;

    public Cuenta(Cliente cliente, int numero) {
        this.cliente = cliente;
        this.numero = numero;
        this.saldo = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
