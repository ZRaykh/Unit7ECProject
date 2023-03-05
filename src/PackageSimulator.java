import  java.util.ArrayList;
import  java.text.DecimalFormat;
public class PackageSimulator
{
    ArrayList<Package> p;
    PostageCalculator helper;

    public PackageSimulator()
    {
        p = new ArrayList<Package>();
        helper = new PostageCalculator();
    }

    public void generatePackages(int packages)
    {
        for (int i = 1; i <= packages; i++)
        {
            Address origin = generateAddress();
            Address destination = generateAddress();
            double weight = generateWeight();
            double totalDim = generateDimensionTotal();
            double length = generateLength();
            double width = generateWidth(totalDim, length);
            double height = generateHeight(totalDim,length, width);
            Package newPackage = new Package (destination, origin, weight,length, width, height);
            p.add(newPackage);
        }
    }

    public void resetSimulation()
    {
        p = new ArrayList<Package>();
    }

    public String getSimulationInfo()
    {
        String info = "";
        int packageCount = 1;
        for (Package l : p)
        {
            info += "\nPackage " + packageCount +": ______________________________";
            info += "\nOrigin Address: " + l.getOrigin();
            info += "\nDestination Address: " + l.getDestination();
            info += "\nWeight:" + l.getPounds();
            info += "\nHeight:" + l.getHeightIn();
            info += "\nLength:" + l.getLengthIn();
            info += "\nWidth:" + l.getWidthIn();
            info += "\nCost: " + helper.calculatePostage(l);
            packageCount++;
        }
        info += "\n____________________________________________________________";
        info += "\nTotal cost of all packages: " + generateTotalCost();
        return info;
    }

    public double generateTotalCost()
    {
        double cost = 0;
        for (Package l : p)
        {
            cost += helper.calculatePostage(l);
        }
        return cost;
    }

    //Generate packages helper methods
    public Address generateAddress()
    {
        DecimalFormat d = new DecimalFormat("000");
        String zip = "";
        zip += d.format((int) (Math.random() * 995) + 5);
        zip += "01";
        Address a = new Address("123", "Street", "1A", "City", "State", zip);
        return a;
    }


    public double generateWeight()
    {
        //USPS allows maximum package weight to be 70 for all packages, hence the limit of 70, 0.01 added to prevent flat 0 and allow 70.
        return (Math.random() + 0.01) * 70;
    }

    public double generateDimensionTotal()
    {
        //USPS allows maximum package girth and length to be 130, hence the limit of 130, 0.01 added to prevent flat 0 and allow 130.
        return (Math.random() + 0.01) * 130;
    }

    public double generateLength()
    {
        //For this case we need 1 starting int, so length will be confined to 60 in order to remain the largest dimension
        return Math.random() * 61;
    }
    public double generateWidth(double totalDimensions, double l)
    {
        double range = ((totalDimensions - l)/2) * 0.75;
        return Math.random() * range;
    }

    public double generateHeight(double totalDimensions, double l, double w)
    {
        double h = ((totalDimensions - l)/2) - w;
        return h;
    }
}
