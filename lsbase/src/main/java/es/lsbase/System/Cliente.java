package System;

public class Cliente {
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String Telefono1;
    private String Telefono2;
    private String DNI;
    private String CorreoElectronico;
    private String DireccionSuministro;
    private String Patio;
    private String Puerta;
    private String DireccionCorrespondencia;
    private int CodigoPostal;
    private String Poblacion;
    private String Provincia;
    private String CUPS;
    private String NumeroCuenta;
    private String Anexo;
    private String Tarifa;
    private String Consumo;
    private String Compania;
    private String Comision;
    private String Activacion;
    private String PersonaAut;
    private String DNIAut;
    private String TelefonoAut;
    private String Anotacion;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public String getTelefono1() {
        return Telefono1;
    }

    public void setTelefono1(String telefono1) {
        Telefono1 = telefono1;
    }

    public String getTelefono2() {
        return Telefono2;
    }

    public void setTelefono2(String telefono2) {
        Telefono2 = telefono2;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }

    public String getDireccionSuministro() {
        return DireccionSuministro;
    }

    public void setDireccionSuministro(String direccionSuministro) {
        DireccionSuministro = direccionSuministro;
    }

    public String getPatio() {
        return Patio;
    }

    public void setPatio(String patio) {
        Patio = patio;
    }

    public String getPuerta() {
        return Puerta;
    }

    public void setPuerta(String puerta) {
        Puerta = puerta;
    }

    public String getDireccionCorrespondencia() {
        return DireccionCorrespondencia;
    }

    public void setDireccionCorrespondencia(String direccionCorrespondencia) {
        DireccionCorrespondencia = direccionCorrespondencia;
    }

    public int getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        CodigoPostal = codigoPostal;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(String poblacion) {
        Poblacion = poblacion;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }

    public String getCUPS() {
        return CUPS;
    }

    public void setCUPS(String cUPS) {
        CUPS = cUPS;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        NumeroCuenta = numeroCuenta;
    }

    public String getAnexo() {
        return Anexo;
    }

    public void setAnexo(String anexo) {
        Anexo = anexo;
    }

    public String getTarifa() {
        return Tarifa;
    }

    public void setTarifa(String tarifa) {
        Tarifa = tarifa;
    }

    public String getConsumo() {
        return Consumo;
    }

    public void setConsumo(String consumo) {
        Consumo = consumo;
    }

    public String getCompania() {
        return Compania;
    }

    public void setCompania(String compania) {
        Compania = compania;
    }

    public String getComision() {
        return Comision;
    }

    public void setComision(String comision) {
        Comision = comision;
    }

    public String getActivacion() {
        return Activacion;
    }

    public void setActivacion(String activacion) {
        Activacion = activacion;
    }

    public String getPersonaAut() {
        return PersonaAut;
    }

    public void setPersonaAut(String personaAut) {
        PersonaAut = personaAut;
    }

    public String getDNIAut() {
        return DNIAut;
    }

    public void setDNIAut(String dNIAut) {
        DNIAut = dNIAut;
    }

    public String getTelefonoAut() {
        return TelefonoAut;
    }

    public void setTelefonoAut(String telefonoAut) {
        TelefonoAut = telefonoAut;
    }

    public String getAnotacion() {
        return Anotacion;
    }

    public void setAnotacion(String anotacion) {
        Anotacion = anotacion;
    }

    public Cliente(String Nombre, String Apellido1, String Apellido2, String Telefono1, String Telefono2,
                   String DNI, String CorreoElectronico, String DireccionSuministro, String Patio, String Puerta,
                   String DireccionCorrespondencia, int CodigoPostal, String Poblacion, String Provincia, String CUPS,
                   String NumeroCuenta, String Anexo, String Tarifa, String Consumo, String Compania, String Comision,
                   String Activacion, String PersonaAut, String DNIAut, String TelefonoAut, String Anotacion) {
        this.Nombre = Nombre;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.Telefono1 = Telefono1;
        this.Telefono2 = Telefono2;
        this.DNI = DNI;
        this.CorreoElectronico = CorreoElectronico;
        this.DireccionSuministro = DireccionSuministro;
        this.Patio = Patio;
        this.Puerta = Puerta;
        this.DireccionCorrespondencia = DireccionCorrespondencia;
        this.CodigoPostal = CodigoPostal;
        this.Poblacion = Poblacion;
        this.Provincia = Provincia;
        this.CUPS = CUPS;
        this.NumeroCuenta = NumeroCuenta;
        this.Anexo = Anexo;
        this.Tarifa = Tarifa;
        this.Consumo = Consumo;
        this.Compania = Compania;
        this.Comision = Comision;
        this.Activacion = Activacion;
        this.PersonaAut = PersonaAut;
        this.DNIAut = DNIAut;
        this.TelefonoAut = TelefonoAut;
        this.Anotacion = Anotacion;
    }
    
    public Cliente(){}
}
