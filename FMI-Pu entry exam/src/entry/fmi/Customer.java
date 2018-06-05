package entry.fmi;

public class Customer {

    String name;
    String lastName;
    String city;
    long personalCode;

    public Customer(String name, String lastName, String city, long personalCode) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.personalCode = personalCode;
    }

    public String typeStock() {
        String codetoString = String.valueOf(personalCode);
        if (codetoString.substring(0, 1).equals("1")) {
            return "kozmetika";
        } else if (codetoString.substring(0, 1).equals("2")) {
            return "parfiumi";
        } else if (codetoString.substring(0, 1).equals("3")) {
            return "aksesoalri";
        } else {
            return "uslugi";
        }
    }

    public String hasPromotions() {
        String codetoString = String.valueOf(personalCode);
        if (codetoString.substring(1, 2).equals("0")) {
            return "bez natrupvane";
        } else {
            return "s natrupvane";
        }
    }

    public String getProcent() {
        String codetoString = String.valueOf(personalCode);
        return codetoString.substring(2, 4);
    }

    public String getDate() {
        String codetoString = String.valueOf(personalCode);
        return codetoString.substring(4, codetoString.length());
    }

    public int takeProcents() {
        String codetoString = String.valueOf(this.personalCode);
        String subString = codetoString.substring(2, 4);
        if (subString.equals("05")) {
            return 5;
        } else {
            int realProcent = Integer.parseInt(subString);
            return realProcent;
        }
    }
    public int getTypeStock() {
        String codetoString = String.valueOf(personalCode);
        if (codetoString.substring(0, 1).equals("1")) {
            return 1;
        } else if (codetoString.substring(0, 1).equals("2")) {
            return 2;
        } else if (codetoString.substring(0, 1).equals("3")) {
            return 3;
        } else {
            return 4;
        }
    }
}
