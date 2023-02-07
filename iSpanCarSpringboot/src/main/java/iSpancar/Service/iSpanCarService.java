package iSpancar.Service;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class iSpanCarService {
	@Autowired
	private ServiceRepository sRepo;

	public ServiceBean insert(ServiceBean sBean) {
		return sRepo.save(sBean);
	}

	public ServiceBean update(ServiceBean sBean) {
		return sRepo.save(sBean);
	}

	public ServiceBean findByService(String servicename) {
		Optional<ServiceBean> op = sRepo.findById(servicename);
		ServiceBean s1 = null;

		if (op.isPresent()) {
			s1 = op.get();
		}

		return s1;
	}

	public boolean deleteService(ServiceBean sBean3) {
		sRepo.delete(sBean3);
		return false;
	}

	public ServiceBean updateByCarDealName(ServiceBean bean) {
		// TODO Auto-generated method stub
		ServiceBean sBean = sRepo.save(bean);
		return sBean;
	}

	public ServiceBean findCarimage(String servicename) throws SQLException {
		Optional<ServiceBean> op2 = sRepo.findById(servicename);

		ServiceBean s1 = null;

		if (op2.isPresent()) {
			s1 = op2.get();
		}

		return s1;
	}

	public List<ServiceBean> findAllService() throws SQLException {
		List<ServiceBean> list = sRepo.findAll();
		return list;
	}

	public Blob filetoBlob(InputStream is, long size) {
		// TODO Auto-generated method stub
		return null;
	}
}
