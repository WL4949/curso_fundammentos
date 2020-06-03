import java.util.ArrayList;
public class Sensor{
    public static ArrayList<Sensor> sensores = new ArrayList <Sensor>();
    private String tipo;
    private double valor;
    public Sensor(){
        Sensor.sensores.add(this);
    }
    
    public Sensor(String t, double v){
        this.tipo=t;
        this.valor=v;
        Sensor.sensores.add(this);
    }
    
    public String toString(){
        String concat = ("Tipo de sensor: "+this.tipo+" , Valor del sensor: "+this.valor);
        return concat;
    }
    
    public static int cantidadSensores(){
        return Sensor.sensores.size();
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public double getValor(){
        return this.valor;
    }
    
    public void setTipo(String n){
        this.tipo = n;
    }
    
    public void setValor(double n){
        this.valor = n;
    }
    
    public static String ConcatSensores(){
      String concatSensores = "";
      for(int j = 0; j<sensores.size(); j++){
          if(sensores.get(j).getTipo().equals("temperatura")){
              concatSensores=(concatSensores+sensores.get(j).toString()+". ");
            }
        }
      return concatSensores;
    }
    
    public static Sensor[] ProcesoOrdenar(){
        int t = 0;
        for( int i = 0; i < Sensor.sensores.size(); i++){
            if (Sensor.sensores.get(i).getTipo().equals("temperatura")){
                t++;
            }
        }
        Sensor[] sensoresTemp=new Sensor[t];
        int l=0;
        for (int q = 0; q < Sensor.sensores.size(); q++){
            if (Sensor.sensores.get(q).getTipo().equals("temperatura")){
                sensoresTemp[l]=Sensor.sensores.get(q);
                l++;
            }
        }
        int n=sensoresTemp.length;
        int posMenor;
        Sensor temp;
        for (int s = 0; s < n-1; s++){
            posMenor=s;
            for (int j = s+1; j < n; j++){
                if (sensoresTemp[j].getValor()< sensoresTemp[posMenor].getValor())
                {
                    posMenor=j;
                }
            }
            temp = sensoresTemp[s];
            sensoresTemp[s]=sensoresTemp[posMenor];
            sensoresTemp[posMenor]= temp;
        }
        return sensoresTemp; 
    }
}