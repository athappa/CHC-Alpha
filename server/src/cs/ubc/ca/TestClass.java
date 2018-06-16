package cs.ubc.ca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;

public class TestClass {

    public static void main(String[] args) {
        // write your code here
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String dbURL = "jdbc:mysql://localhost:3306/trading_system_DB?useSSL=false";
            String dbUsername = "root";
            String password = "123456";
            // ?autoReconnect=true&useSSL=false

            //1. Create connection
            Connection myConnection = DriverManager.getConnection(dbURL, dbUsername, password);

            //2. Create statement object
            Statement myStatement = myConnection.createStatement();

//                //3. Execute query
//                ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM Company");
//
//                //4. Process resultSet
//
//                while(myResultSet.next()) {
//                    System.out.println("Company Name: " + myResultSet.getString("c_name") + "P");
//                }

//                PriceGenerator pg = new PriceGenerator("Company");
//                pg.updateStockPrices(myConnection);


//                System.out.println(DBCmd.login("bggoodman", "133", myConnection));
//            System.out.println(DBCmd.createAccount("bearb", "133", "Edwin", "Chen", myConnection));
//            System.out.println(DBCmd.createPortfolio("bggoodman", "super performance tech equity", myConnection));


//            System.out.println(DBCmd.buyShares("bggoodman", "MSFT", "NASDAQ", 100, "super performance equity", myConnection));

            Records records = DBCmd.getTradesByPortfolio("bggoodman", "super performance equity", myConnection);

            while(!records.isEmpty()) {
                Map<String, String> re =records.getNextRecord();
                StringBuilder sb = new StringBuilder();
                for(Map.Entry<String,String> entry : re.entrySet()) {
                    sb.append(entry.getKey() + ": " + entry.getValue() + " ");
                }

                System.out.println(sb);
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
