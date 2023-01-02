import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static boolean isCNPValid(int length) {
        boolean flag = true;
        if (length != 13) {
            flag = false;
        }
        return flag;
    }
    public static String getYearPrefix(char firstNumber) {
        String prefix = "";
        switch (firstNumber){
            case '1':
                prefix = "19";
                break;
            case '2':
                prefix = "19";
                break;
            case '3':
                prefix = "18";
                break;
            case '4':
                prefix = "18";
                break;
            case '5':
                prefix = "20";
                break;
            case '6':
                prefix = "20";
                break;
            default:
                prefix ="INVALID";
                break;
        }
        return prefix;
    }

    public static char returnSexOfPerson(char firstNumber) {
        char sex;
        if (firstNumber == '1' ||
                firstNumber == '3' ||
                firstNumber == '5' ||
                firstNumber == '7') {
            sex = 'M';
        } else {
            sex = 'F';
        }
        return sex;
    }


    public static String getBirthDateFromCnpAsString(String CNP) {
        String dateOfBirth = CNP.substring(1,7);
        String prefix = getYearPrefix(CNP.charAt(0));

        dateOfBirth = prefix + dateOfBirth;
        return dateOfBirth.substring(6,8) + "-" + dateOfBirth.substring(4,6) + "-" + dateOfBirth.substring(0,4);
    }

    public static int CalculateAgeBasedonBirthDate(String BirthDate) {
        String[]formattedBirthDate = BirthDate.split("-");
        int dayofBirth = Integer.parseInt(formattedBirthDate[0]);
        int monthofBirth = Integer.parseInt(formattedBirthDate[1]);
        int yearofBirth = Integer.parseInt(formattedBirthDate[2]);

        String pattern = "dd-MM-yyy";
        String currentDate = new SimpleDateFormat(pattern).format(new Date());

        String[] formattedCurrentDate = currentDate.split("-");
        int currentDay = Integer.parseInt(formattedCurrentDate[0]);
        int currentMonth = Integer.parseInt(formattedCurrentDate[1]);
        int currentYear = Integer.parseInt(formattedCurrentDate[2]);

        int age = currentYear - yearofBirth;
        if (monthofBirth > currentMonth) {

            age -= 1;
        } else if (monthofBirth == currentMonth) {
            if (dayofBirth > currentDay) {
                age -= 1;
            }
        }
        return age;
    }
    public static String getCountyBasedonCNP(String CNP) {
        String county = "";
        int countyCode = Integer.parseInt(CNP.substring(7,9));
        switch (countyCode) {
            case 1:
                county = "Alba";
                break;
            case 2:
                county = "Arad";
                break;
            case 3:
                county = "Arges";
                break;
            case 4:
                county = "Bacau";
                break;
            case 5:
                county = "Bihor";
            break;
            default:
                county = "Invalid";
                break;
        }
        return county;



        }





    public static void main(String[] args) {
        String CNP = "2931111050098";


        System.out.println(CNP);
        System.out.println(returnSexOfPerson('2'));
        System.out.println(getBirthDateFromCnpAsString(CNP));
        System.out.println(CalculateAgeBasedonBirthDate(getBirthDateFromCnpAsString(CNP)));
        System.out.println(getCountyBasedonCNP(CNP));





    }

}





    }
}
