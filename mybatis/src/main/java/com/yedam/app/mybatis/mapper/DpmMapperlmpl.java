package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.app.mybatis.common.MybatisSqlSessionFactory;
import com.yedam.app.mybatis.service.DpmVO;


public class DpmMapperlmpl implements DpmMapper {
	private SqlSessionFactory factory = MybatisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<DpmVO> dselectAll() {
		try (SqlSession session = factory.openSession()) {
			List<DpmVO> list = session.selectList("com.yedam.app.mybatis.mapper.DpmMapper.dselectAll");
			return list;
		}
	}

	@Override
	public DpmVO dselectInfo(DpmVO dpm) {
		try (SqlSession session = factory.openSession()) {
			DpmVO find = session.selectOne(//
					"com.yedam.app.mybatis.mapper.DpmMapper.dselectInfo", //
					dpm);
			return find;
		}
	}

	@Override
	public int dinsertInfo(DpmVO dpm) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.insert(//
					"com.yedam.app.mybatis.mapper.DpmMapper.dinsertInfo", //
					dpm);
			return result;
		}
	}

	@Override
	public int dupdateInfo(DpmVO dpm) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.update(//
					"com.yedam.app.mybatis.mapper.DpmMapper.dupdateInfo", //
					dpm);
			return result;
		}
	}

	@Override
	public int ddeleteInfo(int id) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.delete(//
					"com.yedam.app.mybatis.mapper.DpmMapper.ddeleteInfo", //
					id);
			return result;
		}
	}

}
