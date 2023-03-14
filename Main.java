import java.util.Random;
public class Main {

    public static void fight(Samurai attacker, Samurai defender, int textAttack, boolean isPowerfull) {

        double blow = attacker.attack(); //δυνατό χτύπημα
        if(!isPowerfull) blow/=2;
        Text.attack(textAttack);
        System.out.println("\n(πριν)");
        defender.print();
        defender.setLife((defender.getLife() - blow - attacker.getWeaponPower() - defender.defend()));
        System.out.println("\n(μετά)");
        defender.checkState();
        if(defender.getLife() > 0) defender.print();
    }

    public static void initSamurai(Samurai s, boolean horse, boolean armor, double power, boolean doubleWeapon, String weaponType, double life, String type){
        s.setHasHorse(horse);
        s.setHasArmor(armor);
        s.setHitPower(power);
        s.setDoubleWeapon(doubleWeapon);
        s.setWeaponType(weaponType);
        s.setLife(life);
        s.setType(type);
    }

    public static double getRandom(String type){
        int max = 0, min = 0;

        switch (type) {
            case "strong" -> {
                max = 20;
                min = 17;
            }
            case "healthy" -> {
                max = 100;
                min = 90;
            }
            case "weak" -> {
                max = 13;
                min = 10;
            }
            case "lowHealth" -> {
                max = 45;
                min = 35;
            }
        }
        Random random = new Random();
        return min + random.nextFloat() * (max - min);
    }

