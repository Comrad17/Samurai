import java.util.Random;
public class Samurai {
    private String name;
    private String weaponType;
    private boolean doubleWeapon;
    private boolean hasHorse;
    private boolean hasArmor;
    private String type;
    private double hitPower;
    private double life;
    Random random = new Random();

    public Samurai(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public boolean isDoubleWeapon() {
        return doubleWeapon;
    }

    public void setDoubleWeapon(boolean doubleWeapon) {
        this.doubleWeapon = doubleWeapon;
    }

    public boolean isHasHorse() {
        return hasHorse;
    }

    public void setHasHorse(boolean hasHorse) {
        this.hasHorse = hasHorse;
    }

    public boolean isHasArmor() {
        return hasArmor;
    }

    public void setHasArmor(boolean hasArmor) {
        this.hasArmor = hasArmor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHitPower() {
        return hitPower;
    }

    public void setHitPower(double hitPower) {
        this.hitPower = hitPower;
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    /* Αν το αντικείμενο έχει πανοπλία, τότε η μέθοδος επιστρέφει την τιμή που θα πάρει ως παράμετρο -10.0, ή αν έχει
    άλογο επιστρέφει την τιμή που θα πάρει ως παράμετρο -5.0. Αν έχει και τα 2 τότε επιστρέφει την τιμή που θα πάρει ως
    παράμετρο -15.0. */
    public double defend() {
        double def = 0;
        if (hasArmor) def -= 10;
        if (hasHorse) def -= 5;
        return  def;
    }

    /* Η μέθοδος για ένα από τα εξής όπλα, επιστρέφει: αν είναι katana την τιμή 10.0, αν είναι yumi (longbow) την τιμή
    15.0, αν είναι naginata την τιμή 20.0, αν είναι wakizashi την τιμή 5.0. Αν το doubleweapon είναι true, τότε όλες οι
    προηγούμενες τιμές x 1.8 */
    public double getWeaponPower() {
        double power = 0;
        switch (weaponType) {
            case  "katana":
                power = 10;
                break;
            case "yumi":
                power = 15;
                break;
            case "naginata":
                power = 20;
                break;
            case "wakizashi":
                power = 5;
                break;
        }
        if(doubleWeapon) power *= 1.8;
        return power;
    }

    /* η μέθοδος για έναν από τους εξής τύπους, επιστρέφει: αν είναι military την τιμή hitpower + 10.0 ή αν είναι ronin
    την τιμή hitpower + 5.0 + (hitpower /4.0) – παράλληλα εμφανίζει μήνυμα name + " shouts haaaaiiii!" */
    public double attack() {
        double power = 0;
        if(type.equals("military")) {
            power = hitPower + 10.0;
        }
        else if(type.equals("ronin")) {
            System.out.println("\n" + name + " shouts haaaaiiii!");
            power = hitPower + 5.0 + (hitPower /4.0);
        }
        return power;
    }

    /*αν η ζωή του αντικειμένου είναι <= 0.0, τότε θέτει τη ζωή του αντικειμένου ίση με 0.0 και εμφανίζει μήνυμα:
    name + ” …died!”, αλλιώς εμφανίζει την τιμή της ζωής του αντικειμένου.*/
    public void checkState() {
        if(life <= 0) {
            life = 0;
            System.out.println(name + " ..died!");
        }
        else {
            System.out.printf("Η ζωή του %s είναι %.2f\n", name, life);
        }
    }

    /* εκτυπώνει “όμορφα”, όλα τα χαρακτηριστικά του αντικειμένου στην κονσόλα. */
    public void print() {
        System.out.println("\nΤα χαρακτηριστικά του " + name + " είναι:");
        System.out.printf("δύναμη κρούσης : %.2f \nυγεία :          %.2f \n", hitPower, life);
        System.out.print("τύπος όπλου :    " + weaponType + "\nδιπλό όπλο :     ");
        if(doubleWeapon) System.out.print("ναι");
        else System.out.print("όχι");
        System.out.print("\nέχει άλογο :     ");
        if(hasHorse) System.out.print("ναι");
        else System.out.print("όχι");
        System.out.print("\nέχει πανοπλία :  ");
        if(hasArmor) System.out.print("ναι");
        else System.out.print("όχι");
        System.out.println("\nτύπος samurai :  " + type);
    }


}
