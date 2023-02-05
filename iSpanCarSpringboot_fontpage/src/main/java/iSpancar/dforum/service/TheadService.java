package iSpancar.dforum.service;

import iSpancar.dforum.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TheadService extends JpaRepository<Thread, Integer> {
}
