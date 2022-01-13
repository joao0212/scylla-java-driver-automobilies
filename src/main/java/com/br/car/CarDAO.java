package com.br.car;

import com.br.config.ClusterScyllaConfig;
import com.datastax.driver.core.*;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarDAO {

    private final Session session;

    public CarDAO(ClusterScyllaConfig clusterScyllaConfig) {
        Cluster cluster = clusterScyllaConfig.buildCluster();
        this.session = cluster.connect("automobilies");
    }

    public void save(Car car) {
        PreparedStatement ps =
                session.prepare
                        ("INSERT INTO car (id, color, brand, model) VALUES (?, ?, ?, ?)");
        BoundStatement bs = ps.bind(car.getId(), car.getColor(), car.getBrand(), car.getModel());
        session.execute(bs);
    }

    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        PreparedStatement ps = session.prepare("SELECT * FROM car");
        BoundStatement bs = ps.bind();
        ResultSet rs = session.execute(bs);

        for (Row row: rs) {
            Car car = new CarRowMapper(row).buildCar();
            cars.add(car);
        }
        return cars;
    }
}
