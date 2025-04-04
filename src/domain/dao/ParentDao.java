package domain.dao;

public class ParentDao {
//    public static final String DRIVER = "org.h2.Driver";
//    public static final String URL = "jdbc:h2:tcp://localhost/~/books";
//    public static final String USER = "sa";
//    public static final String PASSWORD = "";
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    public static final String USER = "hr";
    public static final String PASSWORD = "hr";

    public ParentDao() {
        try {
            Class.forName(DRIVER);
            System.out.println("1. driver loading ok!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

