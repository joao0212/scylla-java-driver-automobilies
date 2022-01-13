package com.br.car;

import com.datastax.driver.core.Row;

public class CarRowMapper {
    private final Row row;

    public CarRowMapper(Row row) {
            this.row = row;
    }

    public Car buildCar() {
        return new Car(row.getUUID(0), row.getString(1), row.getString(2), row.getString(3));
    }
}
