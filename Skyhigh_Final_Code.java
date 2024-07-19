import java.util.*;
import java.text.ParseException;//For Exception Date format
import java.text.SimpleDateFormat;//Use Date object
import java.awt.*; //For Toolkit.getDefaultToolkit().beep();

// File Name : Skyhigh_Final_Code
public class Skyhigh_Final_Code {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int choice, ans;
                control controller = new control();
                
                do {

                        System.out.println(
                    "\n      ✈              ✈        ✈   WELCOME  TO     🟧⬜🟩    SKYHIGH AIRLINES RESERVATION SYSTEM     🟧⬜🟩       ✈       ✈       ✈      ✈     ✈ ");
            System.out.println("");
            System.out.println("");
            System.out.println(
                    "             =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println(
                    "             ‖                                                                                                                        ");

            System.out.println(
                    "             ‖                                          🔰 [1]             List All Flights                                             ");

            System.out.println(
                    "             ‖                                          🔰 [2]              Search For A flight                                          ");

            System.out.println(
                    "             ‖                                          🔰 [3]              Book A Ticket                                                ");
            System.out.println(
                    "             ‖                                          🔰 [4]              Print A Ticket                                               ");
            System.out.println(
                    "             ‖                                          🔰 [5]              Cancel A Ticket                                              ");
            System.out.println(
                    "             ‖                                                                                                                         ");
            System.out.println(
                    "             =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                        System.out.println("");
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    ¦                🔰      Please select the serial number to be operated :                       ¦");
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                        System.out.print("                                       💠    ");
                        choice = sc.nextInt();
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();  
                        switch (choice) {
                                case 1:
                                        controller.displayFlightsDetails(0);
                                        break;
                                case 2:
                                        controller.searchForFlight();
                                        break;
                                case 3:
                                        controller.bookTicket();
                                        break;
                                case 4:
                                        controller.printTicket();
                                        break;
                                case 5:
                                        controller.cancelTicket();
                                        break;
                                default:
                                        // Toolkit.getDefaultToolkit().beep();
                                        System.out.println(
                                                        "                    ------------------------------------------------------------------------------------------------");
                                        System.out.println(
                                                        "                    |                                                 ⚠                                              ");
                                        System.out.println(
                                                        "                    |                                🔰    Please Enter a valid choice..!!                            ");
                                        System.out.println(
                                                        "                    ------------------------------------------------------------------------------------------------");
                                        break;
                        }
                        System.out.println(
                                        "\n                    ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    |                            🔰     Do You Want to do Further Process?                          ");
                        System.out.println(
                                        "                    |                                                                                               ");
                        System.out.println(
                                        "                    |                              🔙         (1) Next                                               ");
                        System.out.println(
                                        "                    |                              🛑         (2) END                                                ");
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                        System.out.print("                                                      💠    ");
                        ans = sc.nextInt();
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();  
                        if (ans == 2) {
                                System.out.println(
                                                "                 🔰     THANK YOU   🌝  FOR VISITING OUR    ✈    SKYHIGH AIRLINES RESERVATION SYSTEM    ✈");
                                System.out.println(
                                                "                 🔰     Share Your Experience With Us :)                ");
                                System.out.println("");
                                System.out.println(
                                                "                                                 ***************************************************     ");
                                ;
                                System.out.println(
                                                "                                                 ⁑    💻     This System is Developed by :               ");
                                System.out.println(
                                                "                                                 ⁑                                                        ");
                                System.out.println(
                                                "                                                 ⁑          1) Shubh Ranpara-   21BCE248               ");
                                System.out.println(
                                                "                                                 ⁑          2) Kishan Sardhara- 21BCE259               ");
                                System.out.println(
                                                "                                                 ⁑          3) Tanvi Rathod     21BCE250               ");
                                System.out.println(
                                                "                                                 ***************************************************     ");
                        }

                } while (ans != 2);
        }
}

class Flights {
        Scanner sc = new Scanner(System.in);
        int i = 0, j = 0, k = 0, c = 0; // counters for loops and others.
        int number_of_routes = 4; // (1) Rajkot to Mumbai, (2) Mumbai to Rajkot, (3) Surat to Mumbai, (4) Mumbai
                                  // to Surat.
        int number_of_flights = 3; // (1) 09:00 AM (2) 03:00 PM (3) 06:00 PM
        int number_of_days = 10; // The advance booking is allowed for 10 days only.
        int total_seats = 160;
        int total_arr[][][] = new int[number_of_routes][number_of_flights][number_of_days]; // total seats = 120 + 40 =
                                                                                            // 160.
        int booked_arr[][][] = new int[number_of_routes][number_of_flights][number_of_days]; // booked seats.
        int available_arr[][][] = new int[number_of_routes][number_of_flights][number_of_days]; // available seats =
                                                                                                // total
                                                                                                // seats - booked seats
        int seatsOfPlane[][][][] = new int[4][3][10][160]; // which seats are booked?
        {
                for (i = 0; i < number_of_routes; i++) {
                        for (j = 0; j < number_of_flights; j++) {
                                for (k = 0; k < number_of_days; k++) {
                                        for (int r = 0; r < 160; r++) {
                                                seatsOfPlane[i][j][k][r] = 0;
                                        }
                                }
                        }
                }

                for (i = 0; i < number_of_routes; i++) {
                        for (j = 0; j < number_of_flights; j++) {
                                for (k = 0; k < number_of_days; k++) {
                                        total_arr[i][j][k] = total_seats;
                                        booked_arr[i][j][k] = 0;
                                        available_arr[i][j][k] = total_arr[i][j][k] - booked_arr[i][j][k];
                                }
                        }
                }
        }
}
//inheritance
class control extends Flights {

