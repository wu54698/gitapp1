package iSpancar.Service;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class iSpanCarService {
	@Autowired
	private ServiceDao sDao;

	public ServiceBean insert(ServiceBean sBean) {
		return sDao.addService(sBean);
	}

	public ServiceBean update(ServiceBean sBean) {
		return sDao.updateByServiceBean(sBean);
	}

	public ServiceBean findByService(String service_name) {
		return sDao.findByService(service_name);
	}

	public boolean deleteService(ServiceBean sBean) {
		return sDao.deleteService(sBean);
	}
//	public List<ServiceBean> findAllService(ServiceBean sBean) {
//		return sDao.findAllService();

	public ServiceBean findCarimage(String service_name) throws SQLException {
		ServiceBean sBean = sDao.fileToBlob(service_name);

		return sBean;
	}

	public List<ServiceBean> findAllService() throws SQLException {
		List<ServiceBean> list = sDao.findAllService();
		return list;
	}

	public ServiceBean updateByCarDealName(ServiceBean bean) {
		// TODO Auto-generated method stub
		ServiceBean sBean = sDao.updateByServiceBean(bean);	
		return sBean;
	}

	public Blob filetoBlob(InputStream is, long size) {
		// TODO Auto-generated method stub
		return null;
	}
}
