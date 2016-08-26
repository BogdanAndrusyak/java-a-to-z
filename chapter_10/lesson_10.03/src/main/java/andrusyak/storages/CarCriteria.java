package andrusyak.storages;

import andrusyak.models.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Used for the preparation query criteria.
 * For each request creates a new object. I think this class can be implement like Singleton (only one).
 * Created by Bogdan on 8/25/2016.
 */
public class CarCriteria {
    private SessionFactory factory = HibernateFactory.getFactory();

    private CriteriaQuery<Car> criteriaQuery;
    private CriteriaBuilder builder;
    private Root<Car> carRoot;

    private List<Predicate> predicates = new ArrayList<>();

    public CarCriteria() {
        try(Session session = factory.openSession()) {
            builder = session.getCriteriaBuilder();
            criteriaQuery = builder.createQuery(Car.class);
            carRoot = criteriaQuery.from(Car.class);
    }

    criteriaQuery.select(carRoot);
}
    public void brandLike(String value) {
        predicates.add(builder.equal(carRoot.get("brand"), value));
    }

    public void modelLike(String value) {
        predicates.add(builder.equal(carRoot.get("model"), value));
    }

    public void typeBodyLike(String value) {
        predicates.add(builder.equal(carRoot.get("typeBody"), value));
    }

    public void yearFrom(int value) {
        predicates.add(builder.greaterThanOrEqualTo(carRoot.get("year"), value));
    }

    public void yearTo(int value) {
        predicates.add(builder.lessThanOrEqualTo(carRoot.get("year"), value));
    }

    public void priceFrom(int value) {
        predicates.add(builder.greaterThanOrEqualTo(carRoot.get("price"), value));
    }

    public void priceTo(int value) {
        predicates.add(builder.lessThanOrEqualTo(carRoot.get("price"), value));
    }

    public List<Car> getResult() {
        List<Car> result = new ArrayList<>();

        criteriaQuery.where(predicates.toArray(new Predicate[]{})); // todo M A G I C !!

        try(Session session = factory.openSession()) {
            result = session.createQuery(criteriaQuery).list();
        }
        return result;
    }
}