        int route;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String date_string;
        String time_string;
        int timeslot;
        String start_date;
        String end_date;
        Time_Difference obj = new Time_Difference();
        long difference_hours;
        int differecnce_day;
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String num = "0123456789";
        String combination = upper + lower + num;
        int lenOfPnr = 8;
        char pnrNo[] = new char[lenOfPnr];//char Array

        Random r = new Random();

        PassengerDetails[] Passenger_arr = new PassengerDetails[number_of_routes * number_of_flights * number_of_days
                        * total_seats]; // Array of objects.size=4*3*10*160
        int oc = 0; // object counter.

        void displayFlightsDetails(int n) {
                {
                        switch (n) {
                                case 0:
                                        System.out.println();
                                        System.out.println(
                                                        "\n                  🟧⬜🟩  -----✈  ----✈---  ✈-----✈  Total available routes  ✈-----✈  ----✈---  ✈-----  ");
                                        System.out.println("                    ");
                                        System.out.println(
                                                        "                        =-=-=-=-=-=-=-=-=-=-=  🟠⚪🟢    All Domestic Flight Routes -=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                                        System.out.println(
                                                        "                       |                                                                                       ");
                                        System.out.println(
                                                        "                       |                          🔰 [1]      Rajkot   ✈-------------------------✈     Mumbai               ");
                                        System.out.println(
                                                        "                       |                          🔰 [2]     Mumbai    ✈-------------------------✈     Rajkot               ");
                                        System.out.println(
                                                        "                       |                          🔰 [3]     Surat     ✈-------------------------✈      Mumbai               ");
                                        System.out.println(
                                                        "                       |                          🔰 [4]     Mumbai    ✈-------------------------✈      Surat                ");
                                        System.out.println(
                                                        "                       |                                                                                       ");
                                        System.out.println(
                                                        "                        -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                                        System.out.flush();
                                        break;

                                case 1:
                                        System.out.println(
                                                        "\n                        --------------------------------------------------------------------------------------------");
                                        System.out.println("                        1️⃣  🔰  Rajkot ✈-----✈  ----✈---  ✈-----✈   🔰  Mumbai ");
                                        System.out.println(
                                                        "                        ----------------------------------------------------------------------------------------------");
                                        System.out.println(
                                                        "                        Route No.(1)        :    Rajkot to Mumbai, Your flight will arrive at Terminal -> 1.\n");
                                        System.out.println("                        Origin Airport      :    Rajkot Airport");
                                        System.out.println(
                                                        "                        Destination Airport :    Chhatrapati Shivaji Maharaj International Airport (CSMIA)  Airport");
                                        System.out.println("                        Total Travel Time   :    1 Hour 10 Minutes ");
                                        System.out.println(
                                                        "                        ----------------------------------------------------------------------------------------------");

                                        break;

                                case 2:
                                        System.out.println(
                                                        "\n                        ---------------------------------------------------------------------------------------------");
                                        System.out.println("                        2️⃣  🔰  Mumbai ✈-----✈  ----✈---  ✈-----✈  🔰  Rajkot ");
                                        System.out.println(
                                                        "                        -----------------------------------------------------------------------------------------------");
                                        System.out.println(
                                                        "                        Route No.(2)         :    Mumbai to Rajkot, Your flight will arrive at Terminal -> 2.\n");
                                        System.out.println(
                                                        "                        Origin Airport       :    Chhatrapati Shivaji Maharaj International Airport (CSMIA)  Airport");
                                        System.out.println("                        Destination Airport  :    Rajkot Airport");
                                        System.out.println("                        Total Travel Time      :    1 Hour 20 Minutes ");
                                        System.out.println(
                                                        "                        -----------------------------------------------------------------------------------------------");
                                        break;

                                case 3:
                                        System.out.println(
                                                        "\n                        -------------------------------------------------------------------------------------------- ");
                                        System.out.println("                        3️⃣  🔰  Surat ✈-----✈  ----✈---  ✈-----✈  🔰  Mumbai ");
                                        System.out.println(
                                                        "                        -----------------------------------------------------------------------------------------------");
                                        System.out.println(
                                                        "                        Route No.(3)          :   Surat to Mumbai, Your flight will arrive at Terminal -> 3.\n");
                                        System.out.println(
                                                        "                        Origin Airport        :   Surat Thani International Airport");
                                        System.out.println(
                                                        "                        Destination Airport   :   Chhatrapati Shivaji Maharaj International Airport (CSMIA)  Airport");
                                        System.out.println("                        Total Travel Time       :   55 Minutes ");
                                        System.out.println(
                                                        "                        -----------------------------------------------------------------------------------------------");
                                        break;

                                case 4:

                                        System.out.println(
                                                        "\n                        ----------------------------------------------------------------------------------- ");
                                        System.out.println("                        4️⃣  🔰  Mumbai ✈-----✈  ----✈---  ✈-----✈  🔰  Surat ");
                                        System.out.println(
                                                        "                        --------------------------------------------------------------------------------------");
                                        System.out.println(
                                                        "                        Route No.(4)           :   Mumbai to Surat, Your flight will arrive at Terminal -> 4.\n");
                                        System.out.println(
                                                        "                        Origin Airport         :   Chhatrapati Shivaji Maharaj International Airport (CSMIA)  Airport");
                                        System.out.println(
                                                        "                        Destination Airport    :   Surat Thani International Airport");
                                        System.out.println("                        Total Travel Time      :   55 Minutes ");
                                        System.out.println(
                                                        "                        ------------------------------------------------------------------------------------------------------------------------------");
                                        break;

                                default:
                                        System.out.println(
                                                        "                    ------------------------------------------------------------------------------------------------");
                                        System.out.println(
                                                        "                    |                                           ⚠  Not Found !                                   ");
                                        System.out.println(
                                                        "                    |                                🔰    Please Enter a valid Route!                                ");
                                        System.out.println(
                                                        "                    ------------------------------------------------------------------------------------------------");
                        }
                }
        }

        void searchForFlight() {

                displayFlightsDetails(0);
                do {
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    ¦                🔰        Select the route of your journey                                             ");
                        System.out.print("                                       💠      ");
                        route = sc.nextInt();
                        sc.nextLine();
                        displayFlightsDetails(route);
                } while (route < 1 || route > 4);

                do {
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    ¦                🔰   📅      Enter the date of journey (DD/MM/YYYY)                            ");
                        System.out.print("                                       💠     ");
                        date_string = sc.nextLine();
                        time_string = "18:00:00";

                        start_date = sdf.format(date);//current Date
                        end_date = date_string + " " + time_string;

                        difference_hours = obj.findDifference(start_date, end_date);
                        if (difference_hours < 0) {
                                System.out.println(
                                                "                    ------------------------------------------------------------------------------------------------");
                                System.out.println(
                                                "                    |                                           ⚠  Not Found !                                   ");
                                System.out.println(
                                                "                    |                                🔰    Please Enter a valid Date                                ");
                                System.out.println(
                                                "                    ------------------------------------------------------------------------------------------------");
                        }

                } while (difference_hours < 0);

                System.out.println(
                                "                    ------------------------------------------------------------------------------------------------");
                
                System.out.println(
                                "                        --------------------------------------------------------------------------------");
                System.out.println(
                                "                       |                 🕒   Departure Time Of Flight                                 ");
                System.out.println(
                                "                       |                           1️⃣   09:00                                           ");
                System.out.println(
                                "                       |                           2️⃣   15:00                                           ");
                System.out.println(
                                "                       |                           3️⃣   18:00                                          ");
                System.out.println(
                                "                       --------------------------------------------------------------------------------");
                System.out.println(
                                "                                      🔰   🕒      Select the Time of journey                             ");
                System.out.print("                                          💠     ");
                timeslot = sc.nextInt();
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                if (timeslot == 1) {
                        time_string = "09:00:00";
                } else if (timeslot == 2) {
                        time_string = "15:00:00";
                } else if (timeslot == 3) {
                        time_string = "18:00:00";
                }

                start_date = sdf.format(date);
                end_date = date_string + " " + time_string;

                difference_hours = obj.findDifference(start_date, end_date);
                differecnce_day = (int) (difference_hours / 24);
                i = route - 1;
                j = timeslot - 1;
                k = differecnce_day;

                if (difference_hours >= 3 && difference_hours <= 10 * 24) {
                        // System.out.println(differecnce_day);
                        available_arr[i][j][k] = total_arr[i][j][k] - booked_arr[i][j][k];
                        System.out.println(
                                        "\n                    ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    ¦                🔰     Number of Available seats are  :"
                                                        + "💠 "
                                                        + available_arr[i][j][k]);
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                } else {
                        System.out.println(
                                        "\n                    ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    |                                              ⚠ No Found!                                       ");
                        System.out.println(
                                        "                    |                                🔰    No Flight is available according to your preference      ");
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                }
        }

        void bookTicket() {

                displayFlightsDetails(0);

                do {
                        System.out.println(
                                        "\n                    ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    ¦                🔰      Select the route of your journey                                             ");
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                        System.out.print("                                       💠    ");
                        route = sc.nextInt();
                        sc.nextLine();
                        displayFlightsDetails(route);
                } while (route < 1 || route > 4);

                do {
                        System.out.println(
                                        "\n                    ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    ¦                🔰         Enter the date of journey (DD/MM/YYYY)                            ");
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                        System.out.print("                                       💠     ");
                        date_string = sc.nextLine();
                        time_string = "18:00:00";

                        start_date = sdf.format(date);
                        end_date = date_string + " " + time_string;

                        difference_hours = obj.findDifference(start_date, end_date);
                        if (difference_hours < 0) {
                                System.out.println(
                                                "\n                    ------------------------------------------------------------------------------------------------");
                                System.out.println(
                                                "                    |                                           ⚠  Not Found !                                   ");
                                System.out.println(
                                                "                    |                                🔰    Please Enter a valid Date                                ");
                                System.out.println(
                                                "                    ------------------------------------------------------------------------------------------------");
                        }
                } while (difference_hours < 0);

                System.out.println(
                                "\n                        -----------------------------------------------------------------------------");
                System.out.println(
                                "                       |                 🕒   Departure Time Of Flight                                 ");
                System.out.println(
                                "                       |                           1️⃣   09:00                                           ");
                System.out.println(
                                "                       |                           2️⃣   15:00                                           ");
                System.out.println(
                                "                       |                           3️⃣   18:00                                          ");
                System.out.println(
                                "                       ------------------------------------------------------------------------------");
                System.out.println(
                                "                                      🔰         Select the Time of journey                             ");
                System.out.print("                                          💠      ");
                timeslot = sc.nextInt();
                if (timeslot == 1) {
                        time_string = "09:00:00";
                } else if (timeslot == 2) {
                        time_string = "15:00:00";
                } else if (timeslot == 3) {
                        time_string = "18:00:00";
                }

                start_date = sdf.format(date);
                end_date = date_string + " " + time_string;

                difference_hours = obj.findDifference(start_date, end_date);
                differecnce_day = (int) (difference_hours / 24);
                i = route - 1;
                j = timeslot - 1;
                k = differecnce_day;

                if (difference_hours >= 3 && difference_hours <= 10 * 24) {
                        // System.out.println(differecnce_day);
                        available_arr[i][j][k] = total_arr[i][j][k] - booked_arr[i][j][k];

                        System.out.println(
                                        "\n                                          🔰      How many seats you want to book ? ");
                        System.out.print("                                          💠      ");
                        int number_of_seat = sc.nextInt();
                        int temp = booked_arr[i][j][k];

                        if (number_of_seat > 0 && number_of_seat <= available_arr[i][j][k]) {
                                booked_arr[i][j][k] += number_of_seat;
                                available_arr[i][j][k] = total_arr[i][j][k] - booked_arr[i][j][k];
                                int numsofseatsbooked[] = new int[170];
                                for (int m = 0; m < 170; m++) {
                                        numsofseatsbooked[m] = -1;
                                }
                                int p = 0, forme = 0;
                                int tempNum = number_of_seat;
                                if (number_of_seat == 1) {
                                        for (int j = 0; tempNum != 0; j++) {
                                                if (seatsOfPlane[i][j][k][j] == 0) {
                                                        seatsOfPlane[i][j][k][j] = 1;
                                                        tempNum--;
                                                        numsofseatsbooked[p++] = j + 1;
                                                }
                                        }
                                } else {
                                        if (temp == 0) {
                                                for (int m = 0; tempNum != 0; m++) {
                                                        if (forme == 0) {
                                                                numsofseatsbooked[p++] = m + 1;
                                                                forme = 1;
                                                        }
                                                        tempNum--;
                                                        seatsOfPlane[i][j][k][m] = 1;
                                                        if (tempNum == 0) {
                                                                numsofseatsbooked[p] = m + 1;
                                                        }
                                                }
                                        } else {
                                                for (int y = 0; tempNum != 0; y++) {
                                                        if (seatsOfPlane[i][j][k][y] == 0) {
                                                                if (forme == 0) {
                                                                        numsofseatsbooked[p++] = y + 1;
                                                                        forme = 1;
                                                                } else if (seatsOfPlane[i][j][k][y] == 0
                                                                                && seatsOfPlane[i][j][k][y + 1] == 1) {
                                                                        numsofseatsbooked[p++] = y + 1;
                                                                } else if (seatsOfPlane[i][j][k][y] == 0
                                                                                && seatsOfPlane[i][j][k][y - 1] == 1) {
                                                                        numsofseatsbooked[p++] = y + 1;
                                                                } else if (tempNum == 1) {
                                                                        numsofseatsbooked[p] = y + 1;
                                                                }
                                                                if (tempNum == 1) {
                                                                        for (int o = 0; o <= y; o++) {
                                                                                seatsOfPlane[i][j][k][o] = 1;
                                                                        }
                                                                }
                                                                tempNum--;
                                                        }
                                                }
                                        }
                                }
                                Passenger_arr[oc] = new PassengerDetails();//number of objects are the size for passenger details
                                Passenger_arr[oc].Getter(Passenger_arr[oc], date_string, timeslot, number_of_seat,
                                                numsofseatsbooked,
                                                route);
                                oc++;
                        } else if (number_of_seat > available_arr[i][j][k]) {
                                System.out.println(
                                                "\n                    ------------------------------------------------------------------------------------------------");
                                System.out.println(
                                                "                    |                                              ⚠                                               ");
                                System.out.println(
                                                "                    |                                       Sorry For Inconvenience                                 ");
                                System.out.println(
                                                "                    |                                🔰    Required seats are more than available seats..!!         ");
                                System.out.println();
                                System.out.println(
                                                "           |                                🔰      Available seats : "
                                                                + available_arr[i][j][k]);
                                System.out.println(
                                                "                    ------------------------------------------------------------------------------------------------");
                        }
                } else {
                        System.out.println(
                                        "\n                         ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    |                                              ⚠                                               ");
                        System.out.println(
                                        "                    |                                       Sorry For Inconvenience                                 ");
                        System.out.println(
                                        "                    |                                🔰    Not available now..!!  ( Time is over )                  ");
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                }
        }

        void printTicket() {
                System.out.print("\n                                                  💠       Yes, You can get your ticket..!!");
                sc.nextLine();                                                           
                if (oc >= 1) {
                        boolean check;
                        do {
                                check = false;

                                System.out.println(
                                                "\n                    ------------------------------------------------------------------------------------------------");
                                System.out.println(
                                                "                    ¦                🔰      Enter your journey PNR Number to Print your Ticket!                     ");
                                System.out.println(
                                                "                    ------------------------------------------------------------------------------------------------");
                                System.out.print("                                       💠     ");
                                String getPnrNo = sc.nextLine();
                                for (int k = 0; k < oc; k++) {
                                        if (getPnrNo.equals(Passenger_arr[k].PnrNo)) {
                                                Passenger_arr[k].Display(Passenger_arr[k]);
                                                break;
                                        } else if (k == oc - 1 && !getPnrNo.equals(Passenger_arr[k].PnrNo)) {
                                                System.out.println(
                                                                "\n                    ------------------------------------------------------------------------------------------------");
                                                System.out.println(
                                                                "                    |                                              ⚠  No Found !                                     ");
                                                System.out.println(
                                                                "                    |                                🔰      Sorry! You entered PNR NO is not valid...!!        ");
                                                System.out.println(
                                                                "                    |                                🔰      Check Your PNR Number in Your Ticket ");
                                                System.out.println(
                                                                "                    ------------------------------------------------------------------------------------------------");
                                                check = true;
                                        }
                                }
                        } while (check);
                } else {
                        System.out.println(
                                        "\n                    ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    |                                          ⚠  No Found !                                        ");
                        System.out.println(
                                        "                    |                                🔰 Not Booked Any Tickets yet.                                  ");
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                }
        }

        void cancelTicket() {
                if (oc >= 1) {
                        System.out.print("\n                                                  💠       Yes, You can cancel your ticket..!!");
                        sc.nextLine();  
                        boolean ch = false;
                        do {
                                ch = false;
                                System.out.println(
                                                "\n                    ------------------------------------------------------------------------------------------------");
                                System.out.println(
                                                "                    ¦                🔰      Enter your jouney PNR Number for Cancelation Process!                                           ");
                                System.out.println(
                                                "                    ------------------------------------------------------------------------------------------------");
                                System.out.print("                                       💠     ");
                                String getPnr = sc.nextLine();
                                for (int f = 0; f < oc; f++) {
                                        if (getPnr.equals(Passenger_arr[f].PnrNo)) {
                                                Passenger_arr[f].Display(Passenger_arr[f]);
                                                if (Passenger_arr[f].TimeSlot == 1) {
                                                        time_string = "09:00:00";
                                                } else if (Passenger_arr[f].TimeSlot == 2) {
                                                        time_string = "15:00:00";
                                                } else if (Passenger_arr[f].TimeSlot == 3) {
                                                        time_string = "18:00:00";
                                                }
                                                String cancelDate = sdf.format(date);
                                                end_date = Passenger_arr[f].date_of_journey + " " + time_string;

                                                difference_hours = obj.findDifference(cancelDate, end_date);
                                                differecnce_day = (int) (difference_hours / 24);
                                                i = Passenger_arr[f].selected_route - 1;
                                                j = Passenger_arr[f].TimeSlot - 1;
                                                k = differecnce_day;

                                                if (difference_hours >= 3 && difference_hours <= 10 * 24) {
                                                        booked_arr[i][j][k] -= Passenger_arr[f].total_booked_seats;
                                                        available_arr[i][j][k] = total_arr[i][j][k]
                                                                        - booked_arr[i][j][k];
                                                        if (Passenger_arr[f].total_booked_seats == 1) {
                                                                seatsOfPlane[i][j][k][Passenger_arr[f].numsOfSeatsBooked[0]] = 0;
                                                        } else {
                                                                for (int c = 0; Passenger_arr[f].numsOfSeatsBooked[c] != -1; c += 2) {
                                                                        for (int w = Passenger_arr[f].numsOfSeatsBooked[c]
                                                                                        - 1; w < Passenger_arr[f].numsOfSeatsBooked[c
                                                                                                        + 1]; w++) {
                                                                                seatsOfPlane[i][j][k][w] = 0;
                                                                        }
                                                                }
                                                        }

                                                        for (int y = f; y < oc - 1; y++) {
                                                                Passenger_arr[y] = Passenger_arr[y + 1];
                                                        }
                                                        oc--;
                                                        System.out.println(
                                                                        "\n                    ------------------------------------------------------------------------------------------------");
                                                        System.out.println(
                                                                        "                    ¦                💠     Terms and Conditions for Cancelation Process:                          ");
                                                        System.out.println(
                                                                        "                    ¦                🔰      You can only cancel your booking before the last three Hours. ");
                                                        System.out.println(
                                                                        "                    ¦                🔰      You will get your refund subject to a clerkage charge within seven days.!");
                                                        System.out.println(
                                                                        "                    ¦                 🔰      You will get refund : "
                                                                                        + (Passenger_arr[f].total_price
                                                                                                        - (Passenger_arr[f].total_price
                                                                                                                        * 0.2)));

                                                        System.out.println(
                                                                        "\n                    ------------------------------------------------------------------------------------------------");
                                                        System.out.println(
                                                                        "\n                    ------------------------------------------------------------------------------------------------");
                                                        System.out.println(
                                                                        "                    ¦                🔰      Your Booking Canceled Successfully..!!                                 ");
                                                        System.out.println(
                                                                        "                    ------------------------------------------------------------------------------------------------");
                                                } else {

                                                        System.out.println(
                                                                        "\n                    ------------------------------------------------------------------------------------------------");
                                                        System.out.println(
                                                                        "                    ¦                             ⚠ Time is over..!!                         ");
                                                        System.out.println(
                                                                        "                    ¦                🔰      You can only cancel your booking before the last three Hours. ");
                                                        System.out.println(
                                                                        "                    ¦                🔰      Now you can not cancel your booked Seats");
                                                        System.out.println(
                                                                        "                    ------------------------------------------------------------------------------------------------");
                                                }
                                                break;

                                        } else {
                                                if (f == oc - 1) {
                                                        System.out.println(
                                                                        "\n                    ------------------------------------------------------------------------------------------------");
                                                        System.out.println(
                                                                        "                    |                                              ⚠  No Found !                                     ");
                                                        System.out.println(
                                                                        "                    |                                🔰      Sorry! Your entered PNR NO is not valid...!!        ");
                                                        System.out.println(
                                                                        "                    |                                🔰      Check Your PNR Number in Your Ticket ");
                                                        System.out.println(
                                                                        "                    ------------------------------------------------------------------------------------------------");
                                                        ch = true;
                                                }
                                        }
                                }
                        } while (ch);
                } else{
                        System.out.println(
                                        "\n                    ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "                    |                                          ⚠  Sorry..!!                                        ");
                        System.out.println(
                                        "                    |                                🔰 Not Booked Any Tickets yet..!!                              ");
                        System.out.println(
                                        "                    ------------------------------------------------------------------------------------------------");
                }
                        
        }

        class PassengerDetails extends control {

                String firstname, middlename, lastname, fullname; // Name details.
                String email, contact_no, aadhaar_no; // Contact and verification details.
                String card_no, fullnameOfCardholder, cvv_no; // For Payment details.
                int expiry_month, expiry_year;
                String date_of_journey;
                int TimeSlot;
                String PnrNo;

                int total_booked_seats;
                int numsOfSeatsBooked[] = new int[170]; // Seat number (from where to where)
                                                        // details.
                int selected_route;
                double price, tax, tax_rate = 0.05, total_price; // total price = price + tax;
                double[] route_wise_price = new double[4];
                {
                        route_wise_price[0] = 4000;
                        route_wise_price[1] = 4500;
                        route_wise_price[2] = 10000;
                        route_wise_price[3] = 10500;
                }

                void Getter(PassengerDetails Passenger, String doj, int ts, int total, int[] nosb, int Route) {

                        for (int i = 0; i < lenOfPnr; i++) {
                                pnrNo[i] = combination.charAt(r.nextInt(combination.length()));//char array which store PNR
                                if (i == lenOfPnr - 1) {
                                        String tempPnrNo = new String(pnrNo);
                                        for (int j = 0; j < oc; j++) {
                                                if (tempPnrNo.equals(Passenger_arr[j].PnrNo)) {
                                                        i = 0;
                                                        break;
                                                }
                                        }
                                }
                        }
                        Passenger.PnrNo = new String(pnrNo);

                        System.out.println(
                                        "\n                        <<<✈-----✈  ----✈---  ✈-----  🔰   Enter the details of Passenger    🔰 ✈-----✈  ----✈---  ✈-----✈>>>   ");
                        System.out.println(
                                        "                        ------------------------------------------------------------------------------------------------");
                        System.out.println(
                                        "\n                        ¦                🔰      First Name:                                 ");
                        System.out.print("                        ¦                  💠     ");
                        Passenger.firstname = sc.nextLine();
                        Passenger.firstname = Passenger.firstname.trim();
                        System.out.println(
                                        "\n                        ¦                🔰      Middle Name:                                 ");
                        System.out.print("                        ¦                  💠     ");
                        Passenger.middlename = sc.nextLine();
                        Passenger.middlename = Passenger.middlename.trim();
                        System.out.println(
                                        "\n                        ¦                🔰       Last Name:                                 ");
                        System.out.print("                        ¦                  💠     ");
                        Passenger.lastname = sc.nextLine();
                        Passenger.lastname = Passenger.lastname.trim();

                        Passenger.fullname = Passenger.firstname.substring(0, 1).toUpperCase()
                                        + firstname.substring(1, firstname.length()).toLowerCase()
                                        + " " + Passenger.middlename.substring(0, 1).toUpperCase()
                                        + middlename.substring(1, middlename.length()).toLowerCase()
                                        + " " + Passenger.lastname.substring(0, 1).toUpperCase()
                                        + lastname.substring(1, lastname.length()).toLowerCase();

                        System.out.println("\n                        ¦                🔰     Email ID:                                 ");
                        System.out.print("                        ¦                  💠     ");
                        Passenger.email = sc.nextLine();

                        do {
                                System.out.println(
                                                "\n                        ¦                🔰     Mobile Number:                                 ");
                                System.out.print("                        ¦                  💠     ");
                                Passenger.contact_no = sc.nextLine();
                                Passenger.contact_no = Passenger.contact_no.trim();
                                if (Passenger.contact_no.length() != 10)
                                        System.out.println(
                                                        "\n                              ⚠  Enter valid Mobile number..!! ");
                                else {
                                        c = 0;
                                        for (i = 0; i < Passenger.contact_no.length(); i++) {
                                                if (Passenger.contact_no.charAt(i) >= 48
                                                                && Passenger.contact_no.charAt(i) <= 57)
                                                        c++;
                                        }
                                        if (c != 10)
                                                System.out.println(
                                                                "\n                              ⚠  Enter valid Mobile number..!! ");
                                }
                        } while (Passenger.contact_no.length() != 10 || c != 10);
                        c = 0;

                        do {
                                System.out.println(
                                                "\n                        ¦                🔰     Aadhar  Number:                                 ");
                                System.out.print("                        ¦                  💠     ");
                                Passenger.aadhaar_no = sc.nextLine();
                                System.out.println(
                                                "\n                        ------------------------------------------------------------------------------------------------");
                                Passenger.aadhaar_no = Passenger.aadhaar_no.trim();
                                if (Passenger.aadhaar_no.length() != 12)
                                        System.out.println(
                                                        "\n                              ⚠  Enter valid  Aadhaar number..!! ");
                                else {
                                        c = 0;
                                        for (i = 0; i < Passenger.aadhaar_no.length(); i++) {
                                                if (Passenger.aadhaar_no.charAt(i) >= 48
                                                                && Passenger.aadhaar_no.charAt(i) <= 57)
                                                        c++;
                                        }
                                        if (c != 12)
                                                System.out.println(
                                                                "\n                              ⚠  Enter valid  Aadhaar number..!! ");
                                }
                        } while (Passenger.aadhaar_no.length() != 12 || c != 12);
                        c = 0;
                        
                        Passenger.selected_route = Route;
                        Passenger.date_of_journey = doj;
                        Passenger.total_booked_seats = total;
                        numsOfSeatsBooked = nosb;
                        Passenger.TimeSlot = ts;

                        Passenger.price = total * route_wise_price[Passenger.selected_route - 1];
                        Passenger.tax = Passenger.price * tax_rate;
                        Passenger.total_price = Passenger.price + Passenger.tax;
                        
                        System.out.println("\n   **********************<<---PAYMENT DETAILS-->>*****************************     ");
                        System.out.println("");
                        System.out.println("        1)  Base price             "             + Passenger.price + " Rs/-");
                        System.out.println("                                                                        ");
                        System.out.println("        2)  Taxes (GST included)   "             + Passenger.tax + " Rs/- ");
                        System.out.println("  _____________________________________________________________________________     ");
                        System.out.println("\n      Total price of your reservation is :"    + Passenger.total_price + " Rs/-");
                        System.out.println(
                                        "\n                        **********************<<---ENTER YOUR CARD DETAILS-->>*****************************     ");
                         
                                        do {
                                                System.out.println("\n     ¦   🔰        Card Number:                                 ");
                                                System.out.print("     ¦                   —>     ");
                                                Passenger.card_no = sc.nextLine();
                                                Passenger.card_no = Passenger.card_no.trim();
                                                if (Passenger.card_no.length() != 16)
                                                    System.out.println("\n                              ⚠  Enter valid  Card number..!! ");
                                                else {
                                                    c = 0;
                                                    for (i = 0; i < Passenger.card_no.length(); i++) {
                                                        if (Passenger.card_no.charAt(i) >= 48 && Passenger.card_no.charAt(i) <= 57)
                                                            c++;
                                                    }
                                                    if (c != 16)
                                                        System.out.println("\n                              ⚠  Enter valid  Card number..!! ");
                                                }
                                            } while (Passenger.card_no.length() != 16 || c != 16);
                                            c = 0;
                                
                                            do {
                                                System.out.println("\n     ¦   🔰     Expiry Month(MM) :                                ");
                                                System.out.print("     ¦                    —>     ");
                                                Passenger.expiry_month = sc.nextInt();
                                                if (Passenger.expiry_month >= 1 && Passenger.expiry_month <= 12)
                                                    c++;
                                                else
                                                    System.out.println("\n                              ⚠  Enter valid  Expiry Month..!! ");
                                            } while (c == 0);
                                            c=0;
                                
                                            do {
                                                System.out.println("\n     ¦   🔰     Expiry Year(YYYY):                                 ");
                                                System.out.print("     ¦                    —>     ");
                                                Passenger.expiry_year = sc.nextInt();
                                                sc.nextLine();
                                                if (Passenger.expiry_year >= 2022 && Passenger.expiry_year <= 2027)
                                                    c++;
                                                else
                                                    System.out.println("\n                              ⚠  Enter valid Expiry Year..!!                          ");
                                            } while (c == 0);
                                            c = 0;
                                
                                            do {
                                                System.out.println("\n     ¦   🔰     Full Name Of card holder:                                 ");
                                                System.out.print("     ¦                       —>     ");
                                                Passenger.fullnameOfCardholder = sc.nextLine();
                                                Passenger.fullnameOfCardholder = Passenger.fullnameOfCardholder.trim();
                                                if (Passenger.fullnameOfCardholder.length() > 50)
                                                    System.out.println("\n                              ⚠  Enter valid  Name..!! ");
                                            } while (Passenger.fullnameOfCardholder.length() > 50);
                                
                                            do {
                                                System.out.println("\n     ¦   🔰     CVV number:                                 ");
                                                System.out.print("     ¦                    —>     ");
                                                Passenger.cvv_no = sc.nextLine();
                                                Passenger.cvv_no = Passenger.cvv_no.trim();
                                                if (Passenger.cvv_no.length() != 3)
                                                    System.out.println("\n                              ⚠  Enter valid  CVV Number..!! ");
                                                else {
                                                    c = 0;
                                                    for (i = 0; i < Passenger.cvv_no.length(); i++) {
                                                        if (Passenger.cvv_no.charAt(i) >= 48 && Passenger.cvv_no.charAt(i) <= 57)
                                                            c++;
                                                    }
                                                    if (c != 3)
                                                        System.out.println("\n                              ⚠  Enter valid  CVV Number..!! ");
                                                }
                                            } while (Passenger.cvv_no.length() != 3 || c != 3);
                                            c = 0;

                        System.out.println(
                                        "                        ————————————————————————————————————————————————————————————————————————————————————");
                        System.out.println(
                                        "                        ‖                       ✅      Payment Successfull   ✅                             ‖ ");
                        System.out.println(
                                        "                        ————————————————————————————————————————————————————————————————————————————————————");
                        System.out.println("");
                        System.out.println(
                                        "\n                         -----------------------------------------------------------------------------------------------  ");
                        System.out.println("                                                  🔰   Booking  Confirmed   ✔                               ");
                        System.out.println("                                                      🔰   Your journey PNR NO: " + PnrNo);
                        System.out.println("                                                  🔰  Save PNR NUMBER to get your Boarding Pass              ");
                        System.out.println("                        ------------------------------------------------------------------------------------------------");

                        if (ts == 1) {
                                time_string = "09:00:00";
                        } else if (ts == 2) {
                                time_string = "15:00:00";
                        } else if (ts == 3) {
                                time_string = "18:00:00";
                        }
                        System.out.println("\n                        ✈-----✈  ----✈---  ✈-----✈ YOUR FLIGHT DETAILS ✈-----✈  ----✈---  ✈-----✈");
                        System.out.println("\n                        🔰   Flight Time : " + time_string);
                        System.out.println("\n                        🔰  Total number of booked seats: "
                                                        + Passenger.total_booked_seats);

                        if (Passenger.total_booked_seats == 1) {
                                System.out.println("\n                        🔰  Your Booked Seat Number: "
                                                + numsOfSeatsBooked[0]);

                        } else {
                                int q = 0;
                                System.out.println(
                                                "\n                        🔰  Your Booked Seat Numbers: ");

                                for (int g = 0; Passenger.numsOfSeatsBooked[g] != -1; g++) {
                                        if (g % 2 == 0) {
                                                System.out.print("                               "+ Passenger.numsOfSeatsBooked[q++] + " to ");
                                        } else {
                                                System.out.println(Passenger.numsOfSeatsBooked[q++]);
                                        }
                                }
                        }

                }

                void Display(PassengerDetails Passenger) {
                        System.out.println(
                                        "\n                        *********************************    BOOKING SUMMARY   ********************************* ");

                        System.out.println("\n                        💠    FLight Schedule : \n");
                        System.out.println("\n                        🔰     PNR NO: " + Passenger.PnrNo);
                        System.out.println("                        🔰     Name : " + Passenger.fullname);
                        System.out.println("                        🔰     Date of journey : " + Passenger.date_of_journey);
                        String ShowTime = "";
                        if (Passenger.TimeSlot == 1) {
                                ShowTime = "09:00:00";
                        } else if (Passenger.TimeSlot == 2) {
                                ShowTime = "15:00:00";
                        } else if (Passenger.TimeSlot == 3) {
                                ShowTime = "18:00:00";
                        }
                        System.out.println("                        🔰     Time of journey : " + ShowTime);

                        Passenger.displayFlightsDetails(Passenger.selected_route);
                        System.out.println("\n                        💠    Flight Seat Allocation : \n");

                        System.out.println("                        🔰     Total number of booked seats: " + Passenger.total_booked_seats);

                        if (Passenger.total_booked_seats == 1) {
                                System.out.println("\n                        🔰  Your Booked Seat Number: "
                                                + numsOfSeatsBooked[0]);

                        } else {
                                int q = 0;
                                System.out.println(
                                                "\n                        🔰  Your Booked Seat Numbers: ");

                                for (int g = 0; Passenger.numsOfSeatsBooked[g] != -1; g++) {
                                        if (g % 2 == 0) {
                                                System.out.print("                               "
                                                                + Passenger.numsOfSeatsBooked[q++] + " to ");
                                        } else {
                                                System.out.println(Passenger.numsOfSeatsBooked[q++]);
                                        }
                                }
                        }

                        System.out.println(
                                        "\n                        ************************(:  Have a Nice journey..💫!! :)************************ \n");
                        System.out.println(
                                        "\n                        ~~~~~~~~~~~~~~~~~   ✈     SKYHIGH AIRLINES   ✈   🌐 Take Wherever You Want  ~~~~~~~~~~~~~~~~~");
                        System.out.println(
                                        "                        🔰     THANK YOU   🌝  FOR VISITING OUR   SKYHIGH AIRLINES RESERVATION SYSTEM ");
                        System.out.println("                        🔰     Share Your Experience With Us :)                ");
                        System.out.println(
                                        "\n                        ************************(:  Have a Nice journey..💫!! :)*************************    \n");
                }
        }

        class Time_Difference {
                long findDifference(String start_date, String end_date) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                        try {
                                Date d1 = sdf.parse(start_date);
                                Date d2 = sdf.parse(end_date);

                                long difference_In_Time = d2.getTime() - d1.getTime();
                                long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;
                                long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

                                // System.out.println("Milli " + difference_In_Time);
                                // System.out.println("Hours " + difference_In_Hours);
                                // System.out.println("Days " + difference_In_Days);
                                // System.out.println("Total Hours = " + ((difference_In_Days * 24) +
                                // difference_In_Hours));

                                return ((difference_In_Days * 24) + difference_In_Hours);
                        }

                        catch (ParseException e) {
                                e.printStackTrace();
                        }
                        return 0;
                }
        }
}