import java.util.ArrayList;

/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author: Aryan Patel - adp182
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        
        this.listOfPatients = null;
        this.survivabilityByAge = null;
        this.survivabilityByCause = null;

    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) { //*** might need to test 

        if (arrayIndex > (listOfPatients.length - 1)) {
            return -1; //desired array index does not exist in listOfPatients
        }

        listOfPatients[arrayIndex] = p;
        return 0; //desired array index exists in listOfPatients

    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {

        this.listOfPatients = new Person[numberOfLines];

        for (int i = 0; i < numberOfLines; i ++){

            int identification = StdIn.readInt();
            int ethnicity = StdIn.readInt();
            int gender = StdIn.readInt();
            int age = StdIn.readInt();
            int cause = StdIn.readInt();
            int urgency = StdIn.readInt();
            int stateOfHealth = StdIn.readInt();
            
            Person patient = new Person(identification, ethnicity, gender, age, cause, urgency, stateOfHealth);
            addPerson(patient, i);

        }

        return listOfPatients.length;

    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {

        this.survivabilityByAge = new SurvivabilityByAge[numberOfLines];

        for (int i = 0; i < numberOfLines; i++){

            int age = StdIn.readInt();
            int yearsPT = StdIn.readInt(); 
            double ratePCT = StdIn.readDouble();

            SurvivabilityByAge rate = new SurvivabilityByAge(age, yearsPT, ratePCT);
            survivabilityByAge[i] = rate;

        }

        return survivabilityByAge.length;

    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {

        this.survivabilityByCause = new SurvivabilityByCause[numberOfLines];

        for(int i = 0; i < numberOfLines; i ++) {

            int cause = StdIn.readInt();
            int yearsPT = StdIn.readInt();
            double ratePCT = StdIn.readDouble();

            SurvivabilityByCause rate = new SurvivabilityByCause(cause, yearsPT, ratePCT);
            survivabilityByCause[i] = rate;

        }

        return survivabilityByCause.length;

    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) { // done

        int size = 0;
        for (int i = 0; i < listOfPatients.length; i ++){
            Person patient = listOfPatients[i];
            if (patient.getAge() > age){
                size +=1;        
            }
        }

        if(size == 0) return null;

        Person[] patientArray = new Person[size];

        int counter = 0;
        for (int j = 0; j < listOfPatients.length; j ++) {
            Person patient = listOfPatients[j];
            if (patient.getAge() > age){
                patientArray[counter] = patient;
                counter++;
            }
        }
        

        return patientArray;

    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) { //done

        int size = 0;
        for (int i = 0; i < listOfPatients.length; i ++){
            Person patient = listOfPatients[i];
            if (patient.getStateOfHealth() == state){
                size +=1;
            }
        }

        if(size == 0) return null;

        Person[] patientArray = new Person[size];

        int counter = 0;
        for (int j = 0; j < listOfPatients.length; j ++) {
            Person patient = listOfPatients[j];
            if (patient.getStateOfHealth() == state){
                patientArray[counter] = patient;
                counter++;
            }
        }

        return patientArray;

    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) { //done

        int size = 0;
        for (int i = 0; i < listOfPatients.length; i ++){
            Person patient = listOfPatients[i];
            if (patient.getCause() == cause){
                size +=1;
            }
        }

        if(size == 0) return null;

        Person[] patientArray = new Person[size];

        int counter = 0;
        for (int j = 0; j < listOfPatients.length; j ++) {
            Person patient = listOfPatients[j];
            if (patient.getCause() == cause){
                patientArray[counter] = patient;
                counter++;
            }
        }

        return patientArray;

    }

    /*
     * Assume there are numberOfHearts available for transplantation surgery.
     * Also assume that the hearts are of the same blood type as the
     * persons on the listOfPatients.
     * This method finds a set of persons to be the recepients of these
     * hearts.
     * 
     * The method returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.
     * 
     * If numberOfHeartsAvailable is smaller than listOfPatients
     * array size find the set of people with the highest
     * potential for survivability.
     * 
     * There is no correct solution, you may come up with any set of
     * persons from the listOfPatients array.
     */ 
    public Person[] match(int numberOfHearts) {

        Person[] surgeryCandidates = new Person[numberOfHearts];
        
        ArrayList <Person> patients1 = new ArrayList<Person>(); 
        ArrayList <Person> patients2 = new ArrayList<Person>(); 
        
        
        if(numberOfHearts >= listOfPatients.length){
            for(int i = 0; i < listOfPatients.length; i ++){
                surgeryCandidates[i] = listOfPatients[i];
            }

            return surgeryCandidates;

        } else {

            int count = numberOfHearts;

            for (int a = 0; a < listOfPatients.length; a++){
                patients1.add(listOfPatients[a]);
            }
                        
            for(int i = 0; i < patients1.size(); i ++){ //urgency

                if(count == 0) break;
                Person subject = patients1.get(i);
                if(subject.getUrgency() == 9 && subject.getAge() < 60) {
                    count -=1;
                    patients1.remove(i);
                    patients2.add(subject);
                }

            }

            for(int j = 0; j < patients1.size(); j ++){

                if(count == 0) break;
                Person subject = patients1.get(j);
                if(subject.getStateOfHealth() >= 6 && subject.getCause() == 2 && subject.getAge() < 50) {
                    count -=1;
                    patients1.remove(j);
                    patients2.add(subject);
                }

            }

            for(int k = 0; k < patients1.size(); k ++){

                if(count == 0) break;
                Person subject = patients1.get(k);
                if(subject.getCause() <= 4) {
                    count -=1;
                    patients1.remove(k);
                    patients2.add(subject);
                }

            }

            for (int b = 0; b < surgeryCandidates.length; b ++){
                surgeryCandidates[b] = patients2.get(b);
            }

            return surgeryCandidates;
    
        }

    }

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {

        HeartTransplant ht = new HeartTransplant();

        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");
 
        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }


        // delete from below
       /* StdOut.println();
        Person[] test = ht.getPatientsByHeartConditionCause(2);
        for(Person each: test){
            StdOut.println(each);
        } 
       */

        /*StdOut.println(); 
        Person[] test = ht.match(12);
        for(Person each: test){
           StdOut.println(each);
        } 
        */

    }
}
