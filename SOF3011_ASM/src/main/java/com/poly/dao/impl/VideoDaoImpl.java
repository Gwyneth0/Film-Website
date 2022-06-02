package com.poly.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.poly.dao.AbstractDao;
import com.poly.dao.VideoDao;
import com.poly.entity.Video;
import com.poly.util.JpaUtil;

public class VideoDaoImpl extends AbstractDao<Video> implements VideoDao {

	@Override
	public Video findById(Integer id) {
		return super.findById(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		String sql= "SELECT o FROM Video o WHERE o.href=?0";
		return super.findOne(Video.class, sql, href);
	}
	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, true);
	}
	protected EntityManager em = JpaUtil.getEntityManager();
	
	public List<Video> selectTop10Ran() {
		String sql = "SELECT TOP 10 * FROM Videos ORDER BY newid()";
		Query query = em.createNativeQuery(sql, Video.class);
		return query.getResultList();
	}
	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return super.findAll(Video.class, true, pageNumber, pageSize);
	}

}
