import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @org.junit.jupiter.api.Test
    void readCar() {
        if (ReadFile.carList.isEmpty()){
            System.out.println("readAccount Test Failed");
        } else {
            System.out.println("readAccount Test Sucessful");
        }
    }

    @org.junit.jupiter.api.Test
    void readAccount() {
        if (ReadFile.accountList.isEmpty()){
            System.out.println("readAccount Test Failed");
        } else {
            System.out.println("readAccount Test Sucessful");
        }
    }

    @org.junit.jupiter.api.Test
    void readListing() {
        if (ReadFile.listingList.isEmpty()){
            System.out.println("ReadListing Test Failed");
        } else {
            System.out.println("ReadListing Test Sucessful");
        }
    }

    @org.junit.jupiter.api.Test
    void Compare() {
            boolean truthValue = ReadFile.Compare( "1;img1.jpg,img2.jpg,img3.jpg;John Doe;Red;Good;25000;Clean;Sunroof;90210;A reliable sedan with low mileage.;20000;Sedan"
            , "listing.txt");
            if (truthValue == true){
                System.out.println("Compare Test Sucessful");
            } else {
                System.out.println("Compare Test Failed");
            }
    }

   
    @org.junit.jupiter.api.Test
    void findAndReturn() {
        String returnValue = ReadFile.FindAndReturn("John Doe", "listing.txt");
        if (returnValue =="0"){
            System.out.println("Find and Return Test Sucessful");
        } else {
            System.out.println("Find and Return Test Failed");
        }
    }
}
