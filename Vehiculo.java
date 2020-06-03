import java.util.ArrayList;
public class Vehiculo
{
    public static ArrayList <Vehiculo> vehiculos = new ArrayList <Vehiculo>();
    public static int idActual = 1;
    private ArrayList <Sensor> sensores = new ArrayList <Sensor>();
    private int id;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    public Vehiculo(){
        vehiculos.add(this);
        this.id = Vehiculo.idActual;
        Vehiculo.idActual = Vehiculo.idActual++;
    }

    public Vehiculo(int mo, String ma, double va){
        this(mo, ma, va, "verde");
    }

    public Vehiculo(int mo, String ma, double va, String co){
        this.modelo=mo;
        this.marca=ma;
        this.valorComercial=va;
        this.color=co;
        vehiculos.add(this);
        this.id = Vehiculo.idActual;
        Vehiculo.idActual = Vehiculo.idActual++;
    }

    public int getModelo(){
        return this.modelo;
    }

    public int getId(){
        return this.id;
    }

    public String getMarca(){
        return this.marca;
    }

    public double getValor(){
        return this.valorComercial;
    }

    public String getColor(){
        return this.color;
    }

    public ArrayList<Sensor> getSensores(){
        return this.sensores;
    }

    public void setSensores(ArrayList<Sensor> arraySensores){
        this.sensores = arraySensores;
    }

    public void setModelo(int n){
        this.modelo = n;
    }

    public void setMarca(String n){
        this.marca = n;
    }

    public void setValor(double n){
        this.valorComercial = n;
    }

    public void setColor(String n){
        this.color = n;
    }

    public String toString(){
        String sensorConcat = "";
        String sensorStr = "";
        for(int i = 0; i<sensores.size(); i++){
            sensorStr =("Sensor: "+i+". "+this.sensores.get(i).toString());
            sensorConcat = (sensorConcat+sensorStr);
        }
        String info = ("Modelo: "+this.modelo+", Marca: "
                +this.marca+", Valor comercial: "+this.valorComercial+
                ", Color: "  +this.color+ sensorConcat);
        return info;
    }

    public static String toStringVehiculos(){
        String concat ="";
        for(int i = 0; i<vehiculos.size(); i++){
            String informVehiculo=(Vehiculo.vehiculos.get(i).toString());
            concat = (concat+informVehiculo+" ");
        }
        return concat;
    }

    public static int cantidadVehiculos(){
        return Vehiculo.vehiculos.size();
    }

    public int cantidadSensores(){
        return this.sensores.size();
    }

    public void anadirSensor(Sensor s){
        this.sensores.add(s);
    }

    public static String ConcatVehiculos(){
        String concatVehiculos = "";
        for(int j = 0; j<vehiculos.size(); j++){
            if(vehiculos.get(j).getColor().equals("verde")){
                concatVehiculos=(concatVehiculos+vehiculos.get(j).toString()+" ");
            }
        }
        return concatVehiculos;
    }
}
