package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {

	private final DeptMapper deptMapper;

	@Override
	public List<DeptVO> findAll() {
		// TODO Auto-generated method stub
		return deptMapper.selectDeptAll();
	}

	@Override
	public DeptVO findByDeptId(DeptVO deptVO) {
		return deptMapper.selectDept(deptVO);
	}

	@Override
	public int addDeptInfo(DeptVO deptVO) {
		int result = deptMapper.insertDept(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	}

	@Override
	public Map<String, Object> modifyDeptInfo(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		int result = deptMapper.updateDept(deptVO.getDepartmentId(), deptVO);
		if (result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", deptVO);

		return map;
	}

	@Override
	public Map<String, Object> removeDeptInfo(int deptId) {
		Map<String, Object> map = new HashMap<>();
		int result = deptMapper.deleteDept(deptId);
		if (result == 1) {
			map.put("departmentId", deptId);
		} else {
			map.put("false", "deptId Error");
		}

		return map;
	}

}
