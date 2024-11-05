package com.luisguilherme.parts_catalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luisguilherme.parts_catalog.entities.Part;

@Repository
public interface PartRepository extends JpaRepository <Part, Long>{

	@Query(nativeQuery = true, value = """
			SELECT DISTINCT * FROM tb_part
			INNER JOIN part_code ON part_code.part_id = tb_part.id
			WHERE part_code.code like UPPER(CONCAT('%', :code, '%'))
		""")
	List<Part> findByCode(String code);
	
	@Query(nativeQuery = true, value = """
			SELECT DISTINCT * FROM tb_part
			INNER JOIN part_original_code ON part_original_code.part_id = tb_part.id
			WHERE part_original_code.original_code like UPPER(CONCAT('%', :code, '%'))
		""")
	List<Part> findByOriginalCode(String code);
	
	@Query(nativeQuery = true, value = """
			SELECT DISTINCT * FROM tb_part
			INNER JOIN part_starter_alternator ON part_starter_alternator.part_id = tb_part.id
			WHERE part_starter_alternator.starter_alternator like UPPER(CONCAT('%', :code, '%'))
		""")
	List<Part> findByStarterAlternatorCode(String code);
	
}
