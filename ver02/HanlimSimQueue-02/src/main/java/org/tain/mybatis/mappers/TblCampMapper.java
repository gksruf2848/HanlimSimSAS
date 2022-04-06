package org.tain.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblCampMapper {

	List<Map<String,Object>> selectAll(Map<String,Object> mapIn);
	List<Map<String,Object>> selectFlagN(Map<String,Object> mapIn);
	List<Map<String,Object>> selectOne(Map<String,Object> mapIn);
	int insertOne(Map<String,Object> mapIn);
	int updateById(Map<String,Object> mapIn);
}
