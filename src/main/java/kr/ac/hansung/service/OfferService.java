package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDAO;
import kr.ac.hansung.model.Offer;

@Service
public class OfferService {
	
	@Autowired
	private OfferDAO offerDao;

	public List<Offer> getCurrent(int year, int semester) {
		
		return offerDao.getSemesterOffers(year, semester);
	}
	
	public List<Offer> getCurrentAll() {
		return offerDao.getOffers();
	}
	

	public void insert(Offer offer) {
		offerDao.insert(offer);
	}
}
