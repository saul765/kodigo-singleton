import domain.DatabaseConnection;
import domain.DbConfig;
import mapper.DbCredentialsMapper;
import utils.FileManager;

public class Main {
    public static void main(String[] args) {

        try {

            FileManager fileManager = FileManager.getInstance();

            String connectionString = fileManager.readFile("src/connection.txt");

            DbConfig dbConfig = DbCredentialsMapper.map(connectionString);

            DatabaseConnection database = DatabaseConnection.getInstance(dbConfig);

            System.out.println(database.getUrl());
            System.out.println(database.getUsername());
            System.out.println(database.getPassword());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}