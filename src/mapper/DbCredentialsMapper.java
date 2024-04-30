package mapper;

import domain.DbConfig;

import java.util.Arrays;

public class DbCredentialsMapper {

    private static final String DATABASE_KEY = "database";

    private static final String USERNAME_KEY = "username";

    private static final String PASSWORD_KEY = "password";

    private static final String SEPARATOR = "=";

    public DbCredentialsMapper() {
    }

    public static DbConfig map(String connectionString) {

        String[] lines = connectionString.split("\n");

        DbConfig dbConfig = new DbConfig();

        Arrays.stream(lines).map(line -> line.split(SEPARATOR)).forEach(line -> {
            switch (line[0]) {
                case DATABASE_KEY:
                    dbConfig.setUrl(line[1]);
                    break;
                case USERNAME_KEY:
                    dbConfig.setUsername(line[1]);
                    break;
                case PASSWORD_KEY:
                    dbConfig.setPassword(line[1]);
                    break;
            }
        });

        return dbConfig;
    }
}
