import java.awt.*;
import java.util.Scanner;
public class PostageCalculatorRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int choice = 0;
        while (choice != 4)
        {
            PackageSimulator ps = new PackageSimulator();
            System.out.println("What would you like to do?");
            System.out.println("1. Calculate cost of one package");
            System.out.println("2. Simulate packages");
            System.out.println("3. How package costs are calculated");
            System.out.println("4. Exit");
            System.out.println("Input:");

            choice = Integer.parseInt(s.nextLine());


            while (choice < 1 || choice > 4)
            {
                System.out.println("Error, please enter a valid option:");
                choice = s.nextInt();
            }

            System.out.println("__________________________________");

            if (choice == 1)
            {
                System.out.println("Enter the zip code of the origin package:");
                String originZip = s.nextLine();
                System.out.println("Enter the zip code of the destination package:");
                String destinationZip = s.nextLine();
                System.out.println("Enter the weight of the package:");
                double lb = s.nextDouble();
                System.out.println("Enter the height of the package:");
                double h = s.nextDouble();
                System.out.println("Enter the length of the package:");
                double l = s.nextDouble();
                System.out.println("Enter the width of the package:");
                double w = s.nextDouble();

                PostageCalculator p = new PostageCalculator();
                System.out.println("Cost: " + p.calculatePostage(originZip, destinationZip, lb, h, w, l));
                System.out.println("__________________________________");
            }
            if (choice == 2)
            {
                System.out.println("How many packages would you like to simulate?");
                String c = s.nextLine();
                ps.generatePackages(Integer.parseInt(c));
                System.out.println(ps.getSimulationInfo());
                ps.resetSimulation();
            }

            if (choice == 3)
            {
                System.out.println("How package costs are calculated:");
                System.out.println("The base cost is $3.75,");
                System.out.println("Then, the difference in country codes over 100 is added to the cost,");
                System.out.println("5 cents is added for each tenth (1/10) of a pound,");
                System.out.println("Packages over 40 pounds will be charged an additional 10 cents per tenth of a pound,");
                System.out.println("Packages whose combined length, width, and height exceeds 36 inches will also be charged an additional 10 cents per inch.");
                System.out.println("__________________________________");
            }
        }
    }
}
