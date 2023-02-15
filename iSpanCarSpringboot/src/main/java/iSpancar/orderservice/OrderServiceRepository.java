package iSpancar.orderservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderServiceRepository extends JpaRepository<OrderServiceBean, String> {

}
