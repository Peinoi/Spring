package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.app.mybatis.common.MybatisSqlSessionFactory;
import com.yedam.app.mybatis.service.EmpVO;

// 구현객체 => Mybatis가 자동으로 생성 가능
public class EmpMapperImpl implements EmpMapper {
	private SqlSessionFactory factory = MybatisSqlSessionFactory.getSqlSessionFactory();

	@Override
	public List<EmpVO> selectAll() {
		// try-with-resources : 자동으로 자원을 닫아줌
		try (SqlSession session = factory.openSession()) {
			List<EmpVO> list = session.selectList("com.yedam.app.mybatis.mapper.EmpMapper.selectAll");
			return list;
		}
	}

	@Override
	public EmpVO selectInfo(EmpVO emp) {
		// try-with-resources : 자동으로 자원을 닫아줌
		try (SqlSession session = factory.openSession()) {
			EmpVO find = session.selectOne(//
					"com.yedam.app.mybatis.mapper.EmpMapper.selectInfo", //
					emp);
			return find;
		}
	}

	@Override
	public int insertInfo(EmpVO emp) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.insert(//
					"com.yedam.app.mybatis.mapper.EmpMapper.insertInfo", //
					emp);
			return result;
		}
	}

	@Override
	public int updateInfo(EmpVO emp) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.update(//
					"com.yedam.app.mybatis.mapper.EmpMapper.updateInfo", //
					emp);
			return result;
		}
	}

	@Override
	public int deleteInfo(int empId) {
		try (SqlSession session = factory.openSession(true)) {
			int result = session.delete(//
					"com.yedam.app.mybatis.mapper.EmpMapper.deleteInfo", //
					empId);
			return result;
		}
	}

}