    public static void main(String[] args) {
        Text.introduction();
        /*Στο κέντρο της μάχης που μαίνεται με μανία, εμφανίζεται περήφανα ο Akechi Mitsuhide. Είναι διάσημος πολεμιστής
         στρατού, πεζός με την αστραφτερή πανοπλία του, ακμαίος, σε κάθε χέρι κρατάει από ένα katana και μέχρι τώρα δεν
         έχει ούτε μια γρατζουνιά.*/
	    Samurai akechi = new Samurai("Akechi Mitsuhide");
        initSamurai(akechi,
                false,  // πεζός
                true,  // με την αστραφτερή πανοπλία
                getRandom("strong"), // ακμαίος
                true, // σε κάθε χέρι κρατάει
                "katana",  // katana
                getRandom("healthy"),  // δεν έχει ούτε μια γρατζουνιά
                "military");
        Text.akechiMitsuhide();
        akechi.print();


        /* Δεν ισχύει το ίδιο για τον συμπολεμιστή του, Date Masamune, που βρίσκεται λίγα βήματα πιο πίσω. Έχει
        τραυματιστεί σοβαρά και με ότι ζωή του έχει απομείνει ακολουθεί τον Akechi πάνω στο άλογο του. Η πανοπλία του
        είναι πλέον άχρηστη και το μόνο που του έχει απομείνει είναι το τόξο του. */
        Samurai date = new Samurai("Date Masamune");
        initSamurai(date,
                true,
                false,
                getRandom("weak"),
                false,
                "yumi",
                getRandom("lowHealth"),
                "military");
        Text.dateMasamune();
        date.print();

        /* Τελευταίος ακολουθεί ο Hattori Hanzō. Ο σκληροτράχηλος συμπολεμιστής της μικρής ομάδας, ακμαίος, πολύ ικανός
        με το μακρύ του δόρυ, έχει σκοτώσει αμέτρητους εχθρούς χωρίς να έχει τραυματιστεί καθόλου. Τρομαχτικός στην
        πανοπλία του, αν και έχασε στη μάχη το άλογο του, δεν θα διστάσει να θυσιάσει και τον εαυτό του ακόμη, αρκεί να
        πετύχει αυτό που θέλουν και οι άλλοι δύο σύντροφοι του. Να γίνει μια τελευταία αναμέτρηση τιμής, ζωής ή θανάτου,
         με τα ξακουστά περιπλανώμενα αδέρφια, που λένε ότι όσοι τους συνάντησαν σε μάχη, δεν έζησαν για να το
         διηγηθούν. */
        Samurai hattori = new Samurai("Hattori Hanzo");
        initSamurai(hattori,
                false,
                true,
                getRandom("strong"),
                false,
                "naginata",
                getRandom("healthy"),
                "military");

        Text.hattoriHanzo();
        hattori.print();

        /* Πρώτος απέναντι τους εμφανίστηκε ο Oda Nobunaga. Ο μικρότερος αδερφός, έφιππος, ακμαίος, στο πίσω μέρος της
        πανοπλίας του πρόβαλαν οι λαβές από δύο wakizashi που ήξερε να χειρίζεται όπως κανείς άλλος και με αυτά είχε
        μόλις αφήσει πίσω του μια σειρά από πτώματα στρατιωτών. Κανείς δεν είχε προλάβει σήμερα να ακουμπήσει όπλο πάνω
        του. */
        Samurai oda = new Samurai("Oda Nobunaga");
        initSamurai(oda,
                true,
                true,
                getRandom("strong"),
                true,
                "wakizashi",
                getRandom("healthy"),
                "ronin");
        Text.odaNobunaga();
        oda.print();

        /* Ακόμη πιο ικανός όμως, ήταν ο αδερφός του, Takeda Nobunaga, που μόλις έφτασε ξεπέζεψε από το άλογο του δίπλα
        στον αδερφό του και τράβηξε αργά το katana του από τη θήκη του. Η πανοπλία του ήταν σαν καινούργια και αν και
        βαριά, δεν εμπόδιζε τις κινήσεις του στην μάχη όταν σαν άνεμος άφηνε πίσω του πτώματα. */
        Samurai takeda = new Samurai("Takeda Nobunaga");
        initSamurai(takeda,
                false,
                true,
                getRandom("strong"),
                false,
                "katana",
                getRandom("healthy"),
                "ronin");

        Text.takedaNobunaga();
        takeda.print();

        /*Ο Takeda επιτίθεται στον Akechi και στον Date σχεδόν ταυτόχρονα και με όλη του τη
        δύναμη. Κανείς τους δεν πρόλαβε να αντιδράσει.*/

        fight(takeda, akechi, 1, true);
        fight(takeda, date, 1, true);

        /* Ο Oda επιτίθεται στον Hattori με όλη του τη δύναμη. */
        fight(oda, hattori, 2, true);

        /* Ο Hattori αντεπιτίθεται στον Oda με όλη του τη δύναμη. */
        fight(hattori, oda, 3, true);

        /* Χτυπημένος ο Date ρίχνει μια αδύναμη βολή με το τόξο του στον Takeda */
        fight(date, takeda, 4, true);

        /* Ο Akechi επιτίθεται στον Takeda με όλη του τη δύναμη. */
        fight(akechi, takeda, 5, true);

        /* Ο Takeda για να προστατέψει τον αδερφό του, επιτίθεται στον Hattori και καταφέρνει 2
        απανωτά χτυπήματα με όλη του τη δύναμη. */
        fight(takeda, hattori, 6, true);
        fight(takeda, hattori, 0, true);

        /* Χτυπημένος ο Oda επιτίθεται αδύναμα στον Akechi. */
        fight(oda, akechi, 7, false);

        /* Χτυπημένος ο Date ρίχνει μια αδύναμη βολή με τον τόξο του στον Oda. */
        fight(date, oda, 8, true);

        /* Ο Takeda βλέποντας αυτό, επιτίθεται στον Date με όλη του την δύναμη. */
        fight(takeda, date, 9, true);

        /* Ο Hattori επιτίθεται αδύναμα στον Takeda. */
       fight(hattori, takeda, 10, false);

        /* Χτυπημένος ο Akechi επιτίθεται αδύναμα στον Oda. */
        fight(akechi, oda, 11, false);

        /* Εξαντλημένος ο Takeda, επιτίθεται αδύναμα στον Akechi. */
        fight(takeda, akechi, 12, true);

        /* Τρώει όμώς μια αδύναμη επίθεση από τον Hattori. */
        fight(hattori, takeda, 13, false);

        /* Ο Oda επιτίθεται δυνατά 2 φορες στον Akechi */
        fight(oda, akechi, 14, true);
        fight(oda, akechi, 0, true);

        /* Αλλά δυστυχώς έρχεται ο Hattory και βαράει δυνατά τον Oda */
        fight(hattori, oda, 15, true);

        System.out.println("Τα ronins είναι νεκροί... Δόξα στα ronins !");
    }
}
