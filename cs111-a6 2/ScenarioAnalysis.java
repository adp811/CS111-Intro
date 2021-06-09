/*************************************************************************
 *  Compilation:  javac ScenarioAnalysis.java
 *  Execution:    java ScenarioAnalysis
 *
 *  @author:
 *
 *************************************************************************/
public class ScenarioAnalysis {

    // Instance variables
    private Vehicle[] vehicles;       // all vehicless being analyzed 
    private double  gasPrice;         // price of one gallon of gas in dollars
    private double  electricityPrice; // price of 1 kWh in cents of a dollar, c$/kWh

    /*
     * Constructor
     */ 
    public ScenarioAnalysis ( double gasPrice, double electricityPrice ) {
        this.gasPrice = gasPrice;
        this.electricityPrice = electricityPrice;
    }

    /*
     * Updates the price of gas
     * Call computeCO2EmissionsAndCost() whenever there is an update on gas prices
     */
    public void setGasPrice ( double gasPrice ) {
        this.gasPrice = gasPrice;
        computeCO2EmissionsAndCost();
    }

    /*
     * Returns the gas price
     */ 
    public double getGasPrice () {
        return gasPrice;
    }

    /*
     * Updates the price of electricity
     * Call computeCO2EmissionsAndCost() whenever there is an update on electricity prices
     */
    public void setElectricityPrice ( double electricityPrice ) {
        this.electricityPrice = electricityPrice;
    }
    
    /*
     * Returns electricity price
     */
    public double getElectricityPrice () {
        return electricityPrice;
    }

    /*
     * Computes and updates the CO2 emissions, fuel cost and total cost for each 
     * vehicle in the vehicles array.
     */
    public void computeCO2EmissionsAndCost () {
        
         // WRITE YOUR CODE HERE

         double CO2GAS_CONSTANT = Fuel.CO2EMITTED_GASCOMBUSTION;
         double CO2ELECTRIC_CONSTANT = Fuel.CO2EMITTED_GENERATEmWh;
 
         for (int i = 0; i < vehicles.length; i ++){
 
             Vehicle vehicle = vehicles[i];
 
             if(vehicle.getFuel().getType() == Fuel.GAS){ //gas powered
 
                 
                 double totalLeaseMileage = ((double) vehicle.getLease().getNumberOfMonths() / 12) * 
                 vehicle.getLease().getMileageAllowance();
                 double vehicleMPG = vehicle.getFuel().getUsage();
                 
                 //CO2 Emission Computation
                 double CO2EMISSION = (totalLeaseMileage / vehicleMPG) * CO2GAS_CONSTANT;
 
                 //Fuel Cost Computation
                 double FUELCOST = (totalLeaseMileage / vehicleMPG) * this.getGasPrice();
 
                 //Total Cost Computation
                 double downPayment = vehicle.getLease().getDueAtSigning();
                 double monthlyPaymentTotal = vehicle.getLease().getMonthlyCost() *
                 vehicle.getLease().getNumberOfMonths();
                 double misc_cost = vehicle.getOtherCost();
 
                 double FINALCOST = FUELCOST + downPayment + monthlyPaymentTotal + misc_cost;
 
                 vehicle.setCO2Emission(CO2EMISSION); 
                 vehicle.setTotalCost(FINALCOST);
                 vehicle.setFuelCost(FUELCOST);
 
 
             } else if (vehicles[i].getFuel().getType() == Fuel.ELECTRIC){ //electric powered 
 
                 double totalLeaseMileage = ((double) vehicle.getLease().getNumberOfMonths() / 12) * 
                 vehicle.getLease().getMileageAllowance();
                 double vehicleMPC = vehicle.getFuel().getUsage();
                 double vehicleKWH = vehicle.getFuel().getKWhPerCharge(); 
 
                 //CO2 Emission Computation
                 double leaseEnergyConsumption = (totalLeaseMileage / vehicleMPC) * vehicleKWH;
                 double conversionComputation = (CO2ELECTRIC_CONSTANT) * ((double)1/1000) * (0.45); 
 
                 double CO2EMISSION = leaseEnergyConsumption * conversionComputation;
                 
                 //Energy Cost Computation
                 double ENERGYCOST = leaseEnergyConsumption * (this.getElectricityPrice() * 0.01);
 
 
                 //Total Cost Computation
                 double downPayment = vehicle.getLease().getDueAtSigning();
                 double monthlyPaymentTotal = vehicle.getLease().getMonthlyCost() *
                 vehicle.getLease().getNumberOfMonths();
                 double misc_cost = vehicle.getOtherCost();
 
                 double FINALCOST = ENERGYCOST + downPayment + monthlyPaymentTotal + misc_cost;
 
                 vehicle.setCO2Emission(CO2EMISSION); 
                 vehicle.setTotalCost(FINALCOST);
                 vehicle.setFuelCost(ENERGYCOST);
 
             }
 
         }
         
    }

    /*
     * Returns vehicles array
     */
    public Vehicle[] getVehicles () {
        return vehicles;
    }

    /*
     * Prints all vehicles
     */
    public void printVehicles () {
        for ( Vehicle v : vehicles ) {
            StdOut.println(v);
        }
    }

    /*
     * Populates the array vehicles from file vehicles.txt
     * 
     * File Format: The file can have either gas or electric lines
     * 
     * gas,      name, cash due at signing lease,lease length in months, monthly lease cost, mileage allowance per 12 months, miles per gallon, cost of oil change
     * electric, name, cash due at signing lease,lease length in months, monthly lease cost, mileage allowance per 12 months, miles per kWh/charge, kWh per charge, cost of home charger
     */ 
    public void populateVehicleArray () {
        StdIn.setFile("vehicles.txt");

        // read the number of car models and allocate array
        int numberOfCars = StdIn.readInt();
        vehicles = new Vehicle[numberOfCars];

        for (int i = 0; i < numberOfCars; i++) {
            String fuelType = StdIn.readString();
            String name     = StdIn.readString();

            // Lease information
            double dueAtSigning  = StdIn.readDouble();
            int numberOfMonths = StdIn.readInt();
            double montlyCost  = StdIn.readDouble();
            int mileageAllowance = StdIn.readInt();
            Lease lease = new Lease(dueAtSigning,numberOfMonths,montlyCost,mileageAllowance);

            // Fuel
            double usage = StdIn.readDouble();
            Fuel fuel = null; 
            if ( fuelType.toLowerCase().equals("electric")) {
                double kWhPerCharge = StdIn.readDouble();
                fuel = new Fuel (usage, kWhPerCharge);
            } else {
                fuel = new Fuel (usage);
            }

            // other cost include oil change for gas-powered or home charger for eletric-powered
            double otherCost = StdIn.readDouble();

            // Instatiate the new vehicle
            vehicles[i] = new Vehicle (name, fuel, lease, otherCost);
        }
    }

    /*
     * Test client
     */
    public static void main (String[] args) {
        ScenarioAnalysis sa = new ScenarioAnalysis(3.45, 0.3);
        sa.populateVehicleArray();
        sa.setGasPrice(2.23);           // $2.23 per gallon of gas
        sa.setElectricityPrice(16.14);  // c$16.14 per kWh
        sa.computeCO2EmissionsAndCost();
        sa.printVehicles();
    }
}