public class vidas {
    private int Almirante = 4;

    private int Capitan = 6;

    private int Teniente = 3;

    public int getAlmirante() {
        return Almirante;
    }

    public void setAlmirante(int almirante) {
        this.Almirante = almirante;
    }


    public int getTeniente() {
        return Teniente;
    }

    public void setTeniente(int teniente) {
        this.Teniente = teniente;
    }

    public int getCapitan() {
        return Capitan;
    }

    public void setCapitan(int capitan) {
        Capitan = capitan;
    }

    public int atacarAlmirante(int Almirante){
        Almirante = Almirante-1;
        return Almirante;
    }
    public int atacarCapitan(int Capitan){
        Capitan--;
        return Capitan;
    }
    public int atacarTeniente(int Teniente){
        Teniente--;
        return Teniente;
    }
}
