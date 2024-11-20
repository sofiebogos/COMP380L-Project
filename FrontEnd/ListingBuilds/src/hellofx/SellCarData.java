package hellofx;

public class SellCarData {
    private static int yearCount = 1974;
    private static Integer[] years = new Integer[50];
    
    public static Integer[] getYears(){
        for (int i = 0; i < 50; i++){
            yearCount++;
            years[i] = yearCount;
        }
        return years;
    }

    public static String[] getMakes(){
        return new String[] {"Acura", "Alfa Romeo", "Audi", "BMW", "Buick", "Cadillac", 
                              "Chevrolet", "Chrysler", "Dodge","Ford", "Genesis", "GMC", "Honda", 
                              "Infiniti", "Jeep", "Kia", "Land Rover", "Lexus", "Lincoln", 
                              "Mazda", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Porsche", 

    }

    public static String[] getColors(){
        return new String[] {"White", "Black", "Gray", "Silver", "Blue", "Red", "Green", "Brown", 
                              "Beige", "Yellow", "Orange", "Purple", "Gold", "Tan", "Teal"       };
    }

    public static String[] getConditions(){
        return new String[] {"New", "Certified Pre-Owned", "Used"};
    }

    public static String[] getTitleStatus(){
        return new String[] {"Clean", "Salvage", "Lien", "Rebuilt"};
    }
}
