import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
public class Principal{
    public static void main(String[] args){
        Principal.mostrarMenu();
    }

    public static void mostrarMenu(){
        int x;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un número");
        x = scan.nextInt();
        while(true){
            if(x==0){
                break;
            }else if(x==1){
                System.out.println("Ingrese los parámetros del vehiculo. El orden es: Modelo, Marca, Valor y Color");
                int Mod = scan.nextInt();
                String Mar = scan.next();
                double val = scan.nextDouble();
                String Color = scan.next();
                Vehiculo v1 = new Vehiculo(Mod, Mar, val, Color);
            }else if(x==2){
                System.out.println(Vehiculo.toStringVehiculos());
            }else if(x==3){
                System.out.println(Vehiculo.cantidadVehiculos());
            }else if(x==4){
                System.out.println(Vehiculo.ConcatVehiculos());
            }else if(x==5){
                System.out.println("Ingrese la id del vehiculo");
                int id = scan.nextInt();
                if(id<1 || id>Vehiculo.vehiculos.size()){
                    System.out.println("id no válida");
                }else{
                    for(int q = 0; q<Vehiculo.vehiculos.size(); q++){
                        if(Vehiculo.vehiculos.get(q).getId() == id){
                            System.out.println(Vehiculo.vehiculos.get(q).toString());
                        }
                    }
                }
            }else if(x==6){
                System.out.println("ingrese la id del vehiculo");
                int id = scan.nextInt();
                Principal.ObtenerVehiculoPorId(id);
            }else if(x==7){
                System.out.println("Ingrese la id del vehiculo");
                int id = scan.nextInt();
                if(id<1 || id>Vehiculo.vehiculos.size()){
                    System.out.println("id no válida");
                }else{
                    for(int q = 0; q<Vehiculo.vehiculos.size(); q++){
                        if(Vehiculo.vehiculos.get(q).getId() == id){
                            Vehiculo.vehiculos.get(q).getSensores();
                        }
                    }
                }
            }else if(x==8){
                System.out.println(Sensor.ConcatSensores());
            }else if(x==9){

            }else if(x==10){

            }else if(x==666){
                Sensor[] sensorOrdenado = Sensor.ProcesoOrdenar();
                for(int i = 0; i<sensorOrdenado.length; i++){
                    System.out.println(sensorOrdenado[i]);
                }
            }
        }
    }

    public static void ObtenerVehiculoPorId(int idVehiculo){
        Scanner scan = new Scanner(System.in);
        if(idVehiculo<1 || idVehiculo>Vehiculo.vehiculos.size()){
            System.out.println("id no válida");
        }else{
            for(int q = 0; q<Vehiculo.vehiculos.size(); q++){
                if(Vehiculo.vehiculos.get(q).getId() == idVehiculo){
                    System.out.println("Añada los parámetros del sensor, el orden es: Tipo | Valor");
                    String tipo = scan.next();
                    double valor = scan.nextDouble();
                    Sensor s1 = new Sensor(tipo, valor);
                    Vehiculo.vehiculos.get(q).anadirSensor(s1);
                    System.out.println("Su sensor se ha añadido");
                }
            }
        }
    }
}