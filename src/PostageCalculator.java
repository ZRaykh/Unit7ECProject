public class PostageCalculator {
    public static final double BASECOST = 3.75;

    public static double calculatePostage(String zip1, String zip2, double lb, double h, double w, double l)
    {
        double cost = BASECOST;
        cost += 0.05 * (lb * 10);
        cost += Math.abs(Integer.parseInt(zip1.substring(0, 3)) -  Integer.parseInt(zip2.substring(0, 3))) /100.0;
        double combinedInch = h + w + l;
        for (int i = 36; i < combinedInch; i++)
        {
            cost += 0.1;
        }
        for (int i = 40; i < lb; i++)
        {
            cost += 0.1;
        }
        cost = (int) (cost * 100);
        cost = cost/100;
        return cost;
    }

    public static double calculatePostage(Address a, Address b, double lb, double h, double w, double l)
    {
        String zip1 = a.getZipCode();
        String zip2 = b.getZipCode();
        double cost = BASECOST;
        cost += 0.05 * (lb * 10);
        cost += Math.abs(Integer.parseInt(zip1.substring(0, 3)) -  Integer.parseInt(zip2.substring(0, 3))) /100.0;
        double combinedInch = h + w + l;
        for (int i = 36; i < combinedInch; i++)
        {
            cost += 0.1;
        }
        for (int i = 40; i < lb; i++)
        {
            cost += 0.1;
        }
        cost = (int) (cost * 100);
        cost = cost/100;
        return cost;
    }

    public static double calculatePostage(Package p)
    {
        Address a = p.getDestination();
        Address b = p.getOrigin();
        double  lb = p.getPounds();
        double h = p.getHeightIn();
        double w = p.getWidthIn();
        double l = p.getLengthIn();
        String zip1 = a.getZipCode();
        String zip2 = b.getZipCode();
        double cost = BASECOST;
        cost += 0.05 * (lb * 10);
        cost += Math.abs(Integer.parseInt(zip1.substring(0, 3)) -  Integer.parseInt(zip2.substring(0, 3))) /100.0;
        double combinedInch = h + w + l;
        for (int i = 36; i < combinedInch; i++)
        {
            cost += 0.1;
        }
        for (int i = 40; i < lb; i++)
        {
            cost += 0.1;
        }
        cost = (int) (cost * 100);
        cost = cost/100;
        return cost;
    }
}

