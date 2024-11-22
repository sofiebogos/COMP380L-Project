package hellofx;

/**
 * This class is strictly used as a way to provide data to the arrays used in the PostingController class.
 * @param yearCount is the initial value assigned to the years array, it is incremented in the loop below.
 * @param years is the array passed to the PostingController class.
 */

public class SellCarData {
    private static int yearCount = 2026;
    private static Integer[] years = new Integer[100];
    
        /**
         * This method populates and returns the years array.
         * @return years
         */
    public static Integer[] getYears(){
        for (int i = 0; i < 100; i++){
            yearCount--;
            years[i] = yearCount;
        }
        return years;
    }

        /**
         * This method returns the array of possible make choices.
         * @return new String[].
         */
    public static String[] getMakes(){
        return new String[] {"Acura", "Alfa Romeo", "Audi", "BMW", "Buick", "Cadillac", 
                              "Chevrolet", "Chrysler", "Dodge","Ford", "Genesis", "GMC", "Honda", 
                              "Infiniti", "Jeep", "Kia", "Land Rover", "Lexus", "Lincoln", 
                              "Mazda", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Porsche", 
                              "Ram", "Subaru", "Tesla", "Toyota", "Volkswagen", "Volvo"            };

    }

        /**
         * This method returns the array of possible color choices.
         * @return new String[].
         */
    public static String[] getColors(){
        return new String[] {"White", "Black", "Gray", "Silver", "Blue", "Red", "Green", "Brown", 
                              "Beige", "Yellow", "Orange", "Purple", "Gold", "Tan", "Teal"       };
    }

        /**
         * This method returns the array of possible condition choices.
         * @return new String[].
         */
    public static String[] getConditions(){
        return new String[] {"New", "Certified Pre-Owned", "Used"};
    }

        /**
         * This method returns the array of possible title status choices.
         * @return new String[].
         */
    public static String[] getTitleStatus(){
        return new String[] {"Clean", "Salvage", "Lien", "Rebuilt"};
    }
}
