import java.io.*;

public class DealershipFileManager {
    private static String File_PATH = "dealership.txt";

    public Dealership getDealership() {
        Dealership dealership = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(File_PATH))) {
            String name = reader.readLine();
            String address = reader.readLine();
            String phone = reader.readLine();
            dealership = new Dealership(name, address, phone);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] vehicleData = line.split("\\|");
                int vin = Integer.parseInt(vehicleData[0]);
                int year = Integer.parseInt(vehicleData[1]);
                String make = vehicleData[2];
                String model = vehicleData[3];
                String vehicleType = vehicleData[4];
                String color = vehicleData[5];
                int odometer = Integer.parseInt(vehicleData[6]);
                double price = Double.parseDouble(vehicleData[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle)
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(File_PATH, true))) {
            writer.write(dealership.get);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}