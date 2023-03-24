package org.greenSnake;

import org.flywaydb.core.Flyway;

public class DevMigrations {
    private static final String url = "jdbc:h2:./myDb";
    public static void main(String[] args){
        Flyway flyway = Flyway
                .configure()
                .dataSource(url,null,null)
                .load();
        flyway.migrate();

    }
}
